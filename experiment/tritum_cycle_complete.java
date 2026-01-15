package experiment_00;
/*
 * tritum_cycle_complete.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Jan 14 2026, 17:15 by COMSOL 6.2.0.290. */
public class tritum_cycle_complete {

     public static Model run() {
          Model model = ModelUtil.create("Model");

          model.modelPath("D:\\Administrator\\Documents\\Github\\tricys_mph\\experiment");

          model.component().create("comp1", true);

          model.component("comp1").physics().create("ge", "GlobalEquations");
          model.component("comp1").physics("ge").prop("EquationForm").set("form", "Automatic");

          model.study().create("std1");
          model.study("std1").create("time", "Transient");
          model.study("std1").feature("time").setSolveFor("/physics/ge", true);

          model.param().label("\u7279\u5f81\u53c2\u6570");
          model.param().set("TBR", "1.1");
          model.param().descr("TBR", "\u6c1a\u589e\u503c\u6bd4");
          model.param().set("beta", "0.02");
          model.param().descr("beta", "\u71c3\u70e7\u7387");
          model.param().set("lanmda", "1.7682e-9[1/s]");
          model.param().descr("lanmda", "\u6c1a\u8870\u53d8\u5e38\u6570");
          model.param().set("fw", "0.0001");
          model.param().descr("fw", "\u7b49\u79bb\u5b50\u4f53\u9a71\u52a8\u6c1a\u6e17\u900f\u7387");
          model.param().set("fd", "1E-4");
          model.param().descr("fd", "\u6c1a\u6e17\u900f\u5230\u504f\u8651\u5668\u4e2d\u4efd\u989d");
          model.param().set("fb", "0.99");
          model.param()
                    .descr("fb",
                              "\u589e\u6b96\u533a\u6c1a\u5206\u538b\u6c1a\u6e17\u900f\u7387\uff08\u6a21\u578b\u4e2d\u4e3a0.01\uff09");
          model.param().set("fe", "0.98");
          model.param().descr("fe", "\u52a0\u6599\u7cfb\u7edf\u6548\u7387");
          model.param().set("Y13_Ini", "5000[g]");
          model.param()
                    .descr("Y13_Ini",
                              "\u71c3\u6599\u50a8\u5b58\u4e0e\u52a0\u6599\u7cfb\u7edf\u4e2d\u6c1a\u6ede\u7559\u91cf");
          model.param().set("P", "500[MW]");
          model.param().descr("P", "\u5806\u70ed\u529f\u7387");
          model.param().set("N_Para", "P/(6.515*beta)[MW/(g/day)]");
          model.param().descr("N_Para", "\u8fdb\u5165\u7b49\u79bb\u5b50\u4f53\u7684\u52a0\u6599\u901a\u91cf");
          model.param().set("P", "3000[MW]");
          model.param().remove(new String[] { "fw", "fd", "fb", "fe", "Y13_Ini", "P", "N_Para" });
          model.param().set("N_flux", "0.459[kg/day]");
          model.param().descr("N_flux", "Burning rate for 3GW fusion plant");
          model.param().set("f_b", "0.35/100", "Tritium burn fraction");
          model.param().set("eta_f", "50/100", "Fueling efficiency");
          model.param().remove("beta");
          model.param().create("par2");
          model.param("par2").label("\u6ede\u7559\u65f6\u95f4");
          model.param("par2").set("T1", "10[day]");
          model.param("par2").descr("T1", "\u5305\u5c42\u589e\u6b96\u533a");
          model.param("par2").set("T2", "0.9[day]");
          model.param("par2").descr("T2", "\u6c1a\u63d0\u53d6\u6c14\u4f53\u56de\u8def");
          model.param("par2").set("T3", "0.1[day]");
          model.param("par2").descr("T3", "\u6c1a\u63d0\u53d6\u7cfb\u7edf");
          model.param("par2").set("T4", "99.9[day]");
          model.param("par2").descr("T4", "\u51b7\u5374\u5242\u56de\u8def");
          model.param("par2").set("T5", "0.10[day]");
          model.param("par2").descr("T5", "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf");
          model.param("par2").set("T6", "99.9[day]");
          model.param("par2").descr("T6", "\u504f\u6ee4\u5668\u51b7\u5374\u56de\u8def");
          model.param("par2").set("T7", "0.10[day]");
          model.param("par2").descr("T7", "\u504f\u6ee4\u5668\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf");
          model.param("par2").set("T8", "0.50[day]");
          model.param("par2").descr("T8", "\u6392\u7070\u6c14\u62bd\u6c14\u7cfb\u7edf");
          model.param("par2").set("T9", "0.50[day]");
          model.param("par2").descr("T9", "\u5c3e\u6c14\u51c0\u5316\u7cfb\u7edf");
          model.param("par2").set("T10", "1[day]");
          model.param("par2").descr("T10", "\u6392\u6c14\u53bb\u6c1a\u7cfb\u7edf");
          model.param("par2").set("T11", "1[day]");
          model.param("par2").descr("T11", "\u6c34\u53bb\u6c1a\u7cfb\u7edf");
          model.param("par2").set("T12", "0.10[day]");
          model.param("par2").descr("T12", "\u540c\u4f4d\u7d20\u5206\u79bb\u7cfb\u7edf");
          model.param().remove("T1");
          model.param().remove("T2");
          model.param().remove("T3");
          model.param().remove("T4");
          model.param().remove("T5");
          model.param().remove("T6");
          model.param().remove("T7");
          model.param().remove("T8");
          model.param().remove("T9");
          model.param().remove("T10");
          model.param().remove("T11");
          model.param().remove("T12");
          model.param("par2").set("T7", "600[s]", "Vacuum Pump");
          model.param("par2").set("T8", "4*3600[s]", "Fuel Clean up");
          model.param("par2").set("T9", "4*3600[s]", "Isotope separation system");
          model.param("par2").set("T10", "1[h]", "Water detritiation system");
          model.param("par2").set("T1", "1*86400[s]", "Breeding Zone");
          model.param("par2").set("T2", "1*86400[s]", "TES Unit");
          model.param("par2").set("T6", "1*86400[s]", "CPS Unit");
          model.param("par2").set("T6", "10*86400[s]");
          model.param("par2").set("T3", "1000[s]", "First wall");
          model.param("par2").set("T4", "1000[s]", "Divertor");
          model.param("par2").set("T5", "1000[s]", "Heat exchanger");
          model.param().create("par3");
          model.param("par3").label("Flow rates fractions");
          model.param("par3").set("f1_5", "0.01");
          model.param("par3").set("fp_3", "1e-4");
          model.param("par3").set("fp_4", "1e-4");
          model.param("par3").set("f5_3", "0.6");
          model.param("par3").set("f5_6", "0.01");
          model.param("par3").set("f5_10", "1e-4");
          model.param("par3").set("f6_3", "0.6");
          model.param("par3").set("f9_10", "0.1");
          model.param("par3").set("eta2", "0.95");
          model.param("par3").set("eta6", "0.95");
          model.param().create("par4");
          model.param("par4").label("\u975e\u653e\u635f\u5931\u7387");
          model.param("par4").set("epsilon1", "0");
          model.param("par4").set("epsilon3", "0");
          model.param("par4").set("epsilon4", "0");
          model.param("par4").set("epsilon11", "0");
          model.param("par4").set("epsilon12", "0");
          model.param("par4").set("epsilon2", "1e-4");
          model.param("par4").set("epsilon5", "1e-4");
          model.param("par4").set("epsilon6", "1e-4");
          model.param("par4").set("epsilon7", "1e-4");
          model.param("par4").set("epsilon8", "1e-4");
          model.param("par4").set("epsilon9", "1e-4");
          model.param("par4").set("epsilon10", "1e-4");
          model.param().set("I11_ini", "5[kg]");
          model.param().descr("I11_ini", "SDS\u521d\u59cb\u50a8\u91cf");
          model.param().create("par5");
          model.param("par5").label("tao");
          model.param("par5").set("tao1", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao2", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao3", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao4", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao5", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao6", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao7", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao8", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao9", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao10", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao11", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao12", "(1+epsilon1)/(1/T1-lanmda)");
          model.param("par5").set("tao2", "(1+epsilon2)/(1/T2-lanmda)");
          model.param("par5").set("tao3", "(1+epsilon3)/(1/T3-lanmda)");
          model.param("par5").set("tao4", "(1+epsilon4)/(1/T4-lanmda)");
          model.param("par5").set("tao5", "(1+epsilon5)/(1/T5-lanmda)");
          model.param("par5").set("tao6", "(1+epsilon6)/(1/T6-lanmda)");
          model.param("par5").set("tao7", "(1+epsilon7)/(1/T7-lanmda)");
          model.param("par5").set("tao8", "(1+epsilon8)/(1/T8-lanmda)");
          model.param("par5").set("tao9", "(1+epsilon9)/(1/T9-lanmda)");
          model.param("par5").set("tao10", "(1+epsilon10)/(1/T10-lanmda)");
          model.param("par5").set("tao11", "(1+epsilon11)/(1/T11-lanmda)");
          model.param().remove("tao11");
          model.param().remove("tao12");

          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I1", 0, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I2", 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I3", 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I4", 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I5", 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I6", 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I7", 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I8", 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I9", 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I10", 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I11", 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I12", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 0, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "I1t", 0, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I1t-TBR*N_flux-(1-eta2)*I2/tao2+I1/T1", 0, 0);
          model.component("comp1").physics("ge").feature("ge1").set("CustomDependentVariableUnit", "1");
          model.component("comp1").physics("ge").feature("ge1").set("DependentVariableQuantity", "none");
          model.component("comp1").physics("ge").feature("ge1").setIndex("CustomDependentVariableUnit", "g", 0, 0);
          model.component("comp1").physics("ge").feature("ge1").set("CustomSourceTermUnit", "1");
          model.component("comp1").physics("ge").feature("ge1").set("SourceTermQuantity", "none");
          model.component("comp1").physics("ge").feature("ge1").setIndex("CustomSourceTermUnit", "g/s", 0, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "I2t-(1-f1_5)*I1/tao1+I2/T2", 1,
                    0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "I3t-fp_3*N_flux/(eta_f*f_b)", 2,
                    0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I3t-fp_3*N_flux/(eta_f*f_b)-f5_3*(1-f5_6)*(1-f5_10)*I5/tao5", 2, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I3t-fp_3*N_flux/(eta_f*f_b)-f5_3*(1-f5_6)*(1-f5_10)*I5/tao5-f6_3*(1-eta_6)",
                              2, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I3t-fp_3*N_flux/(eta_f*f_b)-f5_3*(1-f5_6)*(1-f5_10)*I5/tao5-f6_3*(1-eta6)",
                              2, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I3t-fp_3*N_flux/(eta_f*f_b)-f5_3*(1-f5_6)*(1-f5_10)*I5/tao5-f6_3*(1-eta6)*I6/tao6+I3/T3",
                              2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "I4t-fp_4*N_flux/(eta_f*f_b)", 3,
                    0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I4t-fp_4*N_flux/(eta_f*f_b)-(1-f5_3)", 3, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I4t-fp_4*N_flux/(eta_f*f_b)-(1-f5_3)*(1-f5_6)*(1-f5_10)*I5/tao5", 3, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I4t-fp_4*N_flux/(eta_f*f_b)-(1-f5_3)*(1-f5_6)*(1-f5_10)*I5/tao5-(1-f6_3)*(1-eta6)*I6/tao6+I4/T4",
                              3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "I5t-f1_5*I1/tao1-I3/tao3", 4, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I5t-f1_5*I1/tao1-I3/tao3-I4/tao4+I5/T5", 4, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I6t-f5_6*(1-f5_10)*I5/tao5+I6/T6", 5, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I7t-(1-eta_f*f_b-fp_3-fp_4)*N_flux/(eta_f*f_b)+I7/T7", 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "I8t-I7/tao7+I8/T8", 7, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I9t-I8/tao8-I10/tao10-eta2*I2/tao2-eta6*I6/tao6+I9/T9", 8, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I10t-f9_10*I9/tao9-f5_10*I5/tao5+I10/T10", 9, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I11t-(1-f9_10)*I9/tao9+N_flux/(eta_f*f_b)+lanmda*I11", 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "I11_ini", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "I11_ini", 10, 0);

          model.sol().create("sol1");
          model.sol("sol1").study("std1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,1)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "Default");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");

          model.study("std1").feature("time").set("tunit", "d");
          model.study("std1").feature("time").set("tlist", "range(0,0.1,1000)");

          model.sol("sol1").study("std1");
          model.sol("sol1").feature().remove("t1");
          model.sol("sol1").feature().remove("v1");
          model.sol("sol1").feature().remove("st1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,1000)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "Default");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          model.result().numerical().create("gev1", "EvalGlobal");
          model.result().numerical("gev1").set("data", "dset1");
          model.result().numerical("gev1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11" });
          model.result().numerical("gev1")
                    .set("descr",
                              new String[] { "\u72b6\u6001\u53d8\u91cf I1", "\u72b6\u6001\u53d8\u91cf I2",
                                        "\u72b6\u6001\u53d8\u91cf I3", "\u72b6\u6001\u53d8\u91cf I4",
                                        "\u72b6\u6001\u53d8\u91cf I5", "\u72b6\u6001\u53d8\u91cf I6",
                                        "\u72b6\u6001\u53d8\u91cf I7", "\u72b6\u6001\u53d8\u91cf I8",
                                        "\u72b6\u6001\u53d8\u91cf I9", "\u72b6\u6001\u53d8\u91cf I10",
                                        "\u72b6\u6001\u53d8\u91cf I11" });
          model.result().create("pg1", "PlotGroup1D");
          model.result("pg1").set("data", "dset1");
          model.result("pg1").create("glob1", "Global");
          model.result("pg1").feature("glob1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11" });
          model.result("pg1").feature("glob1")
                    .set("descr",
                              new String[] { "\u72b6\u6001\u53d8\u91cf I1", "\u72b6\u6001\u53d8\u91cf I2",
                                        "\u72b6\u6001\u53d8\u91cf I3", "\u72b6\u6001\u53d8\u91cf I4",
                                        "\u72b6\u6001\u53d8\u91cf I5", "\u72b6\u6001\u53d8\u91cf I6",
                                        "\u72b6\u6001\u53d8\u91cf I7", "\u72b6\u6001\u53d8\u91cf I8",
                                        "\u72b6\u6001\u53d8\u91cf I9", "\u72b6\u6001\u53d8\u91cf I10",
                                        "\u72b6\u6001\u53d8\u91cf I11" });
          model.result("pg1").run();
          model.result("pg1").run();

          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Breeding Zone", 0, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "TES Unit", 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "First wall", 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Divertor", 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Heat exchange", 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "CPS Unit", 5, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Vacuum Pump", 6, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Fuel Clean up", 7, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Isotope separation system", 8,
                    0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Water detritiation system", 9,
                    0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Storage and management", 10,
                    0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 11, 0);

          model.sol("sol1").study("std1");
          model.sol("sol1").feature().remove("t1");
          model.sol("sol1").feature().remove("v1");
          model.sol("sol1").feature().remove("st1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,1000)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "pg1");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").run();
          model.result().remove("pg1");

          model.sol("sol1").study("std1");
          model.sol("sol1").feature().remove("t1");
          model.sol("sol1").feature().remove("v1");
          model.sol("sol1").feature().remove("st1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,1000)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "Default");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          model.result().table().create("tbl1", "Table");
          model.result().table("tbl1").comments("\u5168\u5c40\u8ba1\u7b97 1");
          model.result().numerical("gev1").set("table", "tbl1");
          model.result().numerical("gev1").setResult();
          model.result().create("pg1", "PlotGroup1D");
          model.result("pg1").run();
          model.result("pg1").label("\u5404\u7cfb\u7edf\u6c1a\u76d8\u5b58\u91cf");
          model.result("pg1").create("ptgr1", "PointGraph");
          model.result("pg1").feature("ptgr1").set("markerpos", "datapoints");
          model.result("pg1").feature("ptgr1").set("linewidth", "preference");
          model.result("pg1").feature("ptgr1").set("expr", "I1");
          model.result("pg1").feature("ptgr1").set("descr", "Breeding Zone");
          model.result("pg1").run();

          model.study().remove("std1");
          model.study().create("std1");
          model.study("std1").create("time", "Transient");
          model.study("std1").feature("time").setSolveFor("/physics/ge", true);
          model.study("std1").feature("time").set("tunit", "d");
          model.study("std1").feature("time").set("tlist", "range(0,0.01,1000)");

          model.sol().create("sol1");
          model.sol("sol1").study("std1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,1000)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "Default");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          model.result().numerical().create("gev1", "EvalGlobal");
          model.result().numerical("gev1").set("data", "dset1");
          model.result().numerical("gev1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11" });
          model.result().numerical("gev1")
                    .set("descr",
                              new String[] { "Breeding Zone", "TES Unit", "First wall", "Divertor", "Heat exchange",
                                        "CPS Unit", "Vacuum Pump", "Fuel Clean up", "Isotope separation system",
                                        "Water detritiation system",
                                        "Storage and management" });
          model.result().create("pg1", "PlotGroup1D");
          model.result("pg1").set("data", "dset1");
          model.result("pg1").create("glob1", "Global");
          model.result("pg1").feature("glob1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11" });
          model.result("pg1").feature("glob1")
                    .set("descr",
                              new String[] { "Breeding Zone", "TES Unit", "First wall", "Divertor", "Heat exchange",
                                        "CPS Unit", "Vacuum Pump", "Fuel Clean up", "Isotope separation system",
                                        "Water detritiation system",
                                        "Storage and management" });
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").set("xlog", true);
          model.result("pg1").set("ylog", true);
          model.result("pg1").run();
          model.result().duplicate("pg2", "pg1");
          model.result("pg2").run();
          model.result("pg2").label("\u4e0e\u6587\u732e\u5bf9\u6bd4");
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "", 2);
          model.result("pg2").feature("glob1").setIndex("expr", "", 3);
          model.result("pg2").feature("glob1").setIndex("expr", "", 4);
          model.result("pg2").feature("glob1").setIndex("expr", "", 5);
          model.result("pg2").feature("glob1").setIndex("expr", "", 6);
          model.result("pg2").feature("glob1").setIndex("expr", "", 7);
          model.result("pg2").feature("glob1").setIndex("expr", "", 9);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").remove("unit", new int[] { 2, 3, 4, 5, 6, 7 });
          model.result("pg2").feature("glob1").remove("descr", new int[] { 2, 3, 4, 5, 6, 7 });
          model.result("pg2").feature("glob1").remove("expr", new int[] { 2, 3, 4, 5, 6, 7 });
          model.result("pg2").feature("glob1").remove("unit", 3);
          model.result("pg2").feature("glob1").remove("descr", 3);
          model.result("pg2").feature("glob1").remove("expr", new int[] { 3 });
          model.result("pg2").run();
          model.result("pg2").set("ylog", true);
          model.result("pg2").set("xlog", false);
          model.result("pg2").set("ylog", false);
          model.result("pg2").feature("glob1").setIndex("expr", "", 0);
          model.result("pg2").feature("glob1").setIndex("expr", "", 1);
          model.result("pg2").feature("glob1").setIndex("expr", "", 2);

          return model;
     }

     public static Model run2(Model model) {
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I1", 0);
          model.result("pg2").feature("glob1").setIndex("expr", "I2", 1);
          model.result("pg2").feature("glob1").setIndex("expr", "I9", 2);

          model.param().set("TBR", "1.46");

          model.sol("sol1").study("std1");
          model.sol("sol1").feature().remove("t1");
          model.sol("sol1").feature().remove("v1");
          model.sol("sol1").feature().remove("st1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,1000)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "pg1");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();

          model.param().set("I11_ini", "100[kg]");

          model.sol("sol1").study("std1");
          model.sol("sol1").feature().remove("t1");
          model.sol("sol1").feature().remove("v1");
          model.sol("sol1").feature().remove("st1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,1000)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "pg1");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").set("ylog", true);
          model.result("pg2").set("xlog", true);
          model.result("pg2").run();
          model.result("pg2").set("legendpos", "lowerright");
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").set("linemarker", "cycle");
          model.result("pg2").set("ylog", false);
          model.result("pg2").set("xlog", false);

          model.study("std1").feature("time").set("tlist", "range(0,0.01,2000)");

          model.sol("sol1").study("std1");
          model.sol("sol1").feature().remove("t1");
          model.sol("sol1").feature().remove("v1");
          model.sol("sol1").feature().remove("st1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,2000)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "pg1");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();

          model.study().create("std2");
          model.study("std2").create("time", "Transient");
          model.study("std2").feature("time").setSolveFor("/physics/ge", true);

          model.sol().create("sol2");
          model.sol("sol2").study("std2");
          model.sol("sol2").create("st1", "StudyStep");
          model.sol("sol2").feature("st1").set("study", "std2");
          model.sol("sol2").feature("st1").set("studystep", "time");
          model.sol("sol2").create("v1", "Variables");
          model.sol("sol2").feature("v1").set("control", "time");
          model.sol("sol2").create("t1", "Time");
          model.sol("sol2").feature("t1").set("tlist", "range(0,0.1,1)");
          model.sol("sol2").feature("t1").set("plot", "off");
          model.sol("sol2").feature("t1").set("plotgroup", "pg1");
          model.sol("sol2").feature("t1").set("plotfreq", "tout");
          model.sol("sol2").feature("t1").set("probesel", "all");
          model.sol("sol2").feature("t1").set("probes", new String[] {});
          model.sol("sol2").feature("t1").set("probefreq", "tsteps");
          model.sol("sol2").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol2").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol2").feature("t1").set("control", "time");
          model.sol("sol2").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol2").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol2").feature("t1").feature().remove("fcDef");
          model.sol("sol2").attach("std2");

          model.study("std2").create("param", "Parametric");
          model.study("std2").feature("param").setIndex("pname", "epsilon1", 0);
          model.study("std2").feature("param").setIndex("plistarr", "", 0);
          model.study("std2").feature("param").setIndex("punit", "", 0);
          model.study("std2").feature("param").setIndex("pname", "epsilon1", 0);
          model.study("std2").feature("param").setIndex("plistarr", "", 0);
          model.study("std2").feature("param").setIndex("punit", "", 0);
          model.study("std2").feature("param").setIndex("pname", "TBR", 0);
          model.study("std2").feature("param").setIndex("plistarr", "1.40 1.456 1.5 1.55 1.6", 0);
          model.study("std2").feature("time").set("tlist", "range(0,0.1,2000)");

          model.sol("sol2").feature("t1").set("maxstepconstraintbdf", "auto");
          model.sol("sol2").study("std2");
          model.sol("sol2").feature().remove("t1");
          model.sol("sol2").feature().remove("v1");
          model.sol("sol2").feature().remove("st1");
          model.sol("sol2").create("st1", "StudyStep");
          model.sol("sol2").feature("st1").set("study", "std2");
          model.sol("sol2").feature("st1").set("studystep", "time");
          model.sol("sol2").create("v1", "Variables");
          model.sol("sol2").feature("v1").set("control", "time");
          model.sol("sol2").create("t1", "Time");
          model.sol("sol2").feature("t1").set("tlist", "range(0,0.1,2000)");
          model.sol("sol2").feature("t1").set("plot", "off");
          model.sol("sol2").feature("t1").set("plotgroup", "pg1");
          model.sol("sol2").feature("t1").set("plotfreq", "tout");
          model.sol("sol2").feature("t1").set("probesel", "all");
          model.sol("sol2").feature("t1").set("probes", new String[] {});
          model.sol("sol2").feature("t1").set("probefreq", "tsteps");
          model.sol("sol2").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol2").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol2").feature("t1").set("control", "time");
          model.sol("sol2").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol2").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol2").feature("t1").feature().remove("fcDef");
          model.sol("sol2").attach("std2");

          model.batch().create("p1", "Parametric");
          model.batch("p1").study("std2");
          model.batch("p1").create("so1", "Solutionseq");
          model.batch("p1").feature("so1").set("seq", "sol2");
          model.batch("p1").feature("so1").set("store", "on");
          model.batch("p1").feature("so1").set("clear", "on");
          model.batch("p1").feature("so1").set("psol", "none");
          model.batch("p1").set("pname", new String[] { "TBR" });
          model.batch("p1").set("plistarr", new String[] { "1.40 1.456 1.5 1.55 1.6" });
          model.batch("p1").set("sweeptype", "sparse");
          model.batch("p1").set("probesel", "all");
          model.batch("p1").set("probes", new String[] {});
          model.batch("p1").set("plot", "off");
          model.batch("p1").set("err", "on");
          model.batch("p1").attach("std2");
          model.batch("p1").set("control", "param");

          model.sol().create("sol3");
          model.sol("sol3").study("std2");
          model.sol("sol3").label("\u53c2\u6570\u5316\u89e3 1");

          model.batch("p1").feature("so1").set("psol", "sol3");
          model.batch("p1").run("compute");

          model.result().numerical().create("gev2", "EvalGlobal");
          model.result().numerical("gev2").set("data", "dset3");
          model.result().numerical("gev2")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11" });
          model.result().numerical("gev2")
                    .set("descr",
                              new String[] { "Breeding Zone", "TES Unit", "First wall", "Divertor", "Heat exchange",
                                        "CPS Unit", "Vacuum Pump", "Fuel Clean up", "Isotope separation system",
                                        "Water detritiation system",
                                        "Storage and management" });
          model.result().create("pg3", "PlotGroup1D");
          model.result("pg3").set("data", "dset3");
          model.result("pg3").create("glob1", "Global");
          model.result("pg3").feature("glob1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11" });
          model.result("pg3").feature("glob1")
                    .set("descr",
                              new String[] { "Breeding Zone", "TES Unit", "First wall", "Divertor", "Heat exchange",
                                        "CPS Unit", "Vacuum Pump", "Fuel Clean up", "Isotope separation system",
                                        "Water detritiation system",
                                        "Storage and management" });
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").remove("unit", new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
          model.result("pg3").feature("glob1").remove("descr", new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
          model.result("pg3").feature("glob1").remove("expr", new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();

          model.study("std2").feature("time").set("tunit", "d");

          model.sol("sol2").study("std2");
          model.sol("sol2").feature().remove("t1");
          model.sol("sol2").feature().remove("v1");
          model.sol("sol2").feature().remove("st1");
          model.sol("sol2").create("st1", "StudyStep");
          model.sol("sol2").feature("st1").set("study", "std2");
          model.sol("sol2").feature("st1").set("studystep", "time");
          model.sol("sol2").create("v1", "Variables");
          model.sol("sol2").feature("v1").set("control", "time");
          model.sol("sol2").create("t1", "Time");
          model.sol("sol2").feature("t1").set("tlist", "range(0,0.1,2000)");
          model.sol("sol2").feature("t1").set("plot", "off");
          model.sol("sol2").feature("t1").set("plotgroup", "pg1");
          model.sol("sol2").feature("t1").set("plotfreq", "tout");
          model.sol("sol2").feature("t1").set("probesel", "all");
          model.sol("sol2").feature("t1").set("probes", new String[] {});
          model.sol("sol2").feature("t1").set("probefreq", "tsteps");
          model.sol("sol2").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol2").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol2").feature("t1").set("control", "time");
          model.sol("sol2").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol2").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol2").feature("t1").feature().remove("fcDef");
          model.sol("sol2").attach("std2");

          model.batch("p1").feature().remove("so1");
          model.batch("p1").create("so1", "Solutionseq");
          model.batch("p1").feature("so1").set("seq", "sol2");
          model.batch("p1").feature("so1").set("store", "on");
          model.batch("p1").feature("so1").set("clear", "on");
          model.batch("p1").feature("so1").set("psol", "sol3");
          model.batch("p1").set("pname", new String[] { "TBR" });
          model.batch("p1").set("plistarr", new String[] { "1.40 1.456 1.5 1.55 1.6" });
          model.batch("p1").set("sweeptype", "sparse");
          model.batch("p1").set("probesel", "all");
          model.batch("p1").set("probes", new String[] {});
          model.batch("p1").set("plot", "off");
          model.batch("p1").set("err", "on");
          model.batch("p1").attach("std2");
          model.batch("p1").set("control", "param");
          model.batch("p1").run("compute");

          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").set("ylog", false);
          model.result("pg3").set("xlog", true);
          model.result("pg3").set("ylog", false);
          model.result("pg3").set("xlog", false);
          model.result("pg3").run();
          model.result("pg3").set("legendpos", "upperleft");
          model.result("pg3").run();
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").set("xdataparamunit", "d");
          model.result("pg3").run();
          model.result("pg3").feature("glob1").set("xdataparamunit", "a");
          model.result("pg3").run();

          model.study("std2").feature("param").setIndex("plistarr", "1.47 1.48 1.49", 0);

          model.sol("sol2").study("std2");
          model.sol("sol2").feature().remove("t1");
          model.sol("sol2").feature().remove("v1");
          model.sol("sol2").feature().remove("st1");
          model.sol("sol2").create("st1", "StudyStep");
          model.sol("sol2").feature("st1").set("study", "std2");
          model.sol("sol2").feature("st1").set("studystep", "time");
          model.sol("sol2").create("v1", "Variables");
          model.sol("sol2").feature("v1").set("control", "time");
          model.sol("sol2").create("t1", "Time");
          model.sol("sol2").feature("t1").set("tlist", "range(0,0.1,2000)");
          model.sol("sol2").feature("t1").set("plot", "off");
          model.sol("sol2").feature("t1").set("plotgroup", "pg1");
          model.sol("sol2").feature("t1").set("plotfreq", "tout");
          model.sol("sol2").feature("t1").set("probesel", "all");
          model.sol("sol2").feature("t1").set("probes", new String[] {});
          model.sol("sol2").feature("t1").set("probefreq", "tsteps");
          model.sol("sol2").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol2").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol2").feature("t1").set("control", "time");
          model.sol("sol2").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol2").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol2").feature("t1").feature().remove("fcDef");
          model.sol("sol2").attach("std2");

          model.batch("p1").feature().remove("so1");
          model.batch("p1").create("so1", "Solutionseq");
          model.batch("p1").feature("so1").set("seq", "sol2");
          model.batch("p1").feature("so1").set("store", "on");
          model.batch("p1").feature("so1").set("clear", "on");
          model.batch("p1").feature("so1").set("psol", "sol3");
          model.batch("p1").set("pname", new String[] { "TBR" });
          model.batch("p1").set("plistarr", new String[] { "1.47 1.48 1.49" });
          model.batch("p1").set("sweeptype", "sparse");
          model.batch("p1").set("probesel", "all");
          model.batch("p1").set("probes", new String[] {});
          model.batch("p1").set("plot", "off");
          model.batch("p1").set("err", "on");
          model.batch("p1").attach("std2");
          model.batch("p1").set("control", "param");
          model.batch("p1").run("compute");

          model.result("pg3").run();

          model.param().set("TBR", "1.49");

          model.sol("sol1").study("std1");
          model.sol("sol1").feature().remove("t1");
          model.sol("sol1").feature().remove("v1");
          model.sol("sol1").feature().remove("st1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,2000)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "pg1");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").set("xlog", true);
          model.result("pg2").set("ylog", true);

          model.study("std1").feature("time").set("tlist", "range(0,0.1,1000)");

          model.sol("sol1").feature("t1").set("maxstepconstraintbdf", "const");
          model.sol("sol1").feature("t1").set("maxstepbdf", "1/24");

          model.study("std1").feature("time").set("usertol", true);
          model.study("std1").feature("time").set("rtol", "1e-6");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();

          model.study("std1").feature("time").set("tlist", "range(0,0.1,10000)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();

          model.param().set("eta_f", "25/100");
          model.param().set("f_b", "0.36/100");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").set("xlog", false);
          model.result("pg2").set("ylog", false);

          model.param().set("TBR", "1.82");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").set("ylog", true);
          model.result("pg2").set("xlog", false);
          model.result("pg2").set("ylog", false);

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I9t-(1-f8_11)*I8/tao8-I10/tao10-eta2*I2/tao2-eta6*I6/tao6+I9/T9", 8, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I11t--(1-f9_10)*I9/tao9+N_flux/(eta_f*f_b)+lanmda*I11", 10, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I11t-f8_11*I8/tao8-(1-f9_10)*I9/tao9+N_flux/(eta_f*f_b)+lanmda*I11", 10, 0);

          model.param("par3").set("f8_11", "0");

          model.label("UCLA\u8bba\u6587\u590d\u73b0.mph");

          model.study("std1").feature("time").set("tlist", "range(0,0.1,1000)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();

          model.param().set("f_b", "4/100");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").set("ylog", true);
          model.result("pg2").set("xlog", true);

          model.param().set("f_b", "3.6/100");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();

          model.param().set("f_b", "20/100");
          model.param().set("I11_ini", "4[kg]");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();

          model.param().set("TBR", "1.02");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").set("xlog", false);
          model.result("pg2").set("ylog", false);

          model.param().set("I11_ini", "5[kg]");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").set("ylog", true);
          model.result("pg2").set("xlog", true);

          model.study("std1").feature("time").set("tlist", "range(0,0.1,10000)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").set("axislimits", true);
          model.result("pg2").set("ymax", "1e4");
          model.result("pg2").set("ymin", "1e-3");
          model.result("pg2").set("xmin", 0.1);
          model.result("pg2").set("xmax", "1e4");
          model.result("pg2").run();

          model.sol("sol1").copySolution("sol7");
          model.sol("sol7").label("eta_f");
          model.sol("sol7").label("eta_f*f_b=5%");
          model.sol("sol7").label("eta_f*f_b=5% (TBR=)");
          model.sol("sol7").label("eta_f*f_b=5% (TBR=1.02)");

          model.param().set("TBR", "1.08");
          model.param().set("eta_f", "5/100");
          model.param().set("I11_ini", "20[kg]");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature().duplicate("glob2", "glob1");
          model.result("pg2").run();
          model.result("pg2").feature("glob2").set("data", "dset4");
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();

          model.sol("sol1").copySolution("sol8");
          model.sol("sol8").label("eta_f*f_b=1% (TBR=1.08)");

          model.result("pg2").run();
          model.result("pg2").feature().duplicate("glob3", "glob2");
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob2").label("eta_f*f_b=5% (TBR=1.02)");
          model.result("pg2").run();
          model.result("pg2").feature("glob3").label("eta_f*f_b=1% (TBR=1.08)");
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob2").set("linemarker", "none");
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob3").set("linemarker", "none");
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").active(false);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob3").set("data", "dset5");
          model.result("pg2").run();
          model.result("pg2").feature("glob3").set("linecolor", "cyclereset");
          model.result("pg2").feature("glob3").set("linestyle", "dashed");
          model.result("pg2").run();
          model.result("pg2").feature("glob3").set("linewidth", 3);
          model.result("pg2").run();
          model.result("pg2").feature("glob2").set("linewidth", 3);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob3").set("legend", false);
          model.result("pg2").run();
          model.result("pg2").run();

          model.param().set("eta_f", "25/100");
          model.param().set("f_b", "3.6/100");
          model.param().set("TBR", "1.82");
          model.param().set("I11_ini", "200[kg]");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature().duplicate("glob4", "glob2");
          model.result("pg2").run();
          model.result("pg2").feature("glob4").label("eta_f*f_b=25% *3.6%(TBR=1.82) ");
          model.result("pg2").run();

          model.sol("sol1").copySolution("sol9");
          model.sol("sol9").label("eta_f*f_b=25% *3.6%(TBR=1.82) ");

          model.result("pg2").run();
          model.result("pg2").feature("glob4").set("data", "dset6");
          model.result("pg2").run();
          model.result("pg2").feature("glob4").set("legend", false);
          model.result("pg2").feature("glob4").set("linestyle", "dashdot");
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").set("axislimits", false);
          model.result("pg2").run();

          model.param().set("f_b", "0.36/100");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.sol("sol1").copySolution("sol10");
          model.sol("sol10").label("eta_f*f_b=25% *0.36%(TBR=1.82) ");

          model.result("pg2").run();
          model.result("pg2").feature("glob4").set("data", "dset7");
          model.result("pg2").run();

          model.label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (OK).mph");

          model.result("pg2").run();

          model.param().set("TBR", "1.1");
          model.param().remove(new String[] { "N_flux", "f_b", "eta_f", "I11_ini" });
          model.param().set("f_e", "0.5");
          model.param().descr("f_e", "\u52a0\u6599\u6548\u7387");
          model.param().descr("f_e", "\u52a0\u6599\u7cfb\u7edf\u52a0\u6599\u6548\u7387");
          model.param().set("beta", "0.06");
          model.param().descr("beta", "\u7b49\u79bb\u5b50\u4f53\u71c3\u70e7\u7387");
          model.param().set("AF", "0.5");
          model.param().descr("AF", "\u5360\u7a7a\u6bd4");
          model.param().set("T_cycle", "3[h]");
          model.param().descr("T_cycle", "\u8fd0\u884c\u5468\u671f");
          model.param().set("P_fusion", "1500[MW]");
          model.param().descr("P_fusion", "\u805a\u53d8\u529f\u7387");
          model.param().set("factor1", "1.7805E-06",
                    "1MW\u805a\u53d8\u529f\u7387\u5bf9\u5e94\u6d88\u8017T\u8d28\u91cf");
          model.param().set("factor1", "1.7805E-06[g/s/(MW)]");
          model.param().group().remove("par5");

          model.func().create("pw1", "Piecewise");
          model.func("pw1").label("\u8109\u51b2\u529f\u7387\u5f62\u51fd\u6570");
          model.func("pw1").set("funcname", "f_pulse");
          model.func("pw1").setIndex("pieces", 0, 0, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*AF", 0, 1);
          model.func("pw1").setIndex("pieces", 1, 0, 2);
          model.func("pw1").setIndex("pieces", "T_cycle*AF", 1, 0);
          model.func("pw1").setIndex("pieces", "T_cycle", 1, 1);
          model.func("pw1").setIndex("pieces", 0, 1, 2);
          model.func("pw1").setIndex("pieces", 1, 2, 2);
          model.func("pw1").setIndex("pieces", 0, 3, 2);
          model.func("pw1").setIndex("pieces", 1, 4, 2);
          model.func("pw1").setIndex("pieces", 0, 5, 2);
          model.func("pw1").setIndex("pieces", 1, 6, 2);
          model.func("pw1").setIndex("pieces", 0, 7, 2);
          model.func("pw1").setIndex("pieces", 1, 8, 2);
          model.func("pw1").setIndex("pieces", 0, 9, 2);
          model.func("pw1").setIndex("pieces", 1, 10, 2);
          model.func("pw1").setIndex("pieces", 0, 11, 2);
          model.func("pw1").setIndex("pieces", 1, 12, 2);
          model.func("pw1").setIndex("pieces", 0, 13, 2);
          model.func("pw1").setIndex("pieces", 1, 14, 2);
          model.func("pw1").setIndex("pieces", 0, 15, 2);
          model.func("pw1").setIndex("pieces", 1, 16, 2);
          model.func("pw1").setIndex("pieces", 0, 17, 2);
          model.func("pw1").setIndex("pieces", 1, 18, 2);
          model.func("pw1").setIndex("pieces", 0, 19, 2);
          model.func().create("an1", "Analytic");
          model.func("an1").set("periodic", true);
          model.func("an1").set("expr", "if(x<T_cycle*AF, 1, 0)");
          model.func("an1").set("periodicupper", "T_cycle");
          model.func("an1").setIndex("plotargs", "1e5", 0, 2);
          model.func("an1").setIndex("argunit", "s", 0);
          model.func("an1").set("fununit", "1");
          model.func().remove("pw1");
          model.func("an1").set("funcname", "f_pulse");
          model.func("an1").label("\u5468\u671f\u5f62\u51fd\u6570");
          model.func("an1").setIndex("plotargs", "3600*3", 0, 2);
          model.func("an1").setIndex("plotargs", "3600*6", 0, 2);

          model.variable().create("var1");
          model.variable("var1").set("N_flux", "P_fusion*factor1/(beta*f_e)");
          model.variable("var1").descr("N_flux",
                    "\u4eceSDS\u5230\u52a0\u6599\u7cfb\u7edf\u7684\u52a0\u6599\u901f\u7387");
          model.variable("var1").set("aa", "N_flux*3600");
          model.variable("var1").remove("aa");

          model.param("par2").set("T11", "T7 600[s] 600 s Vacuum Pump");
          model.param().remove("T11");
          model.param("par2").set("T11", "1[h]");
          model.param("par2").set("T12", "1[h]");
          model.param("par2").set("T13", "1[h]");
          model.param("par2").set("T14", "1[h]");
          model.param("par2").descr("T1", "\u52a0\u6599\u7cfb\u7edf");
          model.param("par2").descr("T2", "\u7c97\u62bd\u7cfb\u7edf");
          model.param("par2").descr("T3", "TEP");
          model.param("par2").descr("T4", "\u7b2c\u4e00\u58c1");
          model.param("par2").descr("T5", "\u504f\u6ee4\u5668");
          model.param("par2").descr("T6", "\u5305\u5c42");
          model.param("par2").descr("T7", "\u7b2c\u4e00\u58c1\u51b7\u5374\u6c34");
          model.param("par2").descr("T8", "\u5305\u5c42\u51b7\u5374\u6c34");
          model.param("par2").descr("T9", "\u51b7\u5374\u6c34\u51c0\u5316\u7cfb\u7edf");
          model.param("par2").descr("T10", "TES");
          model.param("par2").descr("T11", "I-ISS");
          model.param("par2").descr("T12", "SDS");
          model.param("par2").descr("T13", "O-SDS");
          model.param("par2").descr("T14", "WDS");
          model.param("par2").set("T1", "0.5[h]");
          model.param("par2").set("T2", "0.17[h]");
          model.param("par2").set("T3", "2[h]");
          model.param("par2").set("T4", "0.28[h]");
          model.param("par2").set("T5", "0.28[h]");
          model.param("par2").set("T6", "24[h]");
          model.param("par2").set("T7", "24[h]");
          model.param("par2").set("T8", "24[h]");
          model.param("par2").set("T9", "48[h]");
          model.param("par2").set("T10", "12[h]");
          model.param("par2").set("T11", "6[h]");
          model.param().remove("T12");
          model.param("par2").set("T12", "100", "SDS");
          model.param("par2").set("T12", "0");
          model.param("par2").descr("T13", "O-ISS");
          model.param("par2").set("T13", "6[h]");
          model.param("par2").set("T14", "48[h]");
          model.param("par3").label("Flow rates fractions (\u5f85\u66f4\u6539)");
          model.param().rename("f1_5", "f15_2");
          model.param()
                    .remove(new String[] { "fp_3", "fp_4", "f5_3", "f5_6", "f5_10", "f6_3", "f9_10", "eta2", "eta6",
                              "f8_11" });
          model.param("par3").set("f15_2", "0.9998");
          model.param("par3").descr("f15_2", "\u4ece\u7b49\u79bb\u5b50\u4f53\u8fdb\u5165\u7c97\u62bd\u4efd\u989d");
          model.param("par3").set("f15_4", "1e-4");
          model.param("par3").descr("f15_4",
                    "\u4ece\u7b49\u79bb\u5b50\u4f53\u5230\u7b2c\u4e00\u58c1\u4e2d\u4efd\u989d");
          model.param("par3").set("f15_5", "1e-4");
          model.param("par3").descr("f15_5",
                    "\u4ece\u7b49\u79bb\u5b50\u4f53\u5230\u504f\u6ee4\u5668\u4e2d\u4efd\u989d");
          model.param("par3").set("f15_4", "(1-f15_2)/2");
          model.param("par3").set("f15_5", "(1-f15_2)/2");

          return model;
     }

     public static Model run3(Model model) {
          model.param("par3").set("f6_7", "0.05");
          model.param("par3")
                    .descr("f6_7", "\u5305\u5c42\u6cc4\u9732\u81f3\u7b2c\u4e00\u58c1\u51b7\u5374\u5242\u4efd\u989d");
          model.param("par3").set("f7_9", "0.9999");
          model.param("par3")
                    .descr("f7_9", "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242\u4e2d\u6c1a\u88ab\u51c0\u5316\u4efd\u989d");
          model.param("par3").set("f8_9", "0.9999");
          model.param("par3")
                    .descr("f8_9", "\u504f\u6ee4\u5668\u51b7\u5374\u5242\u4e2d\u6c1a\u88ab\u51c0\u5316\u4efd\u989d");
          model.param("par3").set("f6_10", "0.95");
          model.param("par3").descr("f6_10", "\u5305\u5c42\u4e2d\u6c1a\u63d0\u53d6\u4efd\u989d");
          model.param("par3").set("f6_7", "1-f6_10");
          model.param("par3").set("f3_11", "0.15");
          model.param("par3").descr("f3_11", "\uff08DIR\uff09TEP\u5230I-ISS\u4efd\u989d");
          model.param("par3").set("f3_12", "1-f3_11");
          model.param("par3").descr("f3_12", "TEP\u5230SDS\u4efd\u989d");
          model.param("par3").descr("f3_12", "\uff08DIR\uff09TEP\u5230SDS\u4efd\u989d");
          model.param("par3").set("f11_12", "0.99999999");
          model.param("par3").descr("f11_12", "I-ISS\u56de\u6536\u81f3SDS\u4efd\u989d");
          model.param("par3").set("f13_12", "1");
          model.param("par3").descr("f13_12", "O-ISS\u56de\u6536\u81f3SDS\u4efd\u989d");
          model.param("par3").set("f9_13", "1");
          model.param("par3").set("f10_13", "1");
          model.param("par3").set("f14_13", "1");
          model.param("par3").descr("f9_13", "\u4eceCPS\u5230O-ISS\u4efd\u989d");
          model.param("par3").descr("f10_13", "\u4eceTES\u5230O-ISS\u4efd\u989d");
          model.param("par3").descr("f14_13", "\u4eceWDS\u5230O-ISS\u4efd\u989d");
          model.param("par3").set("f7_14", "1-f7_9");
          model.param("par3").set("f8_14", "1-f8_9");
          model.param("par3").set("f11_14", "1-f11_12");
          model.param("par3").descr("f7_14", "\u4ece\u7b2c\u4e00\u58c1\u51b7\u5374\u5242\u5230WDS\u4efd\u989d");
          model.param("par3").descr("f8_14", "\u4ece\u504f\u6ee4\u5668\u51b7\u5374\u5242\u5230WDS\u4efd\u989d");
          model.param("par3").descr("f11_14", "\u4eceI-ISS\u5230WDS\u4efd\u989d");
          model.param("par4").set("epsilon13", "0");
          model.param("par4").set("epsilon14", "0");
          model.param("par3").label("Flow rates fractions ");
          model.param("par4").descr("epsilon1", "\u52a0\u6599\u7cfb\u7edf");
          model.param("par4").descr("epsilon2", "\u6cf5\u62bd\u7cfb\u7edf");
          model.param("par4").descr("epsilon3", "TEP");
          model.param("par4").set("epsilon3", "1e-4");
          model.param("par4").descr("epsilon4", "\u7b2c\u4e00\u58c1");
          model.param("par4").descr("epsilon5", "\u504f\u6ee4\u5668");
          model.param("par4").set("epsilon5", "0");
          model.param("par4").descr("epsilon6", "\u5305\u5c42");
          model.param("par4").set("epsilon6", "0");
          model.param("par4").descr("epsilon7", "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242\u56de\u8def");
          model.param("par4").descr("epsilon8", "\u504f\u6ee4\u5668\u51b7\u5374\u5242\u56de\u8def");
          model.param("par4").descr("epsilon9", "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf");
          model.param("par4").descr("epsilon10", "TES");
          model.param("par4").descr("epsilon11", "I-ISS");
          model.param("par4").set("epsilon11", "1e-4");
          model.param("par4").descr("epsilon12", "SDS");
          model.param("par4").descr("epsilon13", "O-ISS");
          model.param("par4").set("epsilon13", "1e-4");
          model.param("par4").descr("epsilon14", "WDS");
          model.param("par4").set("epsilon14", "1e-4");
          model.param().create("par5");
          model.param("par5").label("\u94fa\u5e95\u91cf");
          model.param("par5").set("I1_sat", "0[g]");
          model.param("par5").set("I2_sat", "640[g]");
          model.param("par5").set("I3_sat", "0");
          model.param("par5").set("I4_sat", "0");
          model.param("par5").set("I5_sat", "0");
          model.param("par5").set("I6_sat", "0");
          model.param("par5").set("I7_sat", "0");
          model.param("par5").set("I8_sat", "0");
          model.param("par5").set("I9_sat", "200[g]");
          model.param("par5").set("I10_sat", "200[g]");
          model.param("par5").set("I11_sat", "300[g]");
          model.param("par5").set("I12_sat", "0");
          model.param("par5").set("I13_sat", "20[g]");
          model.param("par5").set("I12_sat", "0[g]");
          model.param("par5").set("I14_sat", "1000[g]");
          model.param("par5").descr("I1_sat", "jialiaoxitong");
          model.param("par5").descr("I1_sat", "\u52a0\u6599\u7cfb\u7edf");
          model.param("par5").descr("I2_sat", "\u6cf5\u62bd\u7cfb\u7edf");
          model.param("par5").descr("I3_sat", "TEP");
          model.param("par5").descr("I4_sat", "\u7b2c\u4e00\u58c1");
          model.param("par5").descr("I5_sat", "DIV");
          model.param("par5").descr("I5_sat", "\u504f\u6ee4\u5668");
          model.param("par5").descr("I6_sat", "\u5305\u5c42");
          model.param("par5").descr("I7_sat", "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242");
          model.param("par5").descr("I8_sat", "\u5305\u5c42\u51b7\u5374\u5242");
          model.param("par5").descr("I9_sat", "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf");
          model.param("par5").descr("I10_sat", "TES");
          model.param("par5").descr("I11_sat", "I-ISS");
          model.param("par5").descr("I12_sat", "SDS");
          model.param("par5").descr("I13_sat", "O-ISS");
          model.param("par5").descr("I14_sat", "WDS");

          model.study().remove("std2");
          model.study().remove("std1");

          model.variable("var1").set("N_flux", "f_pulse(t)*P_fusion*factor1/(beta*f_e)");

          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I12", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I13", 12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I14", 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "\u52a0\u6599\u7cfb\u7edf", 0,
                    0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "\u6cf5\u62bd\u7cfb\u7edf", 1,
                    0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "TEP", 2, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "\u7b2c\u4e00\u58c1", 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "\u504f\u6ee4\u5668", 4, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "\u5305\u5c42", 5, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("description", "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242", 6, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("description", "\u504f\u6ee4\u5668\u51b7\u5374\u5242", 7, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("description", "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf", 8, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "TES", 9, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "I-ISS", 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "SDS", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "O-ISS", 12, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "WDS", 13, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I1t-N_flux+I1/T1+(lanmda+epsilon1)*I1", 0, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I2t-(1-f_e)*I1/T1-f_e*(1-beta)*f15_2*I1/T1+I2/T2+(lanmda+epsilon2)*I2", 1,
                              0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I3t-I2/T2+I3/T3+(lanmda+epsilon3)*I3", 2, 0);

          model.param("par4").set("epsilon1", "0[1/s]");
          model.param("par4").set("epsilon2", "1e-4[1/s]");
          model.param("par4").set("epsilon3", "1e-4[1/s]");
          model.param("par4").set("epsilon4", "0[1/s]");
          model.param("par4").set("epsilon5", "0[1/s]");
          model.param("par4").set("epsilon6", "0[1/s]");
          model.param("par4").set("epsilon7", "1e-4[1/s]");
          model.param("par4").set("epsilon8", "1e-4[1/s]");
          model.param("par4").set("epsilon9", "1e-4[1/s]");
          model.param("par4").set("epsilon10", "1e-4[1/s]");
          model.param("par4").set("epsilon11", "1e-4[1/s]");
          model.param("par4").set("epsilon12", "0[1/s]");
          model.param("par4").set("epsilon13", "1e-4[1/s]");
          model.param("par4").set("epsilon14", "1e-4[1/s]");

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I4t-f_e*(1-beta)9*f15_4*I1/T1", 3, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "I4t-f_e*(1-beta)*f15_4*I1/T1", 3,
                    0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I4t-f_e*(1-beta)*f15_4*I1/T1+I4/T4", 3, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I4t-f_e*(1-beta)*f15_4*I1/T1+I4/T4+(lanmda+epsilon4)*I4", 3, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I5t-f_e*(1-beta)*f15_5*I1/T1+I5/T5+(lanmda+epsilon5)*I5", 4, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I6t-f_e*beta*TBR*I1/T1+I6/T6+(lanmda+epsilon6)*I6", 5, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I7t-I4/T4-f6_7*I6/T6+I7/T7+(lanmda+epsilon7)*I7", 6, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I8t-I5/T5+I8/T8+(lanmda+epsilon8)*I8", 7, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I9t-f7_9*I7/T7-f8_9*I8/T8+I9/T9+(lanmda+epsilon9)*I9", 8, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I10t-f6_10*I6/T6+I10/T10+(lanmda+epsilon10)*I10", 9, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I11t-f3_11*I3/T3+I11/T11+(lanmda+epsilon11)*I11", 10, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I12t-f3_12*I3/T3-f11_12*I11/T11-f13_12*I13/T13+N_flux+(lanmda+epsilon12)*I12", 11, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 10, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "I12_ini", 11, 0);

          model.param().set("I12_ini", "5[kg]");
          model.param().descr("I12_ini", "SDS\u4e2d\u521d\u59cb\u6295\u6599\u91cf");

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I3t-f9_13*I9/T9-f10_13*I10/T10-f14_13*I14/T14+I13/T13+(lanmda+epsilon13)*I13", 12, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I14t-f7_14*I7/T7-f8_14*I8/T8-f11_14*I11/T11+I14/T14+(lanmda+epsilon14)*I14",
                              13, 0);

          model.study().create("std1");
          model.study("std1").create("time", "Transient");
          model.study("std1").feature("time").setSolveFor("/physics/ge", true);
          model.study("std1").feature("time").set("tunit", "d");
          model.study("std1").feature("time").set("tlist", "range(0,0.1,450)");

          model.sol().create("sol1");
          model.sol("sol1").study("std1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,450)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "Default");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").runAll();

          model.result().numerical().create("gev1", "EvalGlobal");
          model.result().numerical("gev1").set("data", "dset1");
          model.result().numerical("gev1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11", "I12", "I13", "I14" });
          model.result().numerical("gev1")
                    .set("descr",
                              new String[] { "\u52a0\u6599\u7cfb\u7edf", "\u6cf5\u62bd\u7cfb\u7edf", "TEP",
                                        "\u7b2c\u4e00\u58c1", "\u504f\u6ee4\u5668", "\u5305\u5c42",
                                        "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242", "\u504f\u6ee4\u5668\u51b7\u5374\u5242",
                                        "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf", "TES",
                                        "I-ISS", "SDS", "O-ISS", "WDS" });
          model.result().create("pg1", "PlotGroup1D");
          model.result("pg1").set("data", "dset1");
          model.result("pg1").create("glob1", "Global");
          model.result("pg1").feature("glob1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11", "I12", "I13", "I14" });
          model.result("pg1").feature("glob1")
                    .set("descr",
                              new String[] { "\u52a0\u6599\u7cfb\u7edf", "\u6cf5\u62bd\u7cfb\u7edf", "TEP",
                                        "\u7b2c\u4e00\u58c1", "\u504f\u6ee4\u5668", "\u5305\u5c42",
                                        "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242", "\u504f\u6ee4\u5668\u51b7\u5374\u5242",
                                        "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf", "TES",
                                        "I-ISS", "SDS", "O-ISS", "WDS" });
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").set("ylog", true);
          model.result("pg1").set("xlog", true);
          model.result("pg1").run();
          model.result("pg1").label("\u5168\u90e8\u7ed3\u679c");
          model.result("pg1").run();
          model.result("pg1").run();
          model.result().duplicate("pg2", "pg1");
          model.result("pg2").run();
          model.result("pg2").label("SDS");
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "", 0);
          model.result("pg2").feature("glob1").setIndex("expr", "", 1);
          model.result("pg2").feature("glob1").setIndex("expr", "", 2);
          model.result("pg2").feature("glob1").setIndex("expr", "", 3);
          model.result("pg2").feature("glob1").setIndex("expr", "", 4);
          model.result("pg2").feature("glob1").setIndex("expr", "", 5);
          model.result("pg2").feature("glob1").setIndex("expr", "", 6);
          model.result("pg2").feature("glob1").setIndex("expr", "", 7);
          model.result("pg2").feature("glob1").setIndex("expr", "", 8);
          model.result("pg2").feature("glob1").setIndex("expr", "", 9);
          model.result("pg2").feature("glob1").setIndex("expr", "", 10);
          model.result("pg2").feature("glob1").setIndex("expr", "", 12);
          model.result("pg2").feature("glob1").setIndex("expr", "", 13);
          model.result("pg2").run();
          model.result("pg2").set("ylog", false);
          model.result("pg2").set("xlog", false);
          model.result("pg2").feature("glob1").setIndex("expr", "I1+I2+I3+I4+I5+I6+I7+I8+I9+I10+I11+I12+I13+I14", 0);
          model.result("pg2").feature("glob1").setIndex("expr", "", 11);
          model.result("pg2").run();

          model.sol("sol1").feature("t1").set("maxstepconstraintbdf", "const");
          model.sol("sol1").feature("t1").set("maxstepbdf", 0.01);
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").set("ylog", false);
          model.result("pg1").set("xlog", false);
          model.result("pg2").run();
          model.result("pg1").run();
          model.result("pg1").set("ylog", true);

          model.sol("sol1").feature("t1").create("se1", "Segregated");
          model.sol("sol1").feature("t1").feature("se1").create("ul1", "UpperLimit");
          model.sol("sol1").feature("t1").feature("se1").create("ul2", "UpperLimit");
          model.sol("sol1").feature("t1").feature("se1").create("ll1", "LowerLimit");
          model.sol("sol1").feature("t1").feature("se1").feature().remove("ul1");
          model.sol("sol1").feature("t1").feature("se1").feature().remove("ul2");
          model.sol("sol1").feature("t1").feature("se1").feature("ll1")
                    .set("lowerlimit",
                              "comp1.I1 0 comp1.I2 0 comp1.I3 0 comp1.I4 0 comp1.I5 0 comp1.I6 0 comp1.I7 0 comp1.I8 0 comp1.I9 0 comp1.I10 0 comp1.I11 0 comp1.I12 0 comp1.I13 0 comp1.I14 0");
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").label("\u6d4b\u8bd5");
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I1", 0);
          model.result("pg2").run();
          model.result("pg2").set("ylog", false);
          model.result("pg2").set("xlog", true);
          model.result("pg2").run();
          model.result("pg2").setIndex("looplevelinput", "manual", 0);
          model.result("pg2").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg2").setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }, 0);
          model.result("pg2").run();
          model.result("pg2").set("xlog", false);
          model.result("pg2")
                    .setIndex("looplevel",
                              new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 },
                              0);
          model.result("pg2").run();
          model.result("pg2")
                    .setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
                              19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 }, 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I2", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I3", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I4", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I5", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I6", 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2")
                    .setIndex("looplevel",
                              new int[] { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
                                        50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
                                        70, 71, 72, 73, 74, 75, 76, 77, 78 },
                              0);
          model.result("pg2").run();
          model.result("pg2")
                    .setIndex("looplevel",
                              new int[] { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
                                        50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
                                        70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89,
                                        90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101 },
                              0);
          model.result("pg2").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg2")
                    .setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
                              19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                              41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62,
                              63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84,
                              85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105,
                              106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123,
                              124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141,
                              142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159,
                              160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177,
                              178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195,
                              196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206 }, 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I7", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I4", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I7", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I8", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I9", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I10", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I11", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I14", 0);
          model.result("pg2").run();

          model.sol("sol1").feature("t1").feature("se1").feature("ll1").active(false);
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I11", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I10", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I19", 0);
          model.result("pg2").feature("glob1").setIndex("expr", "I9", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I8", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I7", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I6", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I5", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I4", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I3", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I2", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I1", 0);
          model.result("pg2").run();

          model.variable("var1").set("N_flux", "if(comp1.I12<=0, 0, f_pulse(t)*P_fusion*factor1/(beta*f_e))");

          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();

          model.variable("var1").set("N_flux", "f_pulse(t)*P_fusion*factor1/(beta*f_e)");

          model.param().set("I12_ini", "50[kg]");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").setIndex("looplevelinput", "all", 0);
          model.result("pg2").run();
          model.result().create("pg3", "PlotGroup1D");
          model.result("pg3").run();
          model.result("pg3").label("\u6d4b\u8bd52");
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg3").create("glob1", "Global");
          model.result("pg3").feature("glob1").set("markerpos", "datapoints");
          model.result("pg3").feature("glob1").set("linewidth", "preference");
          model.result("pg3").feature("glob1").remove("unit",
                    new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 });
          model.result("pg3").feature("glob1").remove("descr",
                    new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 });
          model.result("pg3").feature("glob1").remove("expr",
                    new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 });
          model.result("pg3").feature("glob1").setIndex("expr", "N_flux", 0);
          model.result("pg3").run();
          model.result("pg3").set("xlog", true);
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "manual", 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3")
                    .setIndex("looplevel",
                              new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                                        23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                                        43, 44, 45, 46, 47, 48, 49, 50, 51, 52 },
                              0);
          model.result("pg3").run();
          model.result("pg3").set("xlog", false);
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1, 2 }, 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }, 0);
          model.result("pg3").run();

          model.study("std1").feature("time").set("tunit", "s");
          model.study("std1").feature("time").set("tlist", "range(0,3600,864000)");

          model.sol("sol1").feature("t1").set("maxstepconstraintbdf", "auto");
          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.sol("sol1").feature("t1").set("tstepsbdf", "strict");
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").feature("glob1").set("xdataparamunit", "s");
          model.result("pg1").run();
          model.result("pg1").feature("glob1").set("xdataparamunit", "d");
          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "all", 0);
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "manual", 0);
          model.result("pg3").setIndex("looplevel", new int[] { 8 }, 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }, 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").set("xdataparamunit", "s");
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").set("xdataparamunit", "h");
          model.result("pg3").run();

          model.func("an1").set("periodic", true);
          model.func("an1").set("dermethod", "automatic");
          model.func().create("rect1", "Rectangle");
          model.func("rect1").set("smoothactive", false);
          model.func("rect1").set("lower", 0);
          model.func("rect1").set("upper", 3600);
          model.func().remove("rect1");

          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").setIndex("looplevelinput", "manual", 0);
          model.result("pg2").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg2").setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6 }, 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").set("xdataparamunit", "h");
          model.result("pg2").run();
          model.result("pg3").run();

          model.func().create("pw1", "Piecewise");
          model.func("pw1").setIndex("pieces", 0, 0, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*AF", 0, 1);
          model.func("pw1").setIndex("pieces", 1, 0, 2);
          model.func("pw1").setIndex("pieces", 0, 1, 2);
          model.func("pw1").setIndex("pieces", 1, 2, 2);
          model.func("pw1").setIndex("pieces", 0, 3, 2);
          model.func("pw1").setIndex("pieces", 1, 4, 2);
          model.func("pw1").setIndex("pieces", 0, 5, 2);
          model.func("pw1").setIndex("pieces", "T_cycle", 1, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(1+AF)", 1, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*(1+AF)", 2, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(1+0)", 1, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*AF", 1, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(1+0)", 2, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(1+0)", 2, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*(1+AF)", 2, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*(1+AF)", 3, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(2+0)", 3, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*(2+0)", 4, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(2+AF)", 4, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*(2+AF)", 5, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(3+0)", 5, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*(2+0)", 6, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(3+0)", 6, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(3+AF)", 6, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*(2+AF)", 7, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(3+AF)", 7, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(4+0)", 7, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*(4+AF)", 8, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(4+AF)", 8, 1);
          model.func("pw1").setIndex("pieces", "T_cycle*(4+0)", 8, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(4+AF)", 9, 0);
          model.func("pw1").setIndex("pieces", "T_cycle*(5+0)", 9, 1);
          model.func("pw1").setIndex("pieces", 1, 6, 2);
          model.func("pw1").setIndex("pieces", 0, 7, 2);
          model.func("pw1").setIndex("pieces", 1, 8, 2);
          model.func("pw1").setIndex("pieces", 0, 9, 2);

          model.study("std1").feature("time").set("tlist", "range(0,3600,3600*15)");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,3600*15)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "all", 0);
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").setIndex("looplevelinput", "all", 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I11", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I1", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I2", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I3", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I4", 0);
          model.result("pg2").run();

          return model;
     }

     public static Model run4(Model model) {
          model.result("pg3").run();

          model.study("std1").feature("time").set("tlist", "range(0,1800,86400*10)");

          model.sol("sol1").feature("t1").set("maxstepconstraintbdf", "const");
          model.sol("sol1").feature("t1").set("maxstepbdf", 600);
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").set("xlog", false);
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "manual", 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1, 2, 3, 4, 5 }, 0);
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0);
          model.result("pg3").run();

          model.study("std1").feature("time").set("tlist", "range(0,1620,86400*10)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();

          model.sol("sol1").feature("t1").set("maxstepbdf", 360);
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*10)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").set("xlog", false);
          model.result("pg2").run();

          model.sol("sol1").feature("t1").set("maxstepconstraintbdf", "auto");

          model.study("std1").feature("time").set("tlist", "range(0,360,3600*15)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "all", 0);
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg3").run();

          model.variable("var1").set("N_flux", "pw1(t)*P_fusion*factor1/(beta*f_e)");

          model.func("pw1").set("argunit", "s");
          model.func("pw1").set("fununit", "1");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "last", 0);
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "all", 0);
          model.result("pg3").run();

          model.variable("var1").set("N_flux", "f_pulse(t)*P_fusion*factor1/(beta*f_e)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,3600*150)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "manual", 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3")
                    .setIndex("looplevel",
                              new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                                        23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                                        43, 44, 45, 46, 47, 48 },
                              0);
          model.result("pg3").run();

          model.study("std1").feature("time").set("tlist", "range(0,3600,3600*150)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();

          model.study("std1").feature("time").set("tlist", "range(0,1800,3600*150)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0);
          model.result("pg3").run();

          model.sol("sol1").feature("t1").set("maxstepconstraintbdf", "const");
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }, 0);
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();
          model.result("pg2").run();

          model.study("std1").feature("time").set("tlist", "range(0,1800,3600*15)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg2").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,3600*15)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, 0);
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3")
                    .setIndex("looplevel", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
                              19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                              41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62 },
                              0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I5", 0);
          model.result("pg2").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*30)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").set("ylog", false);
          model.result("pg2").run();
          model.result("pg2").set("ylog", true);
          model.result("pg2").set("xlog", true);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "all", 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").set("ylog", false);
          model.result("pg2").set("xlog", false);
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature().duplicate("glob2", "glob1");
          model.result("pg3").run();
          model.result("pg3").feature("glob2").setIndex("expr", "-f3_12*I3/T3-f11_12*I11/T11-f13_12*I13/T13+N_flux", 0);
          model.result("pg3").run();
          model.result("pg3").feature("glob1").active(false);
          model.result("pg3").run();
          model.result("pg3").feature("glob2").setIndex("expr", "f3_12*I3/T3+f11_12*I11/T11+f13_12*I13/T13-N_flux", 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob2").active(false);
          model.result("pg3").run();
          model.result("pg3").feature("glob1").active(true);
          model.result("pg3").feature("glob1").setIndex("expr", "N_flux*f_e*beta", 0);
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").active(false);
          model.result("pg3").run();
          model.result("pg3").feature("glob2").active(true);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevelinput", "manual", 0);
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg3")
                    .setIndex("looplevel",
                              new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                                        23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                                        43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62,
                                        63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81 },
                              0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature().duplicate("glob3", "glob2");
          model.result("pg3").run();
          model.result("pg3").feature("glob3")
                    .setIndex("expr", "f3_12*I3/T3+f11_12*I11/T11+f13_12*I13/T13-N_flux-(lanmda+epsilon12)*I12", 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob3").active(false);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("expr", "N_flux", 0);
          model.result("pg3").feature("glob1").active(true);
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("expr", "-N_flux", 0);
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob3").active(true);
          model.result("pg3").feature("glob3").setIndex("expr", "f11_12*I11/T11", 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob3").setIndex("expr", "f3_12*I3/T3", 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob3").setIndex("expr", "f13_12*I13/T13", 1);
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I6", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I10", 1);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 2);
          model.result("pg2").run();

          model.sol("sol1").copySolution("sol2");
          model.sol("sol2").label("\u4e0d\u7ea6\u675f\u4e0b\u9650");
          model.sol("sol1").feature("t1").feature("se1").feature("ll1").active(true);
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob3").setIndex("descr", "TEP\u5230SDS", 0);
          model.result("pg3").feature("glob3").setIndex("descr", "O-ISS\u5230SDS", 1);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob3").setIndex("expr", "f11_12*I11/T11", 2);
          model.result("pg3").feature("glob3").setIndex("descr", "I-ISS\u5230SDS", 2);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").set("linemarker", "cycle");
          model.result("pg3").run();
          model.result("pg3").feature("glob2").set("linemarker", "cycle");
          model.result("pg3").run();
          model.result("pg3").feature("glob3").set("linemarker", "cycle");
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("descr", "\u52a0\u6599", 0);
          model.result("pg3").run();
          model.result("pg3").feature("glob2").setIndex("descr", "SDS\u603b\u53d8\u5316", 0);
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("descr", "SDS\u52a0\u6599", 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I14", 2);
          model.result("pg2").feature("glob1").setIndex("expr", "", 1);
          model.result("pg2").feature("glob1").setIndex("expr", "", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I11", 2);
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 3);
          model.result("pg2").run();

          model
                    .label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (OK)\uff08\u4fee\u6b63\u65e0\u6599\u4efb\u7136\u6d41\u51fa\uff09.mph");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg2").run();

          model.sol("sol1").feature("t1").feature("se1").feature("ll1").active(false);
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I1", 0);
          model.result("pg2").feature("glob1").setIndex("expr", "", 2);
          model.result("pg2").feature("glob1").setIndex("expr", "", 3);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I2", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I3", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I4", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I5", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I6", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I7", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I8", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I9", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I10", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I11", 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I14", 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();
          model.result("pg3").run();

          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0.3, 12, 0);

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();

          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "0.3[kg]", 12, 0);

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").run();

          model.sol("sol1").study("std1");
          model.sol("sol1").feature().remove("t1");
          model.sol("sol1").feature().remove("v1");
          model.sol("sol1").feature().remove("st1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,360,86400*30)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "pg1");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").feature("t1").set("tstepsbdf", "strict");
          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I14", 0);
          model.result("pg2").run();
          model.result("pg2").run();

          model.sol().remove("sol2");

          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg3").set("data", "none");
          model.result("pg2").run();
          model.result("pg2").set("data", "none");
          model.result("pg1").run();
          model.result("pg1").set("data", "none");

          model.study().remove("std1");
          model.study().create("std1");
          model.study("std1").create("time", "Transient");
          model.study("std1").feature("time").setSolveFor("/physics/ge", true);
          model.study("std1").feature("time").set("tlist", "range(0,360,86400*30)");

          model.sol().create("sol1");
          model.sol("sol1").study("std1");
          model.sol("sol1").create("st1", "StudyStep");
          model.sol("sol1").feature("st1").set("study", "std1");
          model.sol("sol1").feature("st1").set("studystep", "time");
          model.sol("sol1").create("v1", "Variables");
          model.sol("sol1").feature("v1").set("control", "time");
          model.sol("sol1").create("t1", "Time");
          model.sol("sol1").feature("t1").set("tlist", "range(0,360,86400*30)");
          model.sol("sol1").feature("t1").set("plot", "off");
          model.sol("sol1").feature("t1").set("plotgroup", "pg1");
          model.sol("sol1").feature("t1").set("plotfreq", "tout");
          model.sol("sol1").feature("t1").set("probesel", "all");
          model.sol("sol1").feature("t1").set("probes", new String[] {});
          model.sol("sol1").feature("t1").set("probefreq", "tsteps");
          model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
          model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
          model.sol("sol1").feature("t1").set("control", "time");
          model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
          model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "dDef");
          model.sol("sol1").feature("t1").feature().remove("fcDef");
          model.sol("sol1").attach("std1");
          model.sol("sol1").feature("t1").set("tstepsbdf", "strict");
          model.sol("sol1").runAll();

          model.result().numerical().create("gev1", "EvalGlobal");
          model.result().numerical("gev1").set("data", "dset1");
          model.result().numerical("gev1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11", "I12", "I13", "I14" });
          model.result().numerical("gev1")
                    .set("descr",
                              new String[] { "\u52a0\u6599\u7cfb\u7edf", "\u6cf5\u62bd\u7cfb\u7edf", "TEP",
                                        "\u7b2c\u4e00\u58c1", "\u504f\u6ee4\u5668", "\u5305\u5c42",
                                        "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242", "\u504f\u6ee4\u5668\u51b7\u5374\u5242",
                                        "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf", "TES",
                                        "I-ISS", "SDS", "O-ISS", "WDS" });
          model.result().create("pg4", "PlotGroup1D");
          model.result("pg4").set("data", "dset1");
          model.result("pg4").create("glob1", "Global");
          model.result("pg4").feature("glob1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11", "I12", "I13", "I14" });
          model.result("pg4").feature("glob1")
                    .set("descr",
                              new String[] { "\u52a0\u6599\u7cfb\u7edf", "\u6cf5\u62bd\u7cfb\u7edf", "TEP",
                                        "\u7b2c\u4e00\u58c1", "\u504f\u6ee4\u5668", "\u5305\u5c42",
                                        "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242", "\u504f\u6ee4\u5668\u51b7\u5374\u5242",
                                        "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf", "TES",
                                        "I-ISS", "SDS", "O-ISS", "WDS" });
          model.result("pg4").run();
          model.result("pg3").run();
          model.result("pg3").set("data", "dset1");
          model.result("pg2").run();
          model.result("pg2").set("data", "dset1");
          model.result("pg1").run();
          model.result("pg1").set("data", "dset1");
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();

          model.sol("sol1").runFromTo("st1", "v1");

          model.result("pg1").run();
          model.result("pg2").run();

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();

          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", "I13_ini", 12, 0);

          model.param().set("I13_ini", "0.5[kg]");

          model.sol("sol1").runFromTo("st1", "v1");

          model.result("pg1").run();
          model.result("pg2").run();

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result().duplicate("pg5", "pg3");
          model.result("pg5").run();
          model.result("pg4").run();
          model.result().remove("pg4");
          model.result("pg5").run();
          model.result("pg5").label("\u6d4b\u8bd53");
          model.result("pg5").run();
          model.result("pg5").feature("glob2").active(false);
          model.result("pg5").run();
          model.result("pg5").feature("glob3").active(false);
          model.result("pg5").run();
          model.result("pg5").run();
          model.result("pg5").feature("glob1").setIndex("expr", "f_e*beta*TBR*I1/T1+I6/T6+(lanmda+epsilon6)*I6", 0);
          model.result("pg5").feature("glob1").setIndex("expr", "f_e*beta*TBR*I1/T1-I6/T6-(lanmda+epsilon6)*I6", 0);
          model.result("pg5").feature("glob1").setIndex("descr", "\u5305\u5c42\u4e2d\u603b\u53d8\u5316", 0);
          model.result("pg5").run();
          model.result("pg5").run();
          model.result("pg5").setIndex("looplevelinput", "manual", 0);
          model.result("pg5").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg5")
                    .setIndex("looplevel",
                              new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                                        23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                                        43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 },
                              0);
          model.result("pg5").run();
          model.result("pg5").setIndex("looplevel", new int[] { 1 }, 0);
          model.result("pg5")
                    .setIndex("looplevel",
                              new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                                        23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                                        43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62,
                                        63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82,
                                        83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101,
                                        102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117,
                                        118, 119, 120, 121, 122, 123, 124, 125, 126 },
                              0);
          model.result("pg5").run();
          model.result("pg5").run();
          model.result("pg5").run();
          model.result("pg5").feature("glob2").setIndex("expr", "f_e*beta*TBR*I1/T1-I6/T6", 0);
          model.result("pg5").feature("glob2").active(true);
          model.result("pg5").run();
          model.result("pg5").run();
          model.result("pg5").feature("glob3").active(true);
          model.result("pg5").run();
          model.result("pg5").run();
          model.result("pg5").feature("glob3").active(false);
          model.result("pg5").run();
          model.result("pg5").feature("glob2").setIndex("expr", "f_e*beta*TBR*I1/T1", 0);
          model.result("pg5").feature("glob2").setIndex("expr", "-I6/T6", 1);
          model.result("pg5").feature("glob2").setIndex("descr", "\u589e\u6b96\u6c1a", 0);
          model.result("pg5").feature("glob2").setIndex("expr", "I6/T6", 1);
          model.result("pg5").feature("glob2").setIndex("descr", "\u5305\u5c42\u4e2d\u589e\u6b96\u6c1a", 0);
          model.result("pg5").feature("glob2").setIndex("descr", "\u5305\u5c42\u4e2d\u8f6c\u79fb\u91cf", 1);
          model.result("pg5").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "f_e*I1/T1", 0);
          model.result("pg2").run();

          model.param("par4").set("epsilon1", "0");
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
          model.param("par4").set("epsilon12", "0");
          model.param("par4").set("epsilon13", "1e-4");
          model.param("par4").set("epsilon14", "1e-4");

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I1t-N_flux+(1+epsilon1))*I1/T1+lanmda*I1", 0, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I1t-N_flux+(1+epsilon1)*I1/T1+lanmda*I1", 0, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I2t-(1-f_e)*I1/T1-f_e*(1-beta)*f15_2*I1/T1+(1+epsilon2)*I2/T2+lanmda*I2", 1,
                              0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I3t-I2/T2+(1+epsilon3)*I3/T3+lanmda*I3", 2, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I4t-f_e*(1-beta)*f15_4*I1/T1+I4/T4+(lanmdaI4", 3, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I4t-f_e*(1-beta)*f15_4*I1/T1+(1+epsilon4)*I4/T4+lanmda*I4", 3, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I5t-f_e*(1-beta)*f15_5*I1/T1+(1+epsilon5)*I5/T5+lanmda*I5", 4, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I6t-f_e*beta*TBR*I1/T1+(1+epsilon6)*I6/T6+lanmda*I6", 5, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I7t-I4/T4-f6_7*I6/T6+(1+epsilon7)*I7/T7+lanmda*I7", 6, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I8t-I5/T5+(1+epsilon8)*I8/T8+lanmda*I8", 7, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I9t-f7_9*I7/T7-f8_9*I8/T8++epsilon9)*I9/T9+lanmda*I9", 8, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I9t-f7_9*I7/T7-f8_9*I8/T8+(1+epsilon9)*I9/T9+lanmda*I9", 8, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I10t-f6_10*I6/T6+(1+epsilon10)*I10/T10+(lanmda*I10", 9, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I10t-f6_10*I6/T6+(1+epsilon10)*I10/T10+lanmda*I10", 9, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I11t-f3_11*I3/T3+(1+epsilon11)*I11/T11+lanmda*I11", 10, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I12t-f3_12*I3/T3-f11_12*I11/T11-f13_12*I13/T13+N_flux+lanmda*I12", 11, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I3t-f9_13*I9/T9-f10_13*I10/T10-f14_13*I14/T14+(1+epsilon13)*I13/T13+lanmda*I13", 12, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I14t-f7_14*I7/T7-f8_14*I8/T8-f11_14*I11/T11+(1+epsilon14)*I14/T14+lanmda*I14", 13, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 12, 0);

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();
          model.result("pg5").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I14", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I1", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I2", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I3", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I4", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I5", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I6", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I7", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I8", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I9", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I10", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I11", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I14", 0);
          model.result("pg2").run();
          model.result("pg1").run();

          model.param().set("I12_ini", "3.5[kg]");

          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg2").run();

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.param().set("I12_ini", "1.5[kg]");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").set("ylog", false);
          model.result("pg1").set("xlog", false);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "N_flux", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "f_e*beta*I1/T1", 0);
          model.result("pg2").run();

          model.label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (\u52a0\u94fa\u5e95).mph");

          model.result("pg2").run();

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I2t-(1-f_e)*I1/T1-f_e*(1-beta)*f15_2*I1/T1+(epsilon2)*I2/T2+lanmda*I2", 1,
                              0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I2t-(1-f_e)*I1/T1-f_e*(1-beta)*f15_2*I1/T1+(epsilon2)*I2/T2+lanmda*I2+if(I2>I2_sat, (I2-I2_sat)/T2), 0)",
                              1, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I2t-(1-f_e)*I1/T1-f_e*(1-beta)*f15_2*I1/T1+(epsilon2)*I2/T2+lanmda*I2+if(I2>I2_sat, (I2-I2_sat)/T2, 0)",
                              1, 0);

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I3t-if(I2>I2_sat, (I2-I2_sat)/T2, 0)+(1+epsilon3)*I3/T3+lanmda*I3", 2, 0);

          return model;
     }

     public static Model run5(Model model) {

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I2", 0);
          model.result("pg2").run();

          model.component("comp1").variable().create("var2");
          model.component("comp1").variable("var2").set("I2_flux", "if(I2>I2_sat, (I2-I2_sat)/T2, 0)");
          model.component("comp1").variable("var2").descr("I2_flux", "\u5e26\u94fa\u5e95\uff0c\u7b49\u6548\u4e8eI/T");
          model.component("comp1").variable("var2").label("\u5e26\u94fa\u5e95\u7b49\u6548\u8d28\u91cf\u6d41");
          model.component("comp1").variable("var2").set("I9_flux", "if(I9>I9_sat, (I9-I9_sat)/T9, 0)");
          model.component("comp1").variable("var2").set("I10_flux", "if(I10>I10_sat, (I10-I10_sat)/T10, 0)");
          model.component("comp1").variable("var2").set("I11_flux", "if(I11>I11_sat, (I11-I11_sat)/T11, 0)");
          model.component("comp1").variable("var2").set("I13_flux", "if(I13>I13_sat, (I13-I13_sat)/T13, 0)");
          model.component("comp1").variable("var2").set("I14_flux", "if(I14>I14_sat, (I14-I14_sat)/T14, 0)");

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I2t-(1-f_e)*I1/T1-f_e*(1-beta)*f15_2*I1/T1+(epsilon2)*I2/T2+lanmda*I2+I2_flux", 1, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I3t-I2_flux+(1+epsilon3)*I3/T3+lanmda*I3", 2, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I9t-f7_9*I7/T7-f8_9*I8/T8+(epsilon9)*I9/T9+lanmda*I9+I9_flux", 8, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I3t-f9_13*I9_flux-f10_13*I10/T10-f14_13*I14/T14+(1+epsilon13)*I13/T13+lanmda*I13", 12,
                              0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I10t-f6_10*I6/T6+(epsilon10)*I10/T10+lanmda*I10+I10_flux", 9, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I3t-f9_13*I9_flux-f10_13*I10_flux-f14_13*I14/T14+(1+epsilon13)*I13/T13+lanmda*I13", 12,
                              0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I11t-f3_11*I3/T3+(epsilon11)*I11/T11+lanmda*I11+I11_flux", 10, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I12t-f3_12*I3/T3-f11_12*I11_flux-f13_12*I13/T13+N_flux+lanmda*I12", 11, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I14t-f7_14*I7/T7-f8_14*I8/T8-f11_14*I11_flux+(1+epsilon14)*I14/T14+lanmda*I14", 13, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I3t-f9_13*I9_flux-f10_13*I10_flux-f14_13*I14/T14+(epsilon13)*I13/T13+lanmda*I13+I13_flux",
                              12, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I12t-f3_12*I3/T3-f11_12*I11_flux-f13_12*I13_flux+N_flux+lanmda*I12", 11, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I14t-f7_14*I7/T7-f8_14*I8/T8-f11_14*I11_flux+(epsilon14)*I14/T14+lanmda*I14+I14_flux",
                              13, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I3t-f9_13*I9_flux-f10_13*I10_flux-f14_13*I14_flux+(epsilon13)*I13/T13+lanmda*I13+I13_flux",
                              12, 0);

          model.param().set("I12_ini", "3.5[kg]");
          model.param().set("I13_ini", "0.0[kg]");

          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I9", 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I10", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I11", 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I14", 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13_flux", 0);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature().duplicate("glob2", "glob1");
          model.result("pg2").run();
          model.result("pg2").feature("glob2").setIndex("expr", "I13>I13_sat", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").active(false);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I13", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob2").active(false);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").active(true);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob2").active(true);
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob2").active(false);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I9_flux", 0);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I10_flux", 1);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I14_flux", 2);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I1_flux", 3);
          model.result("pg2").feature("glob1").setIndex("expr", 3, 3);
          model.result("pg2").feature("glob1").setIndex("expr", "I13_flux", 3);
          model.result("pg2").run();

          model.param("par4").set("epsilon13", "0");

          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "", 3);
          model.result("pg2").run();

          model.param("par4").set("epsilon13", "1e-4");

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I13t-f9_13*I9_flux-f10_13*I10_flux-f14_13*I14_flux+(epsilon13)*I13/T13+lanmda*I13+I13_flux",
                              12, 0);

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").set("xdataparamunit", "d");
          model.result("pg2").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*300)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg2").feature("glob1").setIndex("expr", "I11_flux", 2);
          model.result("pg2").feature("glob1").setIndex("expr", "I13_flux", 3);
          model.result("pg2").feature("glob1").setIndex("expr", "I14_flux", 4);
          model.result("pg2").feature("glob1").setIndex("descr", "CPS\u5411\u4e0b\u6e38\u6d41\u91cf", 0);
          model.result("pg2").feature("glob1").setIndex("descr", "TES\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41", 1);
          model.result("pg2").feature("glob1").setIndex("descr", "CPS\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41", 0);
          model.result("pg2").feature("glob1").setIndex("descr", "I-ISS\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41", 2);
          model.result("pg2").feature("glob1").setIndex("descr", "O-ISS\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41", 3);
          model.result("pg2").feature("glob1").setIndex("descr", "WDS\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41", 4);
          model.result("pg2").run();
          model.result("pg2").feature("glob1").set("linemarker", "cycle");
          model.result("pg2").run();
          model.result("pg2").run();
          model.result("pg2").label("\u5e26\u94fa\u5e95\u6a21\u5757\u5411\u4e0b\u6e38\u8d28\u91cf\u6d41");
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob2").active(false);
          model.result("pg3").run();
          model.result("pg3").feature("glob3").active(false);
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("expr", "I14", 0);
          model.result("pg3").run();
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").set("xlog", false);
          model.result("pg1").set("ylog", false);

          model.label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (\u52a0\u94fa\u5e95).mph");

          model.result("pg1").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg5").run();
          model.result("pg3").run();
          model.result("pg2").run();
          model.result("pg3").run();
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("descr", "", 0);
          model.result("pg3").feature("glob1").setIndex("expr", "I1+I2+I3+I4+I5+I6+I7+I8+I9+I10+I11+I12+I13+I14", 0);
          model.result("pg3").run();
          model.result("pg3").feature("glob1").set("xdataparamunit", "d");
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("descr", "\u6c1a\u5de5\u5382\u4e2d\u6c1a\u603b\u8d28\u91cf", 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob2").active(true);
          model.result("pg3").run();
          model.result("pg3").feature("glob2").set("xdataparamunit", "d");
          model.result("pg3").run();
          model.result("pg3").feature().remove("glob2");
          model.result("pg3").run();
          model.result("pg3").feature().remove("glob3");
          model.result("pg3").run();
          model.result("pg5").run();
          model.result("pg5").run();
          model.result("pg5").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").active(false);
          model.result("pg3").feature().duplicate("glob2", "glob1");
          model.result("pg3").run();
          model.result("pg3").feature("glob2").setIndex("expr", "I6", 0);
          model.result("pg3").feature("glob2").setIndex("descr", "", 0);
          model.result("pg3").feature("glob2").active(true);
          model.result("pg3").run();
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg2").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*10)");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.param().set("I12_ini", "3.[kg]");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").feature("glob1").setIndex("expr", "", 0);
          model.result("pg1").feature("glob1").setIndex("expr", "", 1);
          model.result("pg1").feature("glob1").setIndex("expr", "", 3);
          model.result("pg1").feature("glob1").setIndex("expr", "", 4);
          model.result("pg1").feature("glob1").setIndex("expr", "", 6);
          model.result("pg1").feature("glob1").setIndex("expr", "", 7);
          model.result("pg1").feature("glob1").setIndex("expr", "", 8);
          model.result("pg1").feature("glob1").setIndex("expr", "", 13);
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").set("ylabelactive", true);
          model.result("pg1").set("ylabel", "\u76d8\u5b58\uff08kg\uff09");
          model.result("pg1").set("legendmaxwidthinside", 0.6);
          model.result("pg1").run();
          model.result("pg1").set("legendmaxwidthinside", 1);
          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").set("legendmaxwidthinside", 0.5);
          model.result("pg1").run();

          model.label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (\u52a0\u94fa\u5e95).mph");

          model.result("pg1").run();

          model.variable("var1").set("N_flux", "f_pulse(t)*P_fusion*factor1");
          model.variable("var1")
                    .descr("N_flux", "\u7b49\u79bb\u5b50\u4f53\u4e2d\u6c1a\u71c3\u70e7\u6d88\u8017\u901f\u7387");

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I1t-N_flux/(beta*f_e)-lanmda*I1+(1+epsilon1)*I1/T1+lanmda*I1", 0, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I2t-f15_2*I1/T1+(epsilon2)*I2/T2+lanmda*I2+I2_flux", 1, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I2t-f15_2*I15/T15+(epsilon2)*I2/T2+lanmda*I2+I2_flux", 1, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("name", "I15", 14, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", "", 14, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", 0, 14, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueUt", 0, 14, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "", 14, 0);
          model.component("comp1").physics("ge").feature("ge1").setIndex("equation", 1, 14, 0);

          model.param("par2").set("T15", "5[s]");
          model.param("par2").descr("T15", "\u7b49\u79bb\u5b50\u4f53\u4e2d\u6c1a\u6ede\u7559\u65f6\u95f4");

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I4t-f15_4*I15/T15+(1+epsilon4)*I4/T4+lanmda*I4", 3, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I5t-f_f15_5*I15/T15+(1+epsilon5)*I5/T5+lanmda*I5", 4, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I5t-f15_5*I15/T15+(1+epsilon5)*I5/T5+lanmda*I5", 4, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I6t-N_flux*TBR+(1+epsilon6)*I6/T6+lanmda*I6", 5, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I12t-f3_12*I3/T3-f11_12*I11_flux-f13_12*I13_flux+(1+epsilon12)*(N_flux/(f_e*beta)+lanmda*I1)+lanmda*I12",
                              11, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I15t-N_flux/(f_e*beta)+I15/T15+N_flux+lanmda*I15", 14, 0);

          model.result("pg1").run();

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model
                    .label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (\u52a0\u94fa\u5e95)\uff08\u52a0\u7b49\u79bb\u5b50\u4f53\u6a21\u5757\uff09.mph");

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob2").setIndex("expr", "N_flux", 0);
          model.result("pg3").run();
          model.result("pg3").feature("glob2").setIndex("expr", "N_flux*3600[s/h]", 0);
          model.result("pg3").run();
          model.result("pg3").feature("glob2").setIndex("expr", "N_flux", 0);
          model.result("pg3").feature("glob2").setIndex("unit", "g/h", 0);
          model.result("pg3").run();

          model.variable("var1").rename("N_flux", "N_flux1");
          model.variable("var1").set("N_flux", "f_pulse(t)*9.60984[g/h]");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I12t-f3_12*I3/T3-f11_12*I11_flux-f13_12*I13_flux+(1+epsilon12)*(N_flux/(f_e*beta))+lanmda*I12",
                              11, 0);

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*100)");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.param().set("TBR", "1.05");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.param().set("TBR", "1.08");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob2").active(false);
          model.result("pg3").run();
          model.result("pg3").feature("glob1").active(true);
          model.result("pg3").run();

          model.param().set("TBR", "1.1");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();

          model.param().set("TBR", "1.05");
          model.param().set("f_e", "0.8");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("expr", "I1+I2+I3+I4+I5+I6+I7+I8+I9+I10+I11+I12+I13+I14+I15",
                    0);
          model.result("pg3").run();

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I12t-f3_12*I3/T3-f11_12*I11_flux-f13_12*I13_flux+(1+epsilon12)*(N_flux/(f_e*beta)+lanmda*I1)+lanmda*I12",
                              11, 0);

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.param().set("TBR", "1.1");
          model.param().set("f_e", "0.5");

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*10)");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.study("std1").feature("time").set("tlist", "range(0,36,86400*10)");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*10)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").feature("glob1").set("linewidth", 3);
          model.result("pg1").run();
          model.result("pg1").feature("glob1").setIndex("expr", "I1", 0);
          model.result("pg1").feature("glob1").setIndex("expr", "I2", 1);
          model.result("pg1").run();
          model.result("pg1").feature("glob1").setIndex("expr", "I4", 3);
          model.result("pg1").feature("glob1").setIndex("expr", "I5", 4);
          model.result("pg1").feature("glob1").setIndex("expr", "I6", 6);
          model.result("pg1").feature("glob1").setIndex("expr", "I7", 6);
          model.result("pg1").run();
          model.result("pg1").feature("glob1").setIndex("expr", "I9", 7);
          model.result("pg1").feature("glob1").setIndex("expr", "I9", 8);
          model.result("pg1").feature("glob1").setIndex("expr", "I8", 7);
          model.result("pg1").run();
          model.result("pg1").feature("glob1").setIndex("expr", "I14", 13);
          model.result("pg1").run();
          model.result("pg1").set("ylog", true);
          model.result("pg1").run();
          model.result("pg1").set("axislimits", true);
          model.result("pg1").set("ymin", 6.263145850519937E-12);
          model.result("pg1").run();
          model.result("pg1").set("ymin", "6.263145850519937E-8");
          model.result("pg1").run();
          model.result("pg1").set("ymin", 6.263145850519937E-10);
          model.result("pg1").run();
          model.result("pg1").set("ylog", false);

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*300)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").set("axislimits", false);
          model.result("pg1").run();
          model.result("pg1").set("ylog", false);
          model.result("pg1").run();

          model
                    .label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (\u52a0\u94fa\u5e95)\uff08\u52a0\u7b49\u79bb\u5b50\u4f53\u6a21\u5757\uff09.mph");

          model.result("pg1").run();

          model.param().set("lanmda", "1.78e-9[1/s]");

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*10)");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.sol("sol1").feature("t1").set("maxstepconstraintbdf", "const");
          model.sol("sol1").feature("t1").set("maxstepbdf", 1);
          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.sol("sol1").feature("t1").set("maxstepconstraintbdf", "auto");

          model.variable("var1").set("N_flux", "f_pulse(t)*0.002654[g/s]");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.param().set("lanmda", "1.78e-9[1/h]");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.param().set("lanmda", "1.78e-9[1/s]");
          model.param("par4").set("epsilon12", "1e-4");
          model.param("par4").set("epsilon1", "1e-4");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.param().set("lanmda", "1.78e-9[1/h]");

          model.sol("sol1").runAll();

          model.result("pg1").run();

          model.param().set("lanmda", "1.78e-9[1/s]");

          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I2t-f15_2*I15/T15+(1+epsilon2)*I2_flux+lanmda*I2", 1, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I9t-f7_9*I7/T7-f8_9*I8/T8+(1+epsilon9)*I9/T9+lanmda*I9+I9_flux", 8, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I9t-f7_9*I7/T7-f8_9*I8/T8+(1+epsilon9)*I9_flux+lanmda*I9", 8, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I10t-f6_10*I6/T6+(1+epsilon10)*I10_flux+lanmda*I10", 9, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation", "I11t-f3_11*I3/T3+(1+epsilon11)*I11_flux+lanmda*I11", 10, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I13t-f9_13*I9_flux-f10_13*I10_flux-f14_13*I14_flux+(1+epsilon13)*I13_flux+lanmda*I13",
                              12, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I14t-f7_14*I7/T7-f8_14*I8/T8-f11_14*I11_flux+(1+epsilon14)*I14/T14+lanmda*I14+I14_flux",
                              13, 0);
          model.component("comp1").physics("ge").feature("ge1")
                    .setIndex("equation",
                              "I14t-f7_14*I7/T7-f8_14*I8/T8-f11_14*I11_flux+(1+epsilon14)*I14_flux+lanmda*I14", 13, 0);

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").feature("glob1").setIndex("expr", "", 0);
          model.result("pg1").feature("glob1").setIndex("expr", "", 1);
          model.result("pg1").feature("glob1").setIndex("expr", "", 3);
          model.result("pg1").feature("glob1").setIndex("expr", "", 4);
          model.result("pg1").feature("glob1").setIndex("expr", "", 6);
          model.result("pg1").feature("glob1").setIndex("expr", "", 7);
          model.result("pg1").feature("glob1").setIndex("expr", "", 8);
          model.result("pg1").feature("glob1").setIndex("expr", "", 13);
          model.result("pg1").run();

          model.study("std1").feature("time").set("tlist", "range(0,360,86400*300)");

          model.sol("sol1").runAll();

          model.result("pg1").run();
          model.result("pg1").run();
          model.result("pg1").feature("glob1").setIndex("expr", "I1", 0);
          model.result("pg1").feature("glob1").setIndex("expr", "I2", 1);
          model.result("pg1").feature("glob1").setIndex("expr", "I4", 3);
          model.result("pg1").feature("glob1").setIndex("expr", "I5", 4);
          model.result("pg1").feature("glob1").setIndex("expr", "I7", 6);
          model.result("pg1").feature("glob1").setIndex("expr", "I8", 7);
          model.result("pg1").feature("glob1").setIndex("expr", "I9", 8);
          model.result("pg1").feature("glob1").setIndex("expr", "I14", 13);
          model.result("pg1").feature("glob1").setIndex("expr", "I15", 14);
          model.result("pg1").run();

          model.component("comp1").physics("ge").feature("ge1").setIndex("description", "Plasma", 14, 0);

          model.result("pg1").run();
          model.result("pg1").feature("glob1").setIndex("descr", "Plasma", 14);
          model.result("pg1").run();
          model.result("pg2").run();

          model
                    .label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (\u52a0\u94fa\u5e95)\uff08\u52a0\u7b49\u79bb\u5b50\u4f53\u6a21\u5757\uff09.mph");

          model.result("pg2").run();
          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("expr", "I6", 0);
          model.result("pg3").run();

          model
                    .label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (\u52a0\u94fa\u5e95)\uff08\u52a0\u7b49\u79bb\u5b50\u4f53\u6a21\u5757\uff09.mph");

          model.result("pg3").run();
          model.result("pg1").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("expr", "I14", 0);
          model.result("pg3").run();

          model
                    .label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (\u52a0\u94fa\u5e95)\uff08\u52a0\u7b49\u79bb\u5b50\u4f53\u6a21\u5757\uff09.mph");

          model.result("pg3").run();

          model.study("std1").create("param", "Parametric");
          model.study("std1").create("batsw", "BatchSweep");
          model.study("std1").feature().remove("param");
          model.study("std1").feature("batsw").set("sweeptype", "filled");
          model.study("std1").feature("batsw").setIndex("pname", "AF", 0);
          model.study("std1").feature("batsw").setIndex("plistarr", "", 0);
          model.study("std1").feature("batsw").setIndex("punit", "", 0);
          model.study("std1").feature("batsw").setIndex("pname", "AF", 0);
          model.study("std1").feature("batsw").setIndex("plistarr", "", 0);
          model.study("std1").feature("batsw").setIndex("punit", "", 0);
          model.study("std1").feature("batsw").setIndex("pname", "beta", 0);
          model.study("std1").feature("batsw").setIndex("plistarr", "0.01 0.02 0.03", 0);
          model.study("std1").feature("batsw").setIndex("pname", "AF", 1);
          model.study("std1").feature("batsw").setIndex("plistarr", "", 1);
          model.study("std1").feature("batsw").setIndex("punit", "", 1);
          model.study("std1").feature("batsw").setIndex("pname", "AF", 1);
          model.study("std1").feature("batsw").setIndex("plistarr", "", 1);
          model.study("std1").feature("batsw").setIndex("punit", "", 1);
          model.study("std1").feature("batsw").setIndex("pname", "f_e", 1);
          model.study("std1").feature("batsw").setIndex("plistarr", "0.1 0.3 0.5", 1);
          model.study("std1").feature("batsw").set("maxallow", 3);

          model.batch().create("b1", "Batch");
          model.batch("b1").study("std1");
          model.batch("b1").create("so1", "Solutionseq");
          model.batch("b1").feature("so1").set("seq", "sol1");
          model.batch("b1").feature("so1").set("store", "on");
          model.batch("b1").feature("so1").set("clear", "on");
          model.batch("b1").feature("so1").set("psol", "none");
          model.batch("b1").set("batchfile", "batchmodel.mph");
          model.batch("b1").set("batchfileactive", "off");
          model.batch("b1").set("batchdir", "C:\\Users\\jiang\\Documents\\COMSOL\\Batch");
          model.batch("b1").set("paramfilename", "on");
          model.batch("b1").set("synchsolutions", "on");
          model.batch("b1").set("clearsynchdata", "on");
          model.batch("b1").set("savemodelaftersynch", "off");
          model.batch("b1").attach("std1");
          model.batch("b1").set("control", "batsw");
          model.batch().create("p1", "Parametric");
          model.batch("p1").study("std1");

          model.result().table().create("tbl2", "Table");
          model.result().table("tbl2").label("Accumulated Probe \u8868\u683c 2");

          model.study("std1").feature("batsw").set("accumtable", "tbl2");

          model.batch("p1").create("jo1", "Jobseq");
          model.batch("p1").feature("jo1").set("seq", "b1");
          model.batch("p1").set("pname", new String[] { "beta", "f_e" });
          model.batch("p1").set("plistarr", new String[] { "0.01 0.02 0.03", "0.1 0.3 0.5" });
          model.batch("p1").set("sweeptype", "filled");
          model.batch("p1").set("err", "on");
          model.batch("p1").attach("std1");
          model.batch("p1").set("control", "batsw");

          model.sol().create("sol2");
          model.sol("sol2").study("std1");
          model.sol("sol2").label("\u53c2\u6570\u5316\u89e3 1");

          model.batch("b1").feature("so1").set("psol", "sol2");
          model.batch("p1").run("compute");
          model.batch("b1").feature("daDef").run();

          model.result().numerical().create("gev2", "EvalGlobal");
          model.result().numerical("gev2").set("data", "dset2");
          model.result().numerical("gev2")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11", "I12", "I13", "I14", "I15" });
          model.result().numerical("gev2")
                    .set("descr",
                              new String[] { "\u52a0\u6599\u7cfb\u7edf", "\u6cf5\u62bd\u7cfb\u7edf", "TEP",
                                        "\u7b2c\u4e00\u58c1", "\u504f\u6ee4\u5668", "\u5305\u5c42",
                                        "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242", "\u504f\u6ee4\u5668\u51b7\u5374\u5242",
                                        "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf", "TES",
                                        "I-ISS", "SDS", "O-ISS", "WDS", "Plasma" });
          model.result().create("pg6", "PlotGroup1D");
          model.result("pg6").set("data", "dset2");
          model.result("pg6").create("glob1", "Global");
          model.result("pg6").feature("glob1")
                    .set("expr", new String[] { "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
                              "I11", "I12", "I13", "I14", "I15" });
          model.result("pg6").feature("glob1")
                    .set("descr",
                              new String[] { "\u52a0\u6599\u7cfb\u7edf", "\u6cf5\u62bd\u7cfb\u7edf", "TEP",
                                        "\u7b2c\u4e00\u58c1", "\u504f\u6ee4\u5668", "\u5305\u5c42",
                                        "\u7b2c\u4e00\u58c1\u51b7\u5374\u5242", "\u504f\u6ee4\u5668\u51b7\u5374\u5242",
                                        "\u51b7\u5374\u5242\u51c0\u5316\u7cfb\u7edf", "TES",
                                        "I-ISS", "SDS", "O-ISS", "WDS", "Plasma" });
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").set("data", "dset2");
          model.result("pg3").setIndex("looplevelinput", "manual", 2);
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 2);
          model.result("pg3").setIndex("looplevelinput", "manual", 1);
          model.result("pg3").setIndex("looplevel", new int[] { 1 }, 1);
          model.result("pg3").run();
          model.result("pg3").feature("glob1").setIndex("expr", "I12", 0);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevel", new int[] { 2 }, 1);
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevel", new int[] { 3 }, 1);
          model.result("pg3").run();
          model.result("pg3").setIndex("looplevel", new int[] { 3 }, 2);
          model.result("pg3").run();
          model.result("pg3").run();
          model.result("pg3").feature("glob1").set("xdatasolnumtype", "level1");
          model.result("pg3").run();

          model
                    .label("\u7b49\u6240\u6a21\u578b\u590d\u73b0 (\u52a0\u94fa\u5e95)\uff08\u52a0\u7b49\u79bb\u5b50\u4f53\u6a21\u5757\uff09.mph");

          model.result("pg3").run();

          return model;
     }

     public static void main(String[] args) {
          Model model = run();
          model = run2(model);
          model = run3(model);
          model = run4(model);
          run5(model);
     }

}
