import com.comsol.model.*;
import com.comsol.model.util.*;

public class tritum_cycle_clean {
  public static Model run() {
    Model model = ModelUtil.create("Model");

    // Global Parameters
    model.param().set("I13_ini", "0.0[kg]");

    model.component().create("comp1", true);
    model.component("comp1").variable().create("var2");
    model.component("comp1").variable("var2").set("I9_flux", "if(I9>I9_sat, (I9-I9_sat)/T9, 0)");
    model.component("comp1").variable("var2").set("I10_flux", "if(I10>I10_sat, (I10-I10_sat)/T10, 0)");
    model.component("comp1").variable("var2").set("I11_flux", "if(I11>I11_sat, (I11-I11_sat)/T11, 0)");
    model.component("comp1").variable("var2").set("I13_flux", "if(I13>I13_sat, (I13-I13_sat)/T13, 0)");
    model.component("comp1").variable("var2").set("I14_flux", "if(I14>I14_sat, (I14-I14_sat)/T14, 0)");
    model.component("comp1").physics().create("ge", "GlobalEquations");
    model.component("comp1").physics("ge").feature("ge1").set("DependentVariableQuantity", "none");
    model.component("comp1").physics("ge").feature("ge1").set("CustomDependentVariableUnit", "g");
    model.component("comp1").physics("ge").feature("ge1").set("SourceTermQuantity", "none");
    model.component("comp1").physics("ge").feature("ge1").set("CustomSourceTermUnit", "g/s");
    model.component("comp1").physics("ge").prop("EquationForm").set("form", "Automatic");
    model.func().create("an1", "Analytic");
    model.func("an1").set("funcname", "f_pulse");
    model.func("an1").set("expr", "if(x<T_cycle*AF, 1, 0)");
    model.func("an1").set("periodic", "true");
    model.func("an1").set("periodicupper", "T_cycle");
    model.func("an1").set("fununit", "1");
    model.func().create("pw1", "Piecewise");
    model.func("pw1").set("argunit", "s");
    model.func("pw1").set("fununit", "1");
    model.variable().create("var1");
    model.variable("var1").set("N_flux", "f_pulse(t)*0.002654[g/s]");
    model.study().create("std1");
    model.study("std1").create("time", "Transient");
    model.study("std1").feature("time").set("tlist", "range(0,360,86400*300)");
    model.sol().create("sol1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,360,86400*300)");
    model.sol("sol1").feature("t1").set("tstepsbdf", "strict");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").create("dDef", "feature");
    model.sol("sol1").feature("t1").create("aDef", "feature");
    model.result().table().create("tbl1", "Table");
    model.result().numerical().create("gev1", "EvalGlobal");
    model.result().create("pg1", "PlotGroup1D");
    model.result("pg1").set("xlabel", "\u65f6\u95f4 (d)");
    model.result("pg1").set("ylabel", "\u76d8\u5b58\uff08kg\uff09");
    model.result("pg1").set("ylabelactive", "true");
    model.result("pg1").set("xlabelactive", "false");
    model.result().create("pg2", "PlotGroup1D");
    model.result("pg2").set("xlabel", "\u65f6\u95f4 (d)");
    model.result("pg2").set("xlabelactive", "false");
    model.result().create("pg3", "PlotGroup1D");
    model.result("pg3").set("xlabel", "\u65f6\u95f4 (d)");
    model.result("pg3").set("ylabel", "\u6c1a\u5de5\u5382\u4e2d\u6c1a\u603b\u8d28\u91cf (kg)");
    model.result("pg3").set("xlabelactive", "false");
    model.result("pg3").set("ylabelactive", "false");
    model.result().create("pg5", "PlotGroup1D");
    model.result("pg5").set("xlabel", "\u65f6\u95f4 (h)");
    model.result("pg5").set("ylabel", "\u5305\u5c42\u4e2d\u603b\u53d8\u5316 (kg/s)");
    model.result("pg5").set("xlabelactive", "false");
    model.result("pg5").set("ylabelactive", "false");
    return model;
  }

  public static void main(String[] args) {
    run();
  }
}