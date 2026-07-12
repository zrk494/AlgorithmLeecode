# LeetCode 面试经典 150 题 · Phase 1 设计文档

- **创建日期**：2026-07-13
- **来源**：https://leetcode.cn/studyplan/top-interview-150/
- **阶段范围**：「数组 / 字符串」分类，跳过 3 道 Hard（135/42/68），共 21 道非 Hard 题
- **目标人群**：算法基础较弱，偏好「先背诵再理解」学习法，Java 熟练
- **交付仓库**：https://github.com/zrk494/AlgorithmLeecode.git

---

## 1. 7 天逐日题单（按模式聚类）

> 同一模板连做 3 道：第一道背模板、第二道套模板、第三道变模板。每日由浅入深。

| Day | 主题 | 题 1 | 题 2 | 题 3 | 关键模板/口诀 |
|-----|------|------|------|------|----------------|
| **1** | 原地删除 / 双指针 | 27 移除元素 (E) | 26 删除有序数组中的重复项 (E) | 80 删除重复项 II (M) | 快慢双指针、`cnt` 计数放行 |
| **2** | 双指针进阶：合并 / 反转 / 轮转 | 88 合并有序数组 (E) | 151 反转字符串中的单词 (M) | 189 轮转数组 (M) | 逆向填充、整体反转+逐词反转、三次反转 |
| **3** | 贪心 I：股票 + 加油 | 121 买卖股票 I (E) | 122 买卖股票 II (M) | 134 加油站 (M) | 历史最小值、累加正差、总剩余判否 |
| **4** | 贪心 II：跳跃 + 摩尔投票 | 55 跳跃游戏 (M) | 45 跳跃游戏 II (M) | 169 多数元素 (E) | 维护最远可达、当前边界步数、候选人计数 |
| **5** | 前缀后缀 + 计数统计 | 238 除自身以外的乘积 (M) | 274 H 指数 (M) | 6 Z 字形变换 (M) | 左右前缀积、计数排序、周期索引 |
| **6** | 字符串 I：罗马 / 前缀 / 末词 | 13 罗马数字转整数 (E) | 14 最长公共前缀 (E) | 58 最后一个单词的长度 (E) | 前小后减否则加、纵向扫描、从尾向前跳空格 |
| **7** | 字符串 II + 数据结构设计 + 复习 | 28 第一个匹配项下标 (E) | 380 O(1) 插入删除随机 (M) | 复习 + 模板串联 | KMP 简化 / 双表查询，HashMap+ArrayList+随机下标替换删除 |

**Day 7 说明**：第 21 个 slot 为「无新题，串联 7 天模板口诀 + 综合复盘 + ACM I/O 模板整理」。若实际题单多出 1 道（如 283 移动零），替换该 slot。

---

## 2. 每题笔记模板（先背诵再理解）

> 每题在 NOTES.md 中按此 9 块结构记录。前 4 块为「背诵卡」（题意/口诀/模板骨架/完整解法链接），后 5 块为「理解层」。

```markdown
### {题号} {中文标题} [{E/M}]  模式: {模式名}

**一句话题意**：用 ≤30 字说清输入→输出。

**记忆口诀**（≤2 句，押韵/对称优先）：
> 例：快慢双指针，慢停快跑；遇到目标跳过，否则慢位接管。

**可背模板**（伪代码骨架，跨题通用）：
  init slow, fast
  while fast < n:
      if 命中条件: 保留 → arr[slow]=arr[fast], slow++
      fast++
  return slow

**Java 完整解法**：[链接到 src/.../Solution_xxx.java]

**复杂度**：时间 O(?) / 空间 O(?)，一句话为什么。

**关键易错点**：1–3 条（如：边界、空数组、索引越界）。

**Java 基础点**：本题用到的语法/类（链到第 4 节对应小节）。
**ACM 输入套路**：本题属于哪种 I/O 格式（链到第 4 节「ACM 输入输出」）。

**关联题**：与同模式哪题同模板、差异在哪（强化"套模板"直觉）。
```

**配套背诵机制**：
1. **当天小结**：每晚 3 题结束后，附「今日 3 个模板口诀合集」（≤6 行），便于睡前默念。
2. **Day 7 串联表**：一张表汇总 7 天所有口诀，按模式列，作为 Phase 1 总背诵卡。
3. **.java 文件头注释**：复制口诀 + 一句话复杂度，离线翻代码也能背。

**对「先背诵再理解」的支撑**：
- 口诀 + 模板骨架是「先背」的最小单元，先记住再做题。
- 「理解层」5 块（复杂度/易错/Java/ACM/关联）让你在重复套用中自然理解，不强求一次吃透。
- 关联题是关键——同模式连做 3 题时，第 2、3 题只需对照口诀套用，背记强度翻倍。

---

## 3. 仓库结构与文件命名

> 工作目录：`c:\Users\26947\Desktop\summer\Algorithm`（当前为空，将初始化为 git 仓库）。

```
Algorithm/
├── README.md                         # 总目录：Phase 进度、题单索引、模板口诀速查表
├── NOTES.md                          # 汇总笔记（所有题按 Day 分节，含背诵卡+理解层）
├── .gitignore                        # 排除 *.class / .idea/ / *.iml / out/ / bin/
├── docs/
│   └── superpowers/
│       └── specs/
│           └── 2026-07-13-leetcode-top150-phase1-design.md   # 本设计文档
└── src/
    └── phase1_arrays_strings/
        ├── day1_inplace_remove/
        │   ├── Solution_27.java
        │   ├── Solution_26.java
        │   └── Solution_80.java
        ├── day2_pointer_merge_reverse/
        │   ├── Solution_88.java
        │   ├── Solution_151.java
        │   └── Solution_189.java
        ├── day3_greedy_stock_gas/
        │   ├── Solution_121.java
        │   ├── Solution_122.java
        │   └── Solution_134.java
        ├── day4_greedy_jump_majority/
        │   ├── Solution_55.java
        │   ├── Solution_45.java
        │   └── Solution_169.java
        ├── day5_prefix_count/
        │   ├── Solution_238.java
        │   ├── Solution_274.java
        │   └── Solution_6.java
        ├── day6_string_roman_prefix/
        │   ├── Solution_13.java
        │   ├── Solution_14.java
        │   └── Solution_58.java
        └── day7_string_match_ds_review/
            ├── Solution_28.java
            └── Solution_380.java
```

**命名约定**：
- 目录：`dayN_{模式英文短名}`，小写下划线。
- 文件：`Solution_{题号}.java`，类名同文件名，可直接复制到 LeetCode 提交。
- `.java` 文件头注释固定格式：
  ```java
  // 题号: 27  标题: 移除元素  难度: E  模式: 原地删除/双指针
  // 口诀: 快慢双指针，慢停快跑；遇到目标跳过，否则慢位接管。
  // 复杂度: O(n) / O(1)
  ```
- NOTES.md 内锚点用 `## Day1 · 原地删除/双指针` + `### 27 移除元素 [E]`，与目录名对齐便于检索。

**.java 文件结构**（双模式可用）：
```java
import java.util.*;                      // ACM 模式必需

public class Solution_27 {
    // ===== LeetCode 方法（可直接复制到平台）=====
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) nums[slow++] = nums[fast];
        }
        return slow;
    }

    // ===== ACM 模式入口 =====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), val = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int k = new Solution_27().removeElement(nums, val);
        System.out.println(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(nums[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
```

- LeetCode 用：复制方法体到平台即可（main 会被忽略）。
- ACM 用：本地 `javac Solution_27.java && java Solution_27 < input.txt` 直接跑。

**为什么不用 Gradle**：单文件即可在 LeetCode 在线提交验证，ACM 模式只需 `javac`；若后续想本地跑单测，再补 `build.gradle.kts`。

---

## 4. Java 基础点清单 + ACM 输入输出

> 只列与当天题目直接相关的语法/类，不做泛泛扫盲。每点附「哪题用到 + 一句话用途」。NOTES.md 中按天成节，与题目穿插。

### 4.1 按天分布的 Java 基础点

**Day 1 · 原地删除 / 双指针**
- 数组长度与下标：`arr.length`（无括号，是字段不是方法）；越界抛 `ArrayIndexOutOfBoundsException`
- `for` 与 `while` 在双指针中的选择：`while (fast < n)` 更直观表达「快针推进」
- 自增位置：`arr[slow++] = arr[fast]`（先赋值再 +1）vs `arr[++slow]`（先 +1 再赋值）——双指针几乎都用前者
- 基本类型 `int` 默认值 0；方法返回 `int` 表示新长度

**Day 2 · 双指针进阶**
- 数组填充需从尾部写：`nums[--end] = x`，避免覆盖未处理元素
- `String.toCharArray()` / `new String(char[])`：字符串不可变，反转必须走 char 数组
- `StringBuilder`：可变字符序列，`.append()` / `.reverse()` / `.toString()`；拼接单词首选
- `Math.floorMod(a, n)`：处理轮转的负数取模（`189` 旋转 k>n 时取模）

**Day 3 · 贪心 I**
- `Integer.MIN_VALUE` / `Integer.MAX_VALUE`：初始化极值常量
- `Math.min` / `Math.max`：返回同类型，自动窄化
- 增强 for 循环 `for (int p : prices)`：只读遍历首选
- `long` 求和防溢出：油站总剩余可能超 int 范围（`134`）

**Day 4 · 贪心 II + 摩尔投票**
- `break` / `continue` 在边界更新中的语义（`55` 跳跃到边界即停）
- 摩尔投票的「计数归零换人」：`if (cnt == 0) candidate = x; cnt += (x==candidate)?1:-1;`
- 三元运算符替代分支：`cnt += (x == candidate) ? 1 : -1` 比 if 更紧凑

**Day 5 · 前缀后缀 + 计数**
- 数组初始化：`int[] left = new int[n];`（默认 0）；`Arrays.fill(arr, 1)` 批量赋值
- `O(n)` 两次扫描：第一遍正向累乘、第二遍逆向累乘（`238`）
- 计数数组 `int[] cnt = new int[n+1];`：H 指数用「引用数→篇数」映射

**Day 6 · 字符串 I**
- `Map<Character,Integer>` + `getOrDefault(c, 0)`：罗马数字符号映射（`13`）
- `String.charAt(i)` / `String.substring(s, e)`：左闭右开
- `String.isEmpty()` / `length() == 0`：注意是方法（与 `arr.length` 字段区分）
- `trim()` / `split("\\s+")`：处理多空格（`58` 从尾向前更省）

**Day 7 · 字符串 II + 数据结构设计**
- `Random().nextInt(n)`：等概率随机下标（`380`）
- `Map` + `List` 组合：`Map` 存值→下标，`List` 存值；删除时「末位替换法」达 O(1)
- `List.set(i, x)` / `List.remove(List.size()-1)`：尾删 O(1)
- KMP 简化：本题暴力 `indexOf` 即可，KMP 仅作了解口诀「失配回退 next 数组」

### 4.2 ACM 输入输出专题（贯穿 7 天）

写入 NOTES.md 开头「Java 速查」节之后，独立成节，贯穿 7 天逐步熟练。

**输入类**
- `Scanner sc = new Scanner(System.in);`：最常用，慢但够用
  - `sc.nextInt()` / `sc.nextLong()` / `sc.nextDouble()` / `sc.next()`（读 token）/ `sc.nextLine()`（读整行）
  - **陷阱**：`nextInt()` 后接 `nextLine()` 会读到空行——需多一次 `nextLine()` 消耗换行符
- `BufferedReader br = new BufferedReader(new InputStreamReader(System.in));`：大数据量首选
  - `br.readLine()` 读整行，需 `StringTokenizer` 分词
  - 模板：
    ```java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StreamTokenizer st = new StreamTokenizer(br);
    st.nextToken(); int n = (int) st.nval;
    ```
- 读到 EOF：`while (sc.hasNextInt())` 或 `while ((line = br.readLine()) != null)`

**输出类**
- `System.out.print()` / `println()` / `printf("%d %.2f\n", a, b)`
- 大量输出用 `StringBuilder` 拼接后一次 `println`，避免 TLE
- `PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));`：竞赛级输出
  - `pw.flush()` 必须调用，否则输出丢失

**常见输入格式套路**（每天至少练一种）
- 单组：`n` + 数组 → Day 1/2/5
- 多组直到 EOF：`while (sc.hasNext())` → Day 3/4
- 带字符串：`nextLine()` 分词 → Day 6/7
- 二维矩阵：双重循环读 `a[i][j]`

**Day 7 复习日**专门串 ACM I/O：
- 把 7 天遇到的 4 种输入格式做成模板卡
- 练习「LeetCode 方法签名 ↔ ACM main 函数」的转换口诀

### 4.3 贯穿全程的通用点

写入 NOTES.md 开头「Java 速查」一节：
- 方法签名：LeetCode 模板已给 `public XXX methodName(params)`；ACM 需自行写 `main`
- `import` 由 LeetCode 平台自动补全；本地 IDE / ACM 需手动 `import java.util.*`
- `int[]` vs `Integer[]`：算法题几乎只用 `int[]`
- 边界判空：`if (nums == null || nums.length == 0) return ...;` 作为肌肉记忆

---

## 5. 验收标准与风险/缓解

### 5.1 验收标准

**硬性指标**（全部满足才算 Phase 1 完成）：
1. 21 道 `.java` 文件齐备，每个含 LeetCode 方法 + 可运行 main，能在 LeetCode 在线 AC
2. NOTES.md 含 21 题完整笔记（9 块结构）+ 7 个「今日口诀合集」+ 1 张「Day7 总串联表」
3. README.md 含题单索引表（题号/标题/难度/模式/Day/状态）+ 模板口诀速查表
4. 7 天每日小结在 NOTES.md 中按 Day 分节清晰可见
5. ACM I/O 专题节完整，含 4 种输入套路模板卡
6. 全部内容已推送到 GitHub 仓库 `https://github.com/zrk494/AlgorithmLeecode.git` 的 `main` 分支

**软性指标**（衡量学习效果，不强求完美）：
- 能脱稿默写 7 个核心模板口诀（快慢双指针、三次反转、股票历史最小、摩尔投票、左右前缀积、纵向扫描前缀、HashMap+List 随机）
- 能对照口诀把 80% 的题在 15 分钟内写出 LeetCode AC 解
- 能说出每题的「易错点」和「关联题差异」

### 5.2 风险与缓解

| 风险 | 影响 | 缓解 |
|------|------|------|
| **3 题/天 + ACM 练习量过大** | 中途疲劳、囫囵吞枣 | 每题限时 25 分钟；卡住直接看解法（契合「先背诵」），不硬扛；Day 7 设为纯复习无新题缓冲 |
| **「先背诵再理解」导致只记死解** | 变形题不会 | 每题强制写「关联题差异」块；Day 7 串联表按模式而非题号排列，强制横向对比 |
| **LeetCode 与 ACM 模式切换心智负担** | main 函数写错、I/O 卡住 | main 固定模板化，I/O 套路限 4 种；NOTES「ACM 输入输出」节给可直接抄的骨架 |
| **个别 Medium 难度跳跃**（如 45/274/6） | 单题耗时失控、挫败 | 这些题在 NOTES 标注「⭐重点题」，允许看解法后默写 2 遍代替独立推导 |
| **仓库无构建工具，本地难验证** | 改错不自知 | 每题 AC 后才提交 .java；本地用 `javac` 单文件编译验证 main 可跑 |
| **口诀主观、可能不准确** | 背了错口诀 | 每条口诀对应明确模板骨架，可对照代码核验；Day 7 串联时统一校对 |
| **连续 7 天中断** | 节奏断裂 | 每天结束在 README 勾选进度；中断超 2 天则 Day 7 改为「补漏日」而非「串联日」 |
| **GitHub 推送失败/冲突** | 内容丢失或不同步 | 每天提交后立即 push；冲突时先 `git pull --rebase` 再 push；spec 文档首次提交后即推送建立基线 |

### 5.3 Phase 1 完成后的衔接（预告，不在本 spec 范围）

- Phase 2：回补 Phase 1 跳过的 3 道 Hard（135/42/68）
- Phase 3：top-150 的「双指针」「滑动窗口」分类（与 Phase 1 模式高度衔接，可复用口诀）
- 届时另起 spec，沿用本仓库结构与 NOTES 风格

---

## 6. GitHub 仓库同步

**仓库**：`https://github.com/zrk494/AlgorithmLeecode.git`

**同步策略**：
- 工作目录 `c:\Users\26947\Desktop\summer\Algorithm` 初始化为 git 仓库，主分支 `main`
- 远程名 `origin`，指向上述仓库
- **提交粒度**：每完成一天（3 题 .java + 当日 NOTES 小节 + README 进度勾选）提交一次
- **commit message 格式**：`DayN: 主题 - 题号1/题号2/题号3`
- **首次提交**：包含 spec 文档 + 仓库骨架（README/NOTES 空壳 + 目录结构 + .gitignore）
- **`.gitignore` 内容**：
  ```
  *.class
  .idea/
  *.iml
  out/
  bin/
  ```
- **README.md** 含仓库说明 + Phase 进度表 + 题单索引 + 口诀速查（随进度更新）
- **推送时机**：每天结束提交后 `git push origin main`
- **冲突处理**：先 `git pull --rebase origin main`，解决冲突后再 push

**操作时序**（实现阶段执行，本 spec 仅记录策略）：
1. `git init` + `git branch -M main`
2. 创建 `.gitignore`、README.md、NOTES.md 空壳、目录结构
3. `git add .` + `git commit -m "Init: Phase 1 仓库骨架与设计文档"`
4. `git remote add origin https://github.com/zrk494/AlgorithmLeecode.git`
5. `git push -u origin main`
6. 此后每天 DayN 结束：`git add . && git commit -m "DayN: ..." && git push`

---

## 附录：设计决策摘要

| 决策项 | 选择 | 理由 |
|--------|------|------|
| 语言 | Java | 用户熟练，LeetCode 原生支持 |
| Phase 1 范围 | 21 道非 Hard | 跳过 135/42/68，先建基础 |
| 节奏 | 3 题/天 × 7 天 | 密集冲刺，7 天成型 |
| 编排 | 按模式聚类（方案 B） | 同模板连做 3 道强化背诵 |
| 协作方式 | 直接示范 + 先背诵再理解 | 用户算法偏弱，背诵优先 |
| Java 基础 | 穿插 + ACM I/O 专题 | 兼顾 LeetCode 与 ACM 模式 |
| 产出 | .java + 汇总 NOTES.md | 仓库轻、便于连续背诵 |
| 仓库 | 同步至 GitHub AlgorithmLeecode | 持久化 + 可追溯 |
