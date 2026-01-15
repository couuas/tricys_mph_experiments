/*
 * cycle.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Jan 15 2026, 17:18 by COMSOL 6.2.0.290. */
public class cycle {

     public static Model run() {
          Model model = ModelUtil.create("Model");

          model.modelPath("D:\\Administrator\\Desktop");

          model.label("cycle.mph");

          model.param().set("TBR", "1.1", "\u6c1a\u589e\u503c\u6bd4");
          model.param().set("lanmda", "1.78e-9[1/s]", "\u6c1a\u8870\u53d8\u5e38\u6570");
          model.param().set("f_e", "0.5", "\u52a0\u6599\u7cfb\u7edf\u52a0\u6599\u6548\u7387");
          model.param().set("beta", "0.06", "\u7b49\u79bb\u5b50\u4f53\u71c3\u70e7\u7387");
          model.param().set("AF", "0.5", "\u5360\u7a7a\u6bd4");
          model.param().set("T_cycle", "3[h]", "\u8fd0\u884c\u5468\u671f");
          model.param().set("P_fusion", "1500[MW]", "\u805a\u53d8\u529f\u7387");
          model.param()
                    .set("factor1", "1.7805E-06[g/s/(MW)]",
                              "1MW\u805a\u53d8\u529f\u7387\u5bf9\u5e94\u6d88\u8017T\u8d28\u91cf");
          model.param().set("I12_ini", "3.[kg]", "SDS\u4e2d\u521d\u59cb\u6295\u6599\u91cf");
          model.param().set("I13_ini", "0.0[kg]");
          model.param().group().create("par2");
          model.param("par2").set("T1", "0.5[h]", "\u52a0\u6599\u7cfb\u7edf");
          model.param("par2").set("T2", "0.17[h]", "\u7c97\u62bd\u7cfb\u7edf");
          model.param("par2").set("T3", "2[h]", "TEP");
          model.param("par2").set("T4", "0.28[h]", "\u7b2c\u4e00\u58c1");
          model.param("par2").set("T5", "0.28[h]", "\u504f\u6ee4\u5668");
          model.param("par2").set("T6", "24[h]", "\u5305\u5c42");
          model.param("par2").set("T7", "24[h]", "\u7b2c\u4e00\u58c1\u51b7\u5374\u6c34");
          model.param("par2").set("T8", "24[h]", "\u5305\u5c42\u51b7\u5374\u6c34");
          model.param("par2").set("T9", "48[h]", "\u51b7\u5374\u6c34\u51c0\u5316\u7cfb\u7edf");
          model.param("par2").set("T10", "12[h]", "TES");
          model.param("par2").set("T11", "6[h]", "I-ISS");
          model.param("par2").set("T12", "0", "SDS");
          model.param("par2").set("T13", "6[h]", "O-ISS");
          model.param("par2").set("T14", "48[h]", "WDS");
          model.param("par2").set("T15", "5[s]", "\u7b49\u79bb\u5b50\u4f53\u4e2d\u6c1a\u6ede\u7559\u65f6\u95f4");
          model.param().group().create("par3");
          model.param("par3").set("f15_2", "0.9998",
                    "\u4ece\u7b49\u79bb\u5b50\u4f53\u8fdb\u5165\u7c97\u62bd\u4efd\u989d");
          model.param("par3")
                    .set("f15_4", "(1-f15_2)/2",
                              "\u4ece\u7b49\u79bb\u5b50\u4f53\u5230\u7b2c\u4e00\u58c1\u4e2d\u4efd\u989d");
          model.param("par3")
                    .set("f15_5", "(1-f15_2)/2",
                              "\u4ece\u7b49\u79bb\u5b50\u4f53\u5230\u504f\u6ee4\u5668\u4e2d\u4efd\u989d");
          model.param("par3")
                    .set("f6_7", "1-f6_10",
                              "\u5305\u5c42\u6cc4\u9732\u81f3\u7b2c\u4e00\u58c1\u51b7\u5374\u5242\u4efd\u989d");
          model.param("par3")
                    .set("f7_9", "0.9999",
                              "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242\u4e2d\u6c1a\u88ab\u51c0\u5316\u4efd\u989d");
          model.param("par3")
                    .set("f8_9", "0.9999",
                              "\u504f\u6ee4\u5668\u51b7\u5374\u5242\u4e2d\u6c1a\u88ab\u51c0\u5316\u4efd\u989d");
          model.param("par3").set("f6_10", "0.95", "\u5305\u5c42\u4e2d\u6c1a\u63d0\u53d6\u4efd\u989d");
          model.param("par3").set("f3_11", "0.15", "\uff08DIR\uff09TEP\u5230I-ISS\u4efd\u989d");
          model.param("par3").set("f3_12", "1-f3_11", "\uff08DIR\uff09TEP\u5230SDS\u4efd\u989d");
          model.param("par3").set("f11_12", "0.99999999", "I-ISS\u56de\u6536\u81f3SDS\u4efd\u989d");
          model.param("par3").set("f13_12", "1", "O-ISS\u56de\u6536\u81f3SDS\u4efd\u989d");
          model.param("par3").set("f9_13", "1", "\u4eceCPS\u5230O-ISS\u4efd\u989d");
          model.param("par3").set("f10_13", "1", "\u4eceTES\u5230O-ISS\u4efd\u989d");
          model.param("par3").set("f14_13", "1", "\u4eceWDS\u5230O-ISS\u4efd\u989d");
          model.param("par3").set("f7_14", "1-f7_9", "\u4ece\u7b2c\u4e00\u58c1\u51b7\u5374\u5242\u5230WDS\u4efd\u989d");
          model.param("par3").set("f8_14", "1-f8_9", "\u4ece\u504f\u6ee4\u5668\u51b7\u5374\u5242\u5230WDS\u4efd\u989d");
          model.param("par3").set("f11_14", "1-f11_12", "\u4eceI-ISS\u5230WDS\u4efd\u989d");
          model.param().group().create("par4");
          model.param("par4").set("epsilon1", "1e-4", "\u52a0\u6599\u7cfb\u7edf");
          model.param("par4").set("epsilon2", "1e-4", "\u6cf5\u62bd\u7cfb\u7edf");
          model.param("par4").set("epsilon3", "1e-4", "TEP");
          model.param("par4").set("epsilon4", "0", "\u7b2c\u4e00\u58c1");
          model.param("par4").set("epsilon5", "0", "\u504f\u6ee4\u5668");
          model.param("par4").set("epsilon6", "0", "\u5305\u5c42");
          model.param("par4").set("epsilon7", "1e-4", "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242\u56de\u8def");
          model.param("par4").set("epsilon8", "1e-4", "\u504f\u6ee4\u5668\u51b7\u5374\u5242\u56de\u8def");
          model.param("par4").set("epsilon9", "1e-4", "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf");
          model.param("par4").set("epsilon10", "1e-4", "TES");
          model.param("par4").set("epsilon11", "1e-4", "I-ISS");
          model.param("par4").set("epsilon12", "1e-4", "SDS");
          model.param("par4").set("epsilon13", "1e-4", "O-ISS");
          model.param("par4").set("epsilon14", "1e-4", "WDS");
          model.param().group().create("par5");
          model.param("par5").set("I1_sat", "0[g]", "\u52a0\u6599\u7cfb\u7edf");
          model.param("par5").set("I2_sat", "640[g]", "\u6cf5\u62bd\u7cfb\u7edf");
          model.param("par5").set("I3_sat", "0", "TEP");
          model.param("par5").set("I4_sat", "0", "\u7b2c\u4e00\u58c1");
          model.param("par5").set("I5_sat", "0", "\u504f\u6ee4\u5668");
          model.param("par5").set("I6_sat", "0", "\u5305\u5c42");
          model.param("par5").set("I7_sat", "0", "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242");
          model.param("par5").set("I8_sat", "0", "\u5305\u5c42\u51b7\u5374\u5242");
          model.param("par5").set("I9_sat", "200[g]", "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf");
          model.param("par5").set("I10_sat", "200[g]", "TES");
          model.param("par5").set("I11_sat", "300[g]", "I-ISS");
          model.param("par5").set("I12_sat", "0[g]", "SDS");
          model.param("par5").set("I13_sat", "20[g]", "O-ISS");
          model.param("par5").set("I14_sat", "1000[g]", "WDS");
          model.param().label("\u7279\u5f81\u53c2\u6570");
          model.param("par2").label("\u6ede\u7559\u65f6\u95f4");
          model.param("par3").label("Flow rates fractions ");
          model.param("par4").label("\u975e\u653e\u635f\u5931\u7387");
          model.param("par5").label("\u94fa\u5e95\u91cf");

          model.component().create("comp1", true);

          model.result().table().create("tbl1", "Table");

          model.func().create("an1", "Analytic");
          model.func().create("pw1", "Piecewise");
          model.func("an1").label("\u5468\u671f\u5f62\u51fd\u6570");
          model.func("an1").set("funcname", "f_pulse");
          model.func("an1").set("expr", "if(x<T_cycle*AF, 1, 0)");
          model.func("an1").set("periodic", true);
          model.func("an1").set("periodicupper", "T_cycle");
          model.func("an1").set("fununit", "1");
          model.func("an1").set("argunit", new String[] { "s" });
          model.func("an1").set("plotargs", new String[][] { { "x", "0", "3600*6" } });
          model.func("pw1")
                    .set("pieces", new String[][] { { "0", "T_cycle*AF", "1" },
                              { "T_cycle*AF", "T_cycle*(1+0)", "0" },
                              { "T_cycle*(1+0)", "T_cycle*(1+AF)", "1" },
                              { "T_cycle*(1+AF)", "T_cycle*(2+0)", "0" },
                              { "T_cycle*(2+0)", "T_cycle*(2+AF)", "1" },
                              { "T_cycle*(2+AF)", "T_cycle*(3+0)", "0" },
                              { "T_cycle*(3+0)", "T_cycle*(3+AF)", "1" },
                              { "T_cycle*(3+AF)", "T_cycle*(4+0)", "0" },
                              { "T_cycle*(4+0)", "T_cycle*(4+AF)", "1" },
                              { "T_cycle*(4+AF)", "T_cycle*(5+0)", "0" } });
          model.func("pw1").set("argunit", "s");
          model.func("pw1").set("fununit", "1");

          model.variable().create("var1");
          model.variable("var1")
                    .set("N_flux1", "f_pulse(t)*P_fusion*factor1",
                              "\u7b49\u79bb\u5b50\u4f53\u4e2d\u6c1a\u71c3\u70e7\u6d88\u8017\u901f\u7387");
          model.variable("var1").set("N_flux", "f_pulse(t)*0.002654[g/s]");
          model.component("comp1").variable().create("var2");
          model.component("comp1").variable("var2")
                    .set("I2_flux", "if(I2>I2_sat, (I2-I2_sat)/T2, 0)",
                              "\u5e26\u94fa\u5e95\uff0c\u7b49\u6548\u4e8eI/T");
          model.component("comp1").variable("var2").set("I9_flux", "if(I9>I9_sat, (I9-I9_sat)/T9, 0)");
          model.component("comp1").variable("var2").set("I10_flux", "if(I10>I10_sat, (I10-I10_sat)/T10, 0)");
          model.component("comp1").variable("var2").set("I11_flux", "if(I11>I11_sat, (I11-I11_sat)/T11, 0)");
          model.component("comp1").variable("var2").set("I13_flux", "if(I13>I13_sat, (I13-I13_sat)/T13, 0)");
          model.component("comp1").variable("var2").set("I14_flux", "if(I14>I14_sat, (I14-I14_sat)/T14, 0)");

          model.component("comp1").physics().create("ge", "GlobalEquations");
          model.component("comp1").physics("ge").feature("ge1").set("DependentVariableQuantity", "none");
          model.component("comp1").physics("ge").feature("ge1").set("CustomDependentVariableUnit", "g");

          model.result().table("tbl1").comments("\u5168\u5c40\u8ba1\u7b97 1");

          model.component("comp1").variable("var2").label("\u5e26\u94fa\u5e95\u7b49\u6548\u8d28\u91cf\u6d41");

          model.component("comp1").physics("ge").prop("EquationForm").set("form", "Automatic");
          model.component("comp1").physics("ge").feature("ge1")
                    .set("name", new String[][] { { "I1" },
                              { "I2" },
                              { "I3" },
                              { "I4" },
                              { "I5" },
                              { "I6" },
                              { "I7" },
                              { "I8" },
                              { "I9" },
                              { "I10" },
                              { "I11" },
                              { "I12" },
                              { "I13" },
                              { "I14" },
                              { "I15" } });
          model.component("comp1").physics("ge").feature("ge1")
                    .set("equation", new String[][] { { "I1t-N_flux/(beta*f_e)+(1+epsilon1)*I1/T1+lanmda*I1" },
                              { "I2t-f15_2*I15/T15+(1+epsilon2)*I2_flux+lanmda*I2" },
                              { "I3t-I2_flux+(1+epsilon3)*I3/T3+lanmda*I3" },
                              { "I4t-f15_4*I15/T15+(1+epsilon4)*I4/T4+lanmda*I4" },
                              { "I5t-f15_5*I15/T15+(1+epsilon5)*I5/T5+lanmda*I5" },
                              { "I6t-N_flux*TBR+(1+epsilon6)*I6/T6+lanmda*I6" },
                              { "I7t-I4/T4-f6_7*I6/T6+(1+epsilon7)*I7/T7+lanmda*I7" },
                              { "I8t-I5/T5+(1+epsilon8)*I8/T8+lanmda*I8" },
                              { "I9t-f7_9*I7/T7-f8_9*I8/T8+(1+epsilon9)*I9_flux+lanmda*I9" },
                              { "I10t-f6_10*I6/T6+(1+epsilon10)*I10_flux+lanmda*I10" },
                              { "I11t-f3_11*I3/T3+(1+epsilon11)*I11_flux+lanmda*I11" },
                              { "I12t-f3_12*I3/T3-f11_12*I11_flux-f13_12*I13_flux+(1+epsilon12)*(N_flux/(f_e*beta)+lanmda*I1)+lanmda*I12" },
                              { "I13t-f9_13*I9_flux-f10_13*I10_flux-f14_13*I14_flux+(1+epsilon13)*I13_flux+lanmda*I13" },
                              { "I14t-f7_14*I7/T7-f8_14*I8/T8-f11_14*I11_flux+(1+epsilon14)*I14_flux+lanmda*I14" },
                              { "I15t-N_flux/(f_e*beta)+I15/T15+N_flux+lanmda*I15" } });
          model.component("comp1").physics("ge").feature("ge1")
                    .set("initialValueU", new String[][] { { "0" },
                              { "0" },
                              { "0" },
                              { "0" },
                              { "0" },
                              { "0" },
                              { "0" },
                              { "0" },
                              { "0" },
                              { "0" },
                              { "0" },
                              { "I12_ini" },
                              { "0" },
                              { "0" },
                              { "0" } });
          model.component("comp1").physics("ge").feature("ge1")
                    .set("initialValueUt", new int[][] { { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0 },
                              { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0 } });
          model.component("comp1").physics("ge").feature("ge1")
                    .set("description", new String[][] { { "\u52a0\u6599\u7cfb\u7edf" },
                              { "\u6cf5\u62bd\u7cfb\u7edf" },
                              { "TEP" },
                              { "\u7b2c\u4e00\u58c1" },
                              { "\u504f\u6ee4\u5668" },
                              { "\u5305\u5c42" },
                              { "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242" },
                              { "\u504f\u6ee4\u5668\u51b7\u5374\u5242" },
                              { "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf" },
                              { "TES" },
                              { "I-ISS" },
                              { "SDS" },
                              { "O-ISS" },
                              { "WDS" },
                              { "Plasma" } });
          model.component("comp1").physics("ge").feature("ge1").set("SourceTermQuantity", "none");
          model.component("comp1").physics("ge").feature("ge1").set("CustomSourceTermUnit", "g/s");

          model.study().create("std1");
          model.study("std1").create("time", "Transient");

          model.sol().create("sol1");
          model.sol("sol1").study("std1");
          model.sol("sol1").attach("std1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature().remove("fcDef");

          model.result().numerical().create("gev1", "EvalGlobal");
          model.result().create("pg1", "PlotGroup1D");
          model.result().create("pg2", "PlotGroup1D");
          model.result().create("pg3", "PlotGroup1D");
          model.result().create("pg5", "PlotGroup1D");
          model.result("pg1").create("glob1", "Global");
          model.result("pg2").create("glob1", "Global");
          model.result("pg2").create("glob2", "Global");
          model.result("pg3").create("glob1", "Global");
          model.result("pg3").create("glob2", "Global");
          model.result("pg5").create("glob1", "Global");
          model.result("pg5").create("glob2", "Global");
          model.result("pg5").create("glob3", "Global");

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*300)");

          model.sol("sol1").attach("std1");
          model.sol("sol1").feature("st1").label("\u7f16\u8bd1\u65b9\u7a0b: \u77ac\u6001");
          model.sol("sol1").feature("v1").label("\u56e0\u53d8\u91cf 1.1");
          model.sol("sol1").feature("v1").set("clist", new String[] { "range(0,360,86400*300)[s]", "25920.0[s]" });
          model.sol("sol1").feature("t1").label("\u77ac\u6001\u6c42\u89e3\u5668 1.1");
          model.sol("sol1").feature("t1").set("tlist", "range(0,360,86400*300)");
          model.sol("sol1").feature("t1").set("tstepsbdf", "strict");
          model.sol("sol1").feature("t1").feature("dDef").label("\u76f4\u63a5 1");
          model.sol("sol1").feature("t1").feature("aDef").label("\u9ad8\u7ea7 1");
          model.sol("sol1").feature("t1").feature("fc1").label("\u5168\u8026\u5408 1.1");
          model.sol("sol1").runAll();

          model.result().numerical("gev1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11", "I12", "I13", "I14" });
          model.result().numerical("gev1")
                    .set("unit", new String[] { "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg",
                              "kg", "kg", "kg", "kg" });
          model.result().numerical("gev1")
                    .set("descr",
                              new String[] { "\u52a0\u6599\u7cfb\u7edf", "\u6cf5\u62bd\u7cfb\u7edf", "TEP",
                                        "\u7b2c\u4e00\u58c1", "\u504f\u6ee4\u5668", "\u5305\u5c42",
                                        "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242", "\u504f\u6ee4\u5668\u51b7\u5374\u5242",
                                        "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf", "TES",
                                        "I-ISS", "SDS", "O-ISS", "WDS" });
          model.result("pg1").label("\u5168\u90e8\u7ed3\u679c");
          model.result("pg1").set("xlabel", "\u65f6\u95f4 (d)");
          model.result("pg1").set("ylabel", "\u76d8\u5b58\uff08kg\uff09");
          model.result("pg1").set("ylabelactive", true);
          model.result("pg1").set("xlabelactive", false);
          model.result("pg1").feature("glob1").set("xdataparamunit", "d");
          model.result("pg1").feature("glob1").set("linewidth", 3);
          model.result("pg1").feature("glob1").set("linewidthslider", 3);
          model.result("pg2").label("\u5e26\u94fa\u5e95\u6a21\u5757\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41");
          model.result("pg2").set("xlabel", "\u65f6\u95f4 (d)");
          model.result("pg2").set("xlabelactive", false);
          model.result("pg2").feature("glob1")
                    .set("expr",
                              new String[] { "I9_flux", "I10_flux", "I11_flux", "I13_flux", "I14_flux", "", "", "", "",
                                        "",
                                        "", "", "", "" });
          model.result("pg2").feature("glob1")
                    .set("unit", new String[] { "kg/s", "kg/s", "kg/s", "kg/s", "kg/s", "", "", "", "", "",
                              "", "", "", "" });
          model.result("pg2").feature("glob1")
                    .set("descr", new String[] { "CPS\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41",
                              "TES\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41", "I-ISS\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41",
                              "O-ISS\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41", "WDS\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41",
                              "", "", "", "", "",
                              "", "", "", "" });
          model.result("pg2").feature("glob1").set("xdataparamunit", "d");
          model.result("pg2").feature("glob1").set("linemarker", "cycle");
          model.result("pg2").feature("glob2").active(false);
          model.result("pg2").feature("glob2")
                    .set("expr", new String[] { "I13>I13_sat", "", "", "", "", "", "", "", "", "",
                              "", "", "", "" });
          model.result("pg2").feature("glob2")
                    .set("unit", new String[] { "", "", "", "", "", "", "", "", "", "",
                              "", "", "", "" });
          model.result("pg2").feature("glob2")
                    .set("descr", new String[] { "", "", "", "", "", "", "", "", "", "",
                              "", "", "", "" });
          model.result("pg2").feature("glob2").set("xdataparamunit", "h");
          model.result("pg3").label("\u6d4b\u8bd52");
          model.result("pg3").set("xlabel", "\u65f6\u95f4 (d)");
          model.result("pg3").set("ylabel", "\u6c1a\u5de5\u5382\u4e2d\u6c1a\u603b\u8d28\u91cf (kg)");
          model.result("pg3").set("xlabelactive", false);
          model.result("pg3").set("ylabelactive", false);
          model.result("pg3").feature("glob1").set("expr", new String[] { "I6" });
          model.result("pg3").feature("glob1").set("unit", new String[] { "kg" });
          model.result("pg3").feature("glob1")
                    .set("descr", new String[] { "\u6c1a\u5de5\u5382\u4e2d\u6c1a\u603b\u8d28\u91cf" });
          model.result("pg3").feature("glob1").set("xdataparamunit", "d");
          model.result("pg3").feature("glob1").set("linewidth", "preference");
          model.result("pg3").feature("glob1").set("linemarker", "cycle");
          model.result("pg3").feature("glob1").set("markerpos", "datapoints");
          model.result("pg3").feature("glob2").active(false);
          model.result("pg3").feature("glob2").set("expr", new String[] { "N_flux" });
          model.result("pg3").feature("glob2").set("unit", new String[] { "g/h" });
          model.result("pg3").feature("glob2")
                    .set("descr", new String[] {
                              "\u7b49\u79bb\u5b50\u4f53\u4e2d\u6c1a\u71c3\u70e7\u6d88\u8017\u901f\u7387" });
          model.result("pg3").feature("glob2").set("xdataparamunit", "d");
          model.result("pg3").feature("glob2").set("linewidth", "preference");
          model.result("pg3").feature("glob2").set("linemarker", "cycle");
          model.result("pg3").feature("glob2").set("markerpos", "datapoints");
          model.result("pg5").label("\u6d4b\u8bd53");
          model.result("pg5").set("looplevelinput", new String[] { "manual" });
          model.result("pg5")
                    .set("looplevel", new String[] {
                              "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126" });
          model.result("pg5").set("xlabel", "\u65f6\u95f4 (h)");
          model.result("pg5").set("ylabel", "\u5305\u5c42\u4e2d\u603b\u53d8\u5316 (kg/s)");
          model.result("pg5").set("xlabelactive", false);
          model.result("pg5").set("ylabelactive", false);
          model.result("pg5").feature("glob1").set("expr",
                    new String[] { "f_e*beta*TBR*I1/T1-I6/T6-(lanmda+epsilon6)*I6" });
          model.result("pg5").feature("glob1").set("unit", new String[] { "kg/s" });
          model.result("pg5").feature("glob1").set("descr", new String[] { "\u5305\u5c42\u4e2d\u603b\u53d8\u5316" });
          model.result("pg5").feature("glob1").set("xdataparamunit", "h");
          model.result("pg5").feature("glob1").set("linewidth", "preference");
          model.result("pg5").feature("glob1").set("linemarker", "cycle");
          model.result("pg5").feature("glob1").set("markerpos", "datapoints");
          model.result("pg5").feature("glob2").set("expr", new String[] { "f_e*beta*TBR*I1/T1", "I6/T6" });
          model.result("pg5").feature("glob2").set("unit", new String[] { "kg/s", "kg/s" });
          model.result("pg5").feature("glob2")
                    .set("descr", new String[] { "\u5305\u5c42\u4e2d\u589e\u6b96\u6c1a",
                              "\u5305\u5c42\u4e2d\u8f6c\u79fb\u91cf" });
          model.result("pg5").feature("glob2").set("xdataparamunit", "h");
          model.result("pg5").feature("glob2").set("linewidth", "preference");
          model.result("pg5").feature("glob2").set("linemarker", "cycle");
          model.result("pg5").feature("glob2").set("markerpos", "datapoints");
          model.result("pg5").feature("glob3").active(false);
          model.result("pg5").feature("glob3")
                    .set("expr", new String[] { "f3_12*I3/T3", "f13_12*I13/T13", "f11_12*I11/T11" });
          model.result("pg5").feature("glob3").set("unit", new String[] { "kg/s", "kg/s", "kg/s" });
          model.result("pg5").feature("glob3")
                    .set("descr", new String[] { "TEP\u5230SDS", "O-ISS\u5230SDS", "I-ISS\u5230SDS" });
          model.result("pg5").feature("glob3").set("xdataparamunit", "h");
          model.result("pg5").feature("glob3").set("linewidth", "preference");
          model.result("pg5").feature("glob3").set("linemarker", "cycle");
          model.result("pg5").feature("glob3").set("markerpos", "datapoints");

          // Export Plots to PNG
          String outPath = "D:\\Administrator\\Documents\\Github\\tricys_mph\\experiment_03\\";
          model.result().export().create("img1", "Image");
          model.result().export("img1").set("sourceobject", "pg1");
          model.result().export("img1").set("filename", outPath + "cycle_pg1_full_results.png");
          model.result().export("img1").run();

          model.result().export().create("img2", "Image");
          model.result().export("img2").set("sourceobject", "pg2");
          model.result().export("img2").set("filename", outPath + "cycle_pg2_downstream_flow.png");
          model.result().export("img2").run();

          model.result().export().create("img3", "Image");
          model.result().export("img3").set("sourceobject", "pg3");
          model.result().export("img3").set("filename", outPath + "cycle_pg3_tritium_total.png");
          model.result().export("img3").run();

          model.result().export().create("img5", "Image");
          model.result().export("img5").set("sourceobject", "pg5");
          model.result().export("img5").set("filename", outPath + "cycle_pg5_blanket_change.png");
          model.result().export("img5").run();

          return model;
     }

     public static void main(String[] args) {
          run();
     }

}
