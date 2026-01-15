import re
import sys
import os
from collections import defaultdict

class VirtualNode:
    def __init__(self, name, node_type=""):
        self.name = name
        self.node_type = node_type
        self.properties = {}  # key -> value (string)
        self.array_properties = defaultdict(dict) # key -> index -> value
        self.children = {}  # name -> VirtualNode
        self.comments = []

    def set_property(self, key, value):
        self.properties[key] = value

    def set_array_property(self, key, index, value):
        self.array_properties[key][index] = value

    def get_child(self, name):
        return self.children.get(name)

    def add_child(self, name, node_type=""):
        if name not in self.children:
            self.children[name] = VirtualNode(name, node_type)
        elif node_type:
             self.children[name].node_type = node_type # Update type if provided later
        return self.children[name]

    def remove_child(self, name):
        if name in self.children:
            del self.children[name]

    def __repr__(self):
        return f"Node({self.name}, {self.node_type})"

    def dump(self, indent=0, buffer=None):
        prefix = "  " * indent
        buffer.write(f"{prefix}- {self.name} [{self.node_type}]\n")
        # Dump props
        for k, v in self.properties.items():
            buffer.write(f"{prefix}  .set('{k}', '{v}')\n")
        for k, v in self.array_properties.items():
            buffer.write(f"{prefix}  .setIndex('{k}', ... {len(v)} items)\n")
        
        # Dump children
        for child in self.children.values():
            child.dump(indent + 1, buffer)

class ComsolParser:
    def __init__(self):
        self.root = VirtualNode("model", "Model")
        # Regex patterns
        # create: allow boolean or string for 2nd arg.
        # Group 1: path, Group 2: name, Group 3: type/bool (raw or quoted)
        self.create_pattern = re.compile(r'model\.(.+?)\.create\("([^"]+)"(?:, (?:")?([^",\)]+)(?:")?)?\);')
        
        self.remove_pattern = re.compile(r'model\.(.+?)\.remove\("([^"]+)"\);')
        
        # set: Group 1: path, Group 2: key, Group 3: val (quoted)
        self.set_pattern = re.compile(r'model\.(.+?)\.set\("([^"]+)", "([^"]+)"\);')
        # set raw: Group 1: path, Group 2: key, Group 3: val (unquoted boolean/number)
        self.set_pattern_raw = re.compile(r'model\.(.+?)\.set\("([^"]+)", ([^"]+)\);')
        
        # setIndex: Group 1: path, Group 2: key, Group 3: val (quoted), Group 4: index
        self.set_index_pattern = re.compile(r'model\.(.+?)\.setIndex\("([^"]+)", "([^"]+)", ([0-9]+)(?:, [0-9]+)?\);')
        # setIndex raw: Group 1: path, Group 2: key, Group 3: val (unquoted), Group 4: index
        self.set_index_pattern_raw = re.compile(r'model\.(.+?)\.setIndex\("([^"]+)", ([^",]+), ([0-9]+)(?:, [0-9]+)?\);')

        self.label_pattern = re.compile(r'model\.(.+?)\.label\("([^"]+)"\);')
        self.descr_pattern = re.compile(r'model\.(.+?)\.descr\("([^"]+)", "([^"]+)"\);')
        
        # Paths
        self.nav_pattern = re.compile(r'\.([a-zA-Z0-9_]+)\("([^"]+)"\)') # .component("comp1")
        self.nav_simple_pattern = re.compile(r'\.([a-zA-Z0-9_]+)\(\)')   # .result()

    def parse_file(self, file_path):
        with open(file_path, 'r', encoding='utf-8') as f:
            lines = f.readlines()

        for line in lines:
            line = line.strip()
            if not line.startswith("model."):
                continue
            
            # 1. CREATE
            match = self.create_pattern.search(line)
            if match:
                path_str, name, type_str = match.groups()
                # print(f"DEBUG: Create {name} at {path_str}")
                parent = self._resolve_path(path_str)
                if parent:
                    parent.add_child(name, type_str if type_str else "")
                continue

            # 2. REMOVE
            match = self.remove_pattern.search(line)
            if match:
                path_str, name = match.groups()
                parent = self._resolve_path(path_str)
                if parent:
                    # Special case: Param remove can take string array, handle simple string for now
                    parent.remove_child(name)
                continue

            # 3. SET (String value)
            match = self.set_pattern.search(line)
            if match:
                path_str, key, val = match.groups()
                node = self._resolve_path(path_str)
                if node:
                    node.set_property(key, val)
                continue
            
             # 3b. SET (Raw value - int/bool)
            match = self.set_pattern_raw.search(line)
            if match:
                path_str, key, val = match.groups()
                node = self._resolve_path(path_str)
                # Filter out new String[] arrays for now, too complex for regex simple pass
                if "new String" not in val and node:
                     node.set_property(key, val)
                continue

            # 4. SET INDEX
            match = self.set_index_pattern.search(line)
            if match:
                path_str, key, val, idx = match.groups()
                node = self._resolve_path(path_str)
                if node:
                    node.set_array_property(key, int(idx), val)
                continue

            match = self.set_index_pattern_raw.search(line)
            if match:
                path_str, key, val, idx = match.groups()
                node = self._resolve_path(path_str)
                if node:
                    node.set_array_property(key, int(idx), val)
                continue
            
             # 5. DESCR (Specific to param usually)
            match = self.descr_pattern.search(line)
            if match:
                path_str, name, desc = match.groups()
                node = self._resolve_path(path_str)
                if node:
                     # Access the child param
                     child = node.get_child(name)
                     if child:
                         child.set_property("_descr", desc)
                continue
            
            # 6. LABEL
            match = self.label_pattern.search(line)
            if match:
                path_str, label = match.groups()
                node = self._resolve_path(path_str)
                if node:
                    node.set_property("_label", label)
                continue


    def _resolve_path(self, path_str):
        # path_str example: component().physics("ge").feature("ge1")
        # Split by dots, but ignore dots in quotes (simplified for now)
        segments = [s for s in path_str.split('.') if s]
        
        current_node = self.root
        
        for seg in segments:
            # Check for name: component("comp1")
            # match is robust enough for "component("comp1")"
            # allow quotes inside the parens
            match_name = self.nav_pattern.match("." + seg)
            if match_name:
                type_name, name = match_name.groups()
                # print(f"DEBUG: Nav to {name} (type {type_name})")
                child = current_node.get_child(name)
                # If child exists, only update type if it was generic before or empty
                if child:
                    if child.node_type == "" or (child.node_type in ["feature", "component"] and type_name not in ["feature", "component"]):
                         child.node_type = type_name
                else:
                     child = current_node.add_child(name, type_name) 
                current_node = child
                continue
            
            # Check for simple: component() -> usually means "create new" or "access list"
            # In COMSOL API component() returns a list or container.
            # But model.component().create() -> the .component() part is just a navigator to the container.
            # We can basically ignore the container descriptors like 'component()', 'physics()' if they are followed by 'create'
            # But if they are intermediate like model.component("c1")... that is handled above.
            
            # If we see 'param()' it usually refers to the singleton param list if no name
            if seg == "param()":
                 # Global parameters are often just model.param()
                 # Let's treat it as a child named "param"
                 child = current_node.get_child("param")
                 if not child:
                     child = current_node.add_child("param", "Parameters")
                 current_node = child
            
            # Generic catch for singleton accessors like study() (list) -> ignore
            # Because usually it is followed by .create or .("name")
            pass

        return current_node

class CodeGenerator:
    def __init__(self, root):
        self.root = root
        self.lines = []

    def generate(self):
        self.lines.append("import com.comsol.model.*;")
        self.lines.append("import com.comsol.model.util.*;")
        self.lines.append("")
        self.lines.append("public class tritum_cycle_clean {")
        self.lines.append("  public static Model run() {")
        self.lines.append("    Model model = ModelUtil.create(\"Model\");")
        self.lines.append("")
        
        # 1. Parameters
        params = self.root.get_child("param")
        if params:
            self._emit_params(params)

        # 2. Components
        # Find all children that act like components. Usually we have to iterate explicitly.
        # Since our structure is loose, we traverse the 'component' children of root?
        # Our parser logic put 'comp1' directly under root if the path was model.component("comp1")
        # Wait, my resolver puts 'comp1' under root? 
        # path: component("comp1") -> matches nav_pattern. 
        # segments: ['component("comp1")']
        # current=root. valid? 
        # match puts type="component", name="comp1"
        # root.add_child("comp1") -> so 'comp1' is direct child of root? 
        # NO. logic: child = current_node.get_child(name).
        # So yes, 'comp1' is child of 'model' named 'comp1'.
        
        # We need to sort children by type to emit in correct order
        # But types are strings.
        
        # Let's emit specific known children types
        # 2. Components
        # Emitting explicit components
        for child_name, child_node in self.root.children.items():
            if "comp" in child_name: 
                 self._emit_component(child_node)

        # 2b. Global Definitions (Variables, Functions, etc) - appearing at root
        # Iterate all other keys that are NOT param, comp, study, solver, result
        known_roots = ["param", "model"]
        for child_name, child_node in self.root.children.items():
            if child_name in known_roots: continue
            if "comp" in child_name: continue
            if child_name.startswith("std") or child_name.startswith("sol"): continue
            if child_name.startswith("pg") or child_name.startswith("gev") or child_name.startswith("tbl"): continue
            
            # Heuristic map based on type or name
            # var -> variable, an -> func (Analytic), pw -> func (Piecewise), mat -> material
            if child_node.node_type == "variable" or child_name.startswith("var"):
                 self.lines.append(f'    model.variable().create("{child_name}");')
                 self._emit_props_recursive(f'model.variable("{child_name}")', child_node)
            elif child_node.node_type in ["Analytic", "Piecewise", "Interpolation"] or child_name.startswith("an") or child_name.startswith("pw"):
                 # model.func().create("an1", "Analytic")
                 t = child_node.node_type if child_node.node_type else ("Analytic" if child_name.startswith("an") else "Piecewise")
                 self.lines.append(f'    model.func().create("{child_name}", "{t}");')
                 self._emit_props_recursive(f'model.func("{child_name}")', child_node)
            elif child_node.node_type == "material" or child_name.startswith("mat"):
                 self.lines.append(f'    model.material().create("{child_name}", "Common");')
                 self._emit_props_recursive(f'model.material("{child_name}")', child_node)
            else:
                 # Fallback generic
                 # self.lines.append(f'    model.create("{child_name}", "{child_node.node_type}");')
                 pass

        # 3. Studies
        study_nodes = {k: v for k,v in self.root.children.items() if k.startswith("std")}
        for name, node in study_nodes.items():
            self._emit_study(name, node)

        # 4. Solvers
        sol_nodes = {k: v for k,v in self.root.children.items() if k.startswith("sol")}
        for name, node in sol_nodes.items():
             self._emit_solver(name, node)
             
        # 5. Results (PlotGroups, etc)
        pg_nodes = {k: v for k,v in self.root.children.items() if k.startswith("pg") or k.startswith("gev") or k.startswith("tbl")}
        for name, node in pg_nodes.items():
             self._emit_result(name, node)
        
        self.lines.append("    return model;")
        self.lines.append("  }")
        self.lines.append("")
        self.lines.append("  public static void main(String[] args) {")
        self.lines.append("    run();")
        self.lines.append("  }")
        self.lines.append("}")
        return "\n".join(self.lines)

    def _emit_params(self, param_node):
        self.lines.append("    // Global Parameters") 
        for key, val in param_node.properties.items():
            if key.startswith("_"): continue 
            self.lines.append(f'    model.param().set("{key}", "{val}");')
            p_child = param_node.get_child(key)
            if p_child and "_descr" in p_child.properties:
                self.lines.append(f'    model.param().descr("{key}", "{p_child.properties["_descr"]}");')
        self.lines.append("")

    def _emit_component(self, comp_node):
        self.lines.append(f'    model.component().create("{comp_node.name}", true);')
        
        # Children of component: Physics, Variables, Functions, Materials, Mesh...
        for child_name, child_node in comp_node.children.items():
            # Heuristics based on type or name
            if child_node.node_type == "variable" or child_name.startswith("var"):
                 self.lines.append(f'    model.component("{comp_node.name}").variable().create("{child_name}");')
                 self._emit_props_recursive(f'model.component("{comp_node.name}").variable("{child_name}")', child_node)
            
            elif child_node.node_type in ["Analytic", "Piecewise"]: # Local functions
                 self.lines.append(f'    model.component("{comp_node.name}").func().create("{child_name}", "{child_node.node_type}");')
                 self._emit_props_recursive(f'model.component("{comp_node.name}").func("{child_name}")', child_node)
            
            elif child_name == "mesh": # Mesh
                 # model.component("c1").mesh("mesh1")
                 # Actually usually created automatically? Or explicit create.
                 pass

            else:
                 # Default to Physics if not variable/func
                 # Physics usually created via .physics().create("ge", "GlobalEquations")
                 # Only create if valid type
                 if child_node.node_type:
                      self.lines.append(f'    model.component("{comp_node.name}").physics().create("{child_name}", "{child_node.node_type}");')
                      self._emit_physics_features(comp_node.name, child_name, child_node)

    def _emit_physics_features(self, comp_name, phys_name, phys_node):
         # Emit properties of the physics node itself (often missed)
         self._emit_props_recursive(f'model.component("{comp_name}").physics("{phys_name}")', phys_node)

         for feat_name, feat_node in phys_node.children.items():
             # Handle 'prop' nodes (properties) vs 'feature' nodes
             if feat_node.node_type == "prop":
                 self._emit_properties(comp_name, phys_name, feat_name, feat_node)
             else:
                 # Only create if type is specific (not "feature" which implies default/generic accessor)
                 if feat_node.node_type != "feature":
                     self.lines.append(f'    model.component("{comp_name}").physics("{phys_name}").create("{feat_name}", "{feat_node.node_type}");')
                 self._emit_feature_properties(comp_name, phys_name, feat_name, feat_node)

    def _emit_properties(self, comp_name, phys_name, prop_name, prop_node):
        base_path = f'model.component("{comp_name}").physics("{phys_name}").prop("{prop_name}")'
        for key, val in prop_node.properties.items():
             self.lines.append(f'    {base_path}.set("{key}", "{val}");')
             
    def _emit_feature_properties(self, comp_name, phys_name, feat_name, feat_node):
         base_path = f'model.component("{comp_name}").physics("{phys_name}").feature("{feat_name}")'

         # Standard properties
         for key, val in feat_node.properties.items():
             if key.startswith("_"): continue
             self.lines.append(f'    {base_path}.set("{key}", "{val}");')

         # Arrays (setIndex)
         for prop_key, indices in feat_node.array_properties.items():
             # Sort indices
             sorted_idx = sorted(indices.keys())
             for idx in sorted_idx:
                 val = indices[idx]
                 self.lines.append(f'    {base_path}.setIndex("{prop_key}", "{val}", {idx});')

    def _emit_study(self, name, node):
        self.lines.append(f'    model.study().create("{name}");')
        for child_name, child_node in node.children.items():
            # Usually creates features like "time", "stat", etc.
            self.lines.append(f'    model.study("{name}").create("{child_name}", "{child_node.node_type}");')
            base = f'model.study("{name}").feature("{child_name}")'
            self._emit_props_recursive(base, child_node)
            
    def _emit_solver(self, name, node):
        self.lines.append(f'    model.sol().create("{name}");')
        # Solvers are complex nested structures
        # model.sol("sol1").study("std1")
        if "study" in node.properties:
             self.lines.append(f'    model.sol("{name}").study("{node.properties["study"]}");')
        
        self._emit_props_recursive(f'model.sol("{name}")', node)
        self._emit_children_recursive(f'model.sol("{name}")', node)

    def _emit_result(self, name, node):
        # Result features are often model.result().create("pg1", ...)
        # or model.result().numerical().create("gev1", ...)
        # My parser puts them at root. 
        # But we need to know if it is numerical or plotgroup.
        # Simple heuristic based on name/type or just generic result().create
        if name.startswith("tbl"):
             self.lines.append(f'    model.result().table().create("{name}", "{node.node_type if node.node_type else "Table"}");')
             self._emit_props_recursive(f'model.result().table("{name}")', node)
        elif name.startswith("gev"):
             self.lines.append(f'    model.result().numerical().create("{name}", "{node.node_type if node.node_type else "EvalGlobal"}");')
             self._emit_props_recursive(f'model.result().numerical("{name}")', node)
        else:
             self.lines.append(f'    model.result().create("{name}", "{node.node_type if node.node_type else "PlotGroup1D"}");')
             self._emit_props_recursive(f'model.result("{name}")', node)

    def _emit_props_recursive(self, base_path, node):
        for key, val in node.properties.items():
             if key.startswith("_") or key == "study": continue
             self.lines.append(f'    {base_path}.set("{key}", "{val}");')
        
        for key, indices in node.array_properties.items():
             sorted_idx = sorted(indices.keys())
             for idx in sorted_idx:
                 self.lines.append(f'    {base_path}.setIndex("{key}", "{indices[idx]}", {idx});')
                 
    def _emit_children_recursive(self, base_path, node):
        for child_name, child_node in node.children.items():
            self.lines.append(f'    {base_path}.create("{child_name}", "{child_node.node_type}");')
            new_base = f'{base_path}.feature("{child_name}")'
            self._emit_props_recursive(new_base, child_node)
            self._emit_children_recursive(new_base, child_node)


if __name__ == "__main__":
    parser = ComsolParser()
    input_file = "tritum_cycle_complete.java"
    if len(sys.argv) > 1:
        input_file = sys.argv[1]
    
    print(f"Parsing {input_file}...")
    parser.parse_file(input_file)
    
    # Dump tree from INPUT (Allocated/Calculated State)
    tree_initial = os.path.join(os.path.dirname(input_file), "tree_initial.txt")
    with open(tree_initial, "w", encoding="utf-8") as f:
        parser.root.dump(buffer=f)
    print(f"Initial State Tree dumped to {tree_initial}")

    print("Generating clean code...")
    generator = CodeGenerator(parser.root)
    code = generator.generate()
    
    output_file = os.path.join(os.path.dirname(input_file), "tritum_cycle_clean.java")
    with open(output_file, 'w', encoding='utf-8') as f:
        f.write(code)
    print(f"Done. Written to {output_file}")
    
    # Verify: Parse the CLEAN file and dump its tree
    print("Verifying: Parsing generated clean file...")
    parser_check = ComsolParser()
    parser_check.parse_file(output_file)
    
    tree_simplified = os.path.join(os.path.dirname(input_file), "tree_simplified.txt")
    with open(tree_simplified, "w", encoding="utf-8") as f:
        parser_check.root.dump(buffer=f)
    print(f"Simplified State Tree dumped to {tree_simplified}")
