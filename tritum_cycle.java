/*
 * tritum_cycle.java
 * 已修复编译错误：移除 AI 引用标记并修正变量命名
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

public class tritum_cycle {

    public static Model run() {
        Model model = ModelUtil.create("Model");
        // 设置模型工作路径
        model.modelPath("D:\\Administrator\\Documents\\Github\\tricys_mph");

        // 1. 组件与物理场设置
        model.component().create("comp1", true);
        model.component("comp1").physics().create("ge", "GlobalEquations");
        model.component("comp1").physics("ge").prop("EquationForm").set("form", "Automatic");

        // 2. 脉冲操作分析函数
        model.func().create("an1", "Analytic");
        model.func("an1").set("funcname", "f_pulse");
        model.func("an1").set("expr", "if(x<T_cycle*AF, 1, 0)");
        model.func("an1").set("periodic", true);
        model.func("an1").set("periodicupper", "T_cycle");
        model.func("an1").setIndex("argunit", "s", 0);
        model.func("an1").set("fununit", "1");

        // 3. 全局物理参数
        model.param().label("Global Parameters");
        model.param().set("TBR", "1.1", "Tritium Breeding Ratio");
        model.param().set("beta", "0.06", "Burn efficiency");
        model.param().set("f_e", "0.5", "Fueling efficiency");
        model.param().set("AF", "0.5", "Duty cycle");
        model.param().set("T_cycle", "3[h]", "Operation Cycle Period");
        model.param().set("P_fusion", "1500[MW]", "Fusion Power");
        model.param().set("factor1", "1.7805e-6[g/s/MW]", "Consumption per MW");
        model.param().set("lanmda", "1.78e-9[1/s]", "Decay constant");

        // 3.2 滞留时间 (T1-T15)
        model.param().create("par2");
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
        model.param("par2").set("T13", "6[h]");
        model.param("par2").set("T14", "48[h]");
        model.param("par2").set("T15", "5[s]");

        // 3.3 循环份额 (Flow Fractions)
        model.param().create("par3");
        model.param("par3").set("f15_2", "0.9998");
        model.param("par3").set("f15_4", "1e-4");
        model.param("par3").set("f15_5", "1e-4");
        model.param("par3").set("f6_7", "0.05");
        model.param("par3").set("f6_10", "0.95");
        model.param("par3").set("f7_9", "0.9999");
        model.param("par3").set("f7_14", "1e-4");
        model.param("par3").set("f8_9", "0.9999");
        model.param("par3").set("f8_14", "1e-4");
        model.param("par3").set("f3_11", "0.15");
        model.param("par3").set("f3_12", "0.85");
        model.param("par3").set("f11_12", "0.99999999");
        model.param("par3").set("f11_14", "1e-8");
        model.param("par3").set("f13_12", "1");
        model.param("par3").set("f9_13", "1");
        model.param("par3").set("f10_13", "1");
        model.param("par3").set("f14_13", "1"); // 修复：确保此处为下划线且无引文标记

        // 3.4 铺底量与损失率
        model.param().create("par5");
        model.param("par5").set("I12_ini", "3.5[kg]", "SDS Start Inventory");
        model.param("par5").set("I2_sat", "640[g]");
        model.param("par5").set("I9_sat", "200[g]");
        model.param("par5").set("I10_sat", "200[g]");
        model.param("par5").set("I11_sat", "300[g]");
        model.param("par5").set("I13_sat", "20[g]");
        model.param("par5").set("I14_sat", "1000[g]");

        model.param().create("par4");
        for (int i = 1; i <= 14; i++) {
            model.param("par4").set("epsilon" + i, "1e-4");
        }

        // 4. 定义通量变量
        model.component("comp1").variable().create("var1");
        model.component("comp1").variable("var1").set("N_flux", "f_pulse(t)*P_fusion*factor1");
        model.component("comp1").variable("var1").set("I2_flux", "if(I2>I2_sat, (I2-I2_sat)/T2, 0)");
        model.component("comp1").variable("var1").set("I9_flux", "if(I9>I9_sat, (I9-I9_sat)/T9, 0)");
        model.component("comp1").variable("var1").set("I10_flux", "if(I10>I10_sat, (I10-I10_sat)/T10, 0)");
        model.component("comp1").variable("var1").set("I11_flux", "if(I11>I11_sat, (I11-I11_sat)/T11, 0)");
        model.component("comp1").variable("var1").set("I13_flux", "if(I13>I13_sat, (I13-I13_sat)/T13, 0)");
        model.component("comp1").variable("var1").set("I14_flux", "if(I14>I14_sat, (I14-I14_sat)/T14, 0)");

        // 5. 控制方程 (I1-I15)
        model.component("comp1").physics("ge").feature("ge1").set("CustomDependentVariableUnit", "g");
        model.component("comp1").physics("ge").feature("ge1").set("CustomSourceTermUnit", "g/s");

        String[][] eqs = {
                { "I1", "Fueling System", "I1t - N_flux/(beta*f_e) + (1+epsilon1)*I1/T1 + lanmda*I1", "0" },
                { "I2", "Pumping System", "I2t - f15_2*I15/T15 + (1+epsilon2)*I2_flux + lanmda*I2", "0" },
                { "I3", "TEP", "I3t - I2_flux + (1+epsilon3)*I3/T3 + lanmda*I3", "0" },
                { "I4", "First Wall", "I4t - f15_4*I15/T15 + (1+epsilon4)*I4/T4 + lanmda*I4", "0" },
                { "I5", "Divertor", "I5t - f15_5*I15/T15 + (1+epsilon5)*I5/T5 + lanmda*I5", "0" },
                { "I6", "Blanket", "I6t - N_flux*TBR + (1+epsilon6)*I6/T6 + lanmda*I6", "0" },
                { "I7", "FW Coolant", "I7t - I4/T4 - f6_7*I6/T6 + (1+epsilon7)*I7/T7 + lanmda*I7", "0" },
                { "I8", "Div Coolant", "I8t - I5/T5 + (1+epsilon8)*I8/T8 + lanmda*I8", "0" },
                { "I9", "CPS", "I9t - f7_9*I7/T7 - f8_9*I8/T8 + (1+epsilon9)*I9_flux + lanmda*I9", "0" },
                { "I10", "TES", "I10t - f6_10*I6/T6 + (1+epsilon10)*I10_flux + lanmda*I10", "0" },
                { "I11", "I-ISS", "I11t - f3_11*I3/T3 + (1+epsilon11)*I11_flux + lanmda*I11", "0" },
                { "I12", "SDS Storage",
                        "I12t - f3_12*I3/T3 - f11_12*I11_flux - f13_12*I13_flux + (1+epsilon12)*(N_flux/(f_e*beta)+lanmda*I1) + lanmda*I12",
                        "I12_ini" },
                { "I13", "O-ISS System",
                        "I13t - f9_13*I9_flux - f10_13*I10_flux - f14_13*I14_flux + (1+epsilon13)*I13_flux + lanmda*I13",
                        "0" },
                { "I14", "WDS System",
                        "I14t - f7_14*I7/T7 - f8_14*I8/T8 - f11_14*I11_flux + (1+epsilon14)*I14_flux + lanmda*I14",
                        "0" },
                { "I15", "Plasma", "I15t - N_flux/(f_e*beta) + I15/T15 + N_flux + lanmda*I15", "0" }
        };

        for (int i = 0; i < eqs.length; i++) {
            model.component("comp1").physics("ge").feature("ge1").setIndex("name", eqs[i][0], i, 0);
            model.component("comp1").physics("ge").feature("ge1").setIndex("description", eqs[i][1], i, 0);
            model.component("comp1").physics("ge").feature("ge1").setIndex("equation", eqs[i][2], i, 0);
            model.component("comp1").physics("ge").feature("ge1").setIndex("initialValueU", eqs[i][3], i, 0);
        }

        // 6. 研究设置 (360 天，步长 1 天)
        model.study().create("std1");
        model.study("std1").create("time", "Transient");
        model.study("std1").feature("time").set("tlist", "range(0, 86400, 86400*360)");

        // 7. 求解器配置
        model.sol().create("sol1");
        model.sol("sol1").study("std1");
        model.sol("sol1").create("st1", "StudyStep");
        model.sol("sol1").create("v1", "Variables");
        model.sol("sol1").create("t1", "Time");
        model.sol("sol1").feature("t1").set("tlist", "range(0, 86400, 86400*360)");
        model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
        model.sol("sol1").attach("std1");
        model.sol("sol1").runAll();

        // 8. 结果绘图
        model.result().create("pg1", "PlotGroup1D");
        model.result("pg1").label("Full Tritium Inventory Comparison");
        model.result("pg1").create("glob1", "Global");
        String[] allVars = new String[15];
        for (int i = 0; i < 15; i++)
            allVars[i] = eqs[i][0];
        model.result("pg1").feature("glob1").set("expr", allVars);
        model.result("pg1").feature("glob1").set("legend", true);
        model.result("pg1").feature("glob1").set("legendmethod", "manual");
        for (int i = 0; i < 15; i++)
            model.result("pg1").feature("glob1").setIndex("legends", eqs[i][1], i);

        // 关键参数 SDS 趋势图
        model.result().create("pg2", "PlotGroup1D");
        model.result("pg2").label("SDS Tritium Inventory Trend");
        model.result("pg2").create("glob2", "Global");
        model.result("pg2").feature("glob2").set("expr", new String[] { "I12" });
        model.result("pg2").feature("glob2").set("legend", true);
        model.result("pg2").feature("glob2").set("legendmethod", "manual");
        model.result("pg2").feature("glob2").setIndex("legends", "SDS Storage", 0);

        // 9. 导出
        model.result().export().create("img1", "Image");
        model.result().export("img1").set("sourceobject", "pg1");
        model.result().export("img1").set("filename",
                "D:\\Administrator\\Documents\\Github\\tricys_mph\\full_cycle_plot.png");
        model.result().export("img1").run();

        model.result().export().create("img2", "Image");
        model.result().export("img2").set("sourceobject", "pg2");
        model.result().export("img2").set("filename",
                "D:\\Administrator\\Documents\\Github\\tricys_mph\\sds_inventory_plot.png");
        model.result().export("img2").run();

        return model;
    }

    public static void main(String[] args) {
        run();
    }
}