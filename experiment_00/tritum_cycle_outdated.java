/*
 * tritum_cycle.java
 * Comprehensive Tritium Cycle Model
 * Based on tritum_cycle_complete.java (Run 5 Logic)
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

public class tritum_cycle_outdated {

     public static Model run() {
          Model model = ModelUtil.create("Model");
          model.modelPath("D:\\Administrator\\Documents\\Github\\tricys_mph\\experiment_00");

          // 1. Component & Physics
          model.component().create("comp1", true);
          model.component("comp1").physics().create("ge", "GlobalEquations");
          model.component("comp1").physics("ge").prop("EquationForm").set("form", "Automatic");

          // 2. Analytic Functions (Pulse Operation)
          model.func().create("an1", "Analytic");
          model.func("an1").set("funcname", "f_pulse");
          model.func("an1").label("Periodic Pulse Function");
          model.func("an1").set("expr", "if(x<T_cycle*AF, 1, 0)");
          model.func("an1").set("periodic", true);
          model.func("an1").set("periodicupper", "T_cycle");
          model.func("an1").set("dermethod", "automatic");
          model.func("an1").setIndex("argunit", "s", 0);
          model.func("an1").set("fununit", "1");
          // Plot settings for function (optional but good for debugging in GUI)
          model.func("an1").setIndex("plotargs", "3600*3", 0, 2);

          // 3. Parameters

          // 3.1 Global Physical Parameters
          model.param().label("Global Parameters");
          model.param().set("TBR", "1.1", "Tritium Breeding Ratio");
          model.param().set("beta", "0.06", "Burn efficiency");
          model.param().set("f_e", "0.5", "Fueling efficiency");
          model.param().set("AF", "0.5", "Availability Factor (Duty Cycle)");
          model.param().set("T_cycle", "3[h]", "Operation Cycle Period");
          model.param().set("P_fusion", "1500[MW]", "Fusion Power");
          model.param().set("factor1", "1.7805E-06[g/s/MW]", "Tritium consumption per MW");
          model.param().set("lanmda", "1.78e-9[1/s]", "Decay constant");

          // Note: N_flux is defined as a variable later to be dynamic

          // 3.2 Residence Times (par2)
          model.param().create("par2");
          model.param("par2").label("Residence Times");
          model.param("par2").set("T1", "1[d]", "Breeding Zone"); // Modified to 1 day as per typical complete run
          model.param("par2").set("T1", "0.5[h]", "Fueling System");
          model.param("par2").set("T2", "0.17[h]", "Pumping System");
          model.param("par2").set("T3", "2[h]", "TEP");
          model.param("par2").set("T4", "0.28[h]", "First Wall");
          model.param("par2").set("T5", "0.28[h]", "Divertor");
          model.param("par2").set("T6", "24[h]", "Blanket");
          model.param("par2").set("T7", "24[h]", "FW Coolant");
          model.param("par2").set("T8", "24[h]", "Div Coolant");
          model.param("par2").set("T9", "48[h]", "Coolant Purification");
          model.param("par2").set("T10", "12[h]", "Water Detritiation");
          model.param("par2").set("T11", "6[h]", "Isotope Separation (I-ISS)");
          model.param("par2").set("T12", "0.1[d]", "SDS"); // Often small or 0 if saturated logic dominates
          model.param("par2").set("T13", "6[h]", "Outer ISS (O-ISS)");
          model.param("par2").set("T14", "48[h]", "WDS");
          model.param("par2").set("T15", "5[s]", "Plasma Retention Time");

          // 3.3 Flow Fractions (par3)
          model.param().create("par3");
          model.param("par3").label("Flow Fractions");
          model.param("par3").set("f15_2", "0.9998", "Plasma -> TES (fraction)");
          model.param("par3").set("f15_4", "(1-f15_2)/2", "Plasma -> FW");
          model.param("par3").set("f15_5", "(1-f15_2)/2", "Plasma -> Div");

          model.param("par3").set("f6_7", "0.05", "CPS -> FW Coolant (leakage)");
          model.param("par3").set("f6_10", "1-f6_7", "CPS -> TRU/WDS");

          model.param("par3").set("f7_9", "0.9999", "FW Coolant -> CPS/Purification");
          model.param("par3").set("f7_14", "1-f7_9", "FW Coolant -> WDS");

          model.param("par3").set("f8_9", "0.9999", "Div Coolant -> CPS/Purification");
          model.param("par3").set("f8_14", "1-f8_9", "Div Coolant -> WDS");

          model.param("par3").set("f3_11", "0.15", "TEP -> I-ISS");
          model.param("par3").set("f3_12", "1-f3_11", "TEP -> SDS");

          model.param("par3").set("f11_12", "0.99999999", "I-ISS -> SDS");
          model.param("par3").set("f11_14", "1-f11_12", "I-ISS -> WDS");

          model.param("par3").set("f13_12", "1", "O-ISS -> SDS");

          model.param("par3").set("f9_13", "1", "CPS -> O-ISS");
          model.param("par3").set("f10_13", "1", "WDS/TRU -> O-ISS");
          model.param("par3").set("f14_13", "1", "WDS -> O-ISS");

          // 3.4 Loss Rates (par4)
          model.param().create("par4");
          model.param("par4").label("Loss Rates (epsilon)");
          model.param("par4").set("epsilon1", "1e-4");
          model.param("par4").set("epsilon2", "1e-4");
          model.param("par4").set("epsilon3", "1e-4");
          model.param("par4").set("epsilon4", "0");
          model.param("par4").set("epsilon5", "0");
          model.param("par4").set("epsilon6", "0");
          model.param("par4").set("epsilon7", "1e-4");
          model.param("par4").set("epsilon8", "1e-4");
          model.param("par4").set("epsilon9", "1e-4");
          model.param("par4").set("epsilon10", "1e-4");
          model.param("par4").set("epsilon11", "1e-4");
          model.param("par4").set("epsilon12", "1e-4");
          model.param("par4").set("epsilon13", "1e-4");
          model.param("par4").set("epsilon14", "1e-4");

          // 3.5 Saturation Limits (par5)
          model.param().create("par5");
          model.param("par5").label("Saturation Limits (Inventory)");
          model.param("par5").set("I1_sat", "0[g]");
          model.param("par5").set("I2_sat", "640[g]"); // Example value from complete code
          model.param("par5").set("I3_sat", "0");
          model.param("par5").set("I4_sat", "0");
          model.param("par5").set("I5_sat", "0");
          model.param("par5").set("I6_sat", "0");
          model.param("par5").set("I7_sat", "0");
          model.param("par5").set("I8_sat", "0");
          model.param("par5").set("I9_sat", "200[g]");
          model.param("par5").set("I10_sat", "200[g]");
          model.param("par5").set("I11_sat", "300[g]");
          model.param("par5").set("I12_sat", "3.5[kg]"); // SDS Saturation
          model.param("par5").set("I13_sat", "20[g]");
          model.param("par5").set("I14_sat", "1000[g]");
          model.param("par5").set("I15_sat", "0");

          // Initial Values (Parameters)
          model.param().set("I12_ini", "3.5[kg]");

          // 4. Variables (Flux and Saturation Logic)
          model.component("comp1").variable().create("var1");
          model.component("comp1").variable("var1").label("Flux Variables");

          // N_flux: Consumption Rate (Burn Rate) defined symbolically
          model.component("comp1").variable("var1").set("N_flux", "f_pulse(t)*P_fusion*factor1", "Tritium Burn Rate");

          // Saturation Fluxes: if Inventory > Saturation, excess flows out "instantly"
          // (simulated by dividing by T)
          model.component("comp1").variable("var1").set("I2_flux", "if(I2>I2_sat, (I2-I2_sat)/T2, 0)");
          model.component("comp1").variable("var1").set("I9_flux", "if(I9>I9_sat, (I9-I9_sat)/T9, 0)");
          model.component("comp1").variable("var1").set("I10_flux", "if(I10>I10_sat, (I10-I10_sat)/T10, 0)");
          model.component("comp1").variable("var1").set("I11_flux", "if(I11>I11_sat, (I11-I11_sat)/T11, 0)");
          model.component("comp1").variable("var1").set("I13_flux", "if(I13>I13_sat, (I13-I13_sat)/T13, 0)");
          model.component("comp1").variable("var1").set("I14_flux", "if(I14>I14_sat, (I14-I14_sat)/T14, 0)");

          // 5. Global Equations (I1 - I15)
          // Units
          model.component("comp1").physics("ge").feature("ge1").set("CustomDependentVariableUnit", "g");
          model.component("comp1").physics("ge").feature("ge1").set("CustomSourceTermUnit", "g/s");

          // I1: Fueling System
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I1", 0, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Fueling System", 0, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I1t - N_flux/(beta*f_e) + (1+epsilon1)*I1/T1", 0, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 0, 0);

          // I2: Pumping System
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I2", 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Pumping System", 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I2t - f15_2*I15/T15 + (1+epsilon2)*I2_flux + lanmda*I2", 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 1, 0);

          // I3: TEP
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I3", 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "TEP", 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I3t - I2_flux + (1+epsilon3)*I3/T3 + lanmda*I3", 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 2, 0);

          // I4: First Wall
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I4", 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "First Wall", 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I4t - f15_4*I15/T15 + (1+epsilon4)*I4/T4 + lanmda*I4", 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 3, 0);

          // I5: Divertor
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I5", 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Divertor", 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I5t - f15_5*I15/T15 + (1+epsilon5)*I5/T5 + lanmda*I5", 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 4, 0);

          // I6: Blanket
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I6", 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Blanket", 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I6t - N_flux*TBR + (1+epsilon6)*I6/T6 + lanmda*I6", 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 5, 0);

          // I7: FW Coolant
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I7", 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "FW Coolant", 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I7t - I4/T4 - f6_7*I6/T6 + (1+epsilon7)*I7/T7 + lanmda*I7", 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 6, 0);

          // I8: Div Coolant
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I8", 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Div Coolant", 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I8t - I5/T5 + (1+epsilon8)*I8/T8 + lanmda*I8", 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 7, 0);

          // I9: Coolant Purification
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I9", 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Coolant Purification", 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I9t - f7_9*I7/T7 - f8_9*I8/T8 + (1+epsilon9)*I9_flux + lanmda*I9", 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 8, 0);

          // I10: TES
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I10", 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "TES", 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I10t - f6_10*I6/T6 + (1+epsilon10)*I10_flux + lanmda*I10", 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 9, 0);

          // I11: I-ISS
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I11", 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "I-ISS", 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I11t - f3_11*I3/T3 + (1+epsilon11)*I11_flux + lanmda*I11", 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 10, 0);

          // I12: SDS
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I12", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "SDS", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I12t - f3_12*I3/T3 - f11_12*I11_flux - f13_12*I13_flux + (1+epsilon12)*(N_flux/(f_e*beta)+lanmda*I1) + lanmda*I12",
                    11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "I12_ini", 11, 0);

          // I13: O-ISS
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I13", 12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "O-ISS", 12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I13t - f9_13*I9_flux - f10_13*I10_flux - f14_13*I14_flux + (1+epsilon13)*I13_flux + lanmda*I13",
                    12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 12, 0);

          // I14: WDS
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I14", 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "WDS", 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I14t - f7_14*I7/T7 - f8_14*I8/T8 - f11_14*I11_flux + (1+epsilon14)*I14_flux + lanmda*I14", 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 13, 0);

          // I15: Plasma
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I15", 14, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Plasma", 14, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation",
                    "I15t - N_flux/(f_e*beta) + I15/T15 + N_flux + lanmda*I15", 14, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0", 14, 0);

          // 6. Study (Time Dependent)
          model.study().create("std1");
          model.study("std1").create("time", "Transient");
          model.study("std1").feature("time").setSolveFor("/physics/ge", true);
          model.study("std1").feature("time").set("tunit", "s");
          // Simulate for 360 days (approx 1 year behavior)
          model.study("std1").feature("time").set("tlist", "range(0, 360, 86400*360)");

          // 7. Solver
          model.sol().create("sol1");
          model.sol("sol1").study("std1");

          // Auto-create study steps
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");

          // Variables
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");

          // Time config
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0, 360, 86400*360)");
          model.sol("sol1").feature("t1").set("plot", "off");

          // Solver Constraints: BDF with strict steps can be useful for Pulse
          model.sol("sol1").feature("t1").set("maxstepconstraintbdf", "const");
          model.sol("sol1").feature("t1").set("maxstepbdf", "3600"); // 1 hour max step for pulse resolution

          // Fully Coupled
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef"); // Direct solver often more robust
                                                                                   // for small ODE systems
          model.sol("sol1").feature("t1").feature().remove("fcDef");

          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          // 8. Results & Export
          model.result().numerical().create("gev1", "EvalGlobal");
          model.result().numerical("gev1").set("data", "dset1");
          String[] exprs = new String[] { "I12" };
          model.result().numerical("gev1").set("expr", exprs);

          // Export Data (CSV)
          model.result().export().create("data1", "Data");
          model.result().export("data1").set("data", "dset1");
          model.result().export("data1").set("expr", exprs);
          model.result().export("data1").set("filename",
                    "D:\\Administrator\\Documents\\Github\\tricys_mph\\experiment_00\\tritum_cycle_data.csv");
          model.result().export("data1").run();

          model.result().create("pg1", "PlotGroup1D");
          model.result("pg1").set("data", "dset1");
          model.result("pg1").label("Tritium Inventory (Linear)");
          model.result("pg1").create("glob2", "Global");
          model.result("pg1").feature("glob2").set("expr", exprs);
          model.result("pg1").feature("glob2").set("legend", true);
          model.result("pg1").feature("glob2").set("legendmethod", "manual");
          model.result("pg1").feature("glob2").setIndex("legends", "SDS", 0);
          model.result("pg1").set("xlog", false);
          model.result("pg1").set("ylog", false); // Linear scale
          model.result("pg1").run();

          // Export Image (PNG)
          model.result().export().create("img1", "Image");
          model.result().export("img1").set("sourceobject", "pg1");
          model.result().export("img1").set("filename",
                    "D:\\Administrator\\Documents\\Github\\tricys_mph\\experiment_00\\tritum_cycle_plot.png");
          model.result().export("img1").run();

          return model;
     }

     public static void main(String[] args) {
          Model model = run();
          // System.out.println("Model run complete.");
     }
}
