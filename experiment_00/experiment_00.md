COMSOL Java API 的**层级对象模型（Hierarchical Object Model, HOM）**是其核心架构，它模仿了 COMSOL Desktop 界面左侧的“模型开发器（Model Builder）”树状结构。通过 Java 代码操作模型，本质上就是在这一棵“对象树”中创建、修改或访问不同的分支。

以下是根据 `tritum_cycle.java` 案例，对该层级结构的详细拆解：

---

### 1. 根节点层级 (Root: Model Object)

这是所有操作的起点，代表了整个仿真文件。

* **创建与初始化**：通过 `ModelUtil.create("Model")` 创建模型实例。
* **环境设置**：定义模型存储和导出的根路径 `modelPath`。

### 2. 全局设置层级 (Global Level)

这一层级定义的设置在整个模型的所有组件（Component）中都是通用的。

* **参数 (Parameters)**：通过 `model.param()` 访问。例如定义静态常数：增殖比  和衰变常数 。
* **函数 (Functions)**：通过 `model.func()` 访问。代码中定义的脉冲函数 `f_pulse` 就是全局可调用的逻辑。

### 3. 组件层级 (Component Level)

模型可以包含多个组件（如一维、二维或三维空间），它是物理场和变量的容器。

* **创建组件**：`model.component().create("comp1", true)`。
* **变量定义 (Variables)**：组件内部通过 `model.component("comp1").variable()` 定义动态表达式。例如，随时间波动的燃烧消耗率  就是在这一层级定义的变量。

### 4. 物理场层级 (Physics Level)

物理场位于特定的组件之下，定义了具体的数学方程。

* **创建接口**：代码中创建了“全局方程”接口 `ge`。
* **特征节点 (Features)**：物理场下的具体节点。在 `tritum_cycle.java` 中，这是存储 15 个常微分方程（ODEs）的地方。
* **方程表示**：
* 使用 `It` 代表变量对时间的导数  。


* API 采用**残差形式**：。例如加料系统方程被编写为 。



### 5. 研究与求解器层级 (Study & Solver Level)

这一层级决定了如何进行数值计算。

* **研究 (Study)**：定义模拟类型（如瞬态 `Transient`）和时间步长。修正后的步长 `range(0, 86400, 86400*360)` 确保了 360 天的完整计算。
* **求解器序列 (Solver Sequence)**：通过 `model.sol()` 控制具体的算法细节。
* **Variables (v1)**：指定待求解的未知数（I1 到 I15）。
* **Time (t1)**：设置具体的时间步进算法（如 BDF 法）。
* **Fully Coupled (fc1)**：定义系统变量之间是全耦合计算还是分离式计算。



### 6. 结果与后处理层级 (Results & Post-processing Level)

计算完成后的数据提取与展示。

* **数值评估 (Numerical)**：如 `gev1` 节点，用于在内存中评估变量数值。
* **图表组 (Plot Groups)**：
* `pg1`：全循环对比图。
* `pg2`：SDS 专项趋势图，通过指定 `expr` 为 `I12` 聚焦关键参数。


* **导出 (Export)**：通过 `model.result().export()` 将内存中的图像或表格写出到硬盘。

---

### 层级对象总结表

| 层级 | 对应的 Java API | 在案例中的作用 |
| --- | --- | --- |
| **根节点** | `Model` | 整个氚循环仿真容器 |
| **全局设置** | `param()`, `func()` | 定义 TBR、周期函数等基础逻辑 |
| **组件层** | `component()` | 提供空间上下文，承载变量 `N_flux` |
| **物理层** | `physics()` | 编写 I1-I15 的核物理微分方程 |
| **求解层** | `study()`, `sol()` | 控制求解 360 天的瞬态过程 |
| **结果层** | `result()`, `export()` | 生成 SDS 趋势图并导出 CSV 数据 |

