# LeetCode 面试经典 150 题 · Phase 1 实现计划

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** 完成 top-150「数组/字符串」分类 21 道非 Hard 题，建立可背诵的算法模板体系与 ACM 输入输出能力，同步至 GitHub。

**Architecture:** 工作目录 `c:\Users\26947\Desktop\summer\Algorithm` 初始化为 git 仓库，按 Day 分目录组织 `.java` 文件（双模式：LeetCode 方法 + ACM main），NOTES.md 汇总笔记（9 块结构/题），README.md 索引进度，每日提交推送至 `https://github.com/zrk494/AlgorithmLeecode.git`。

**Tech Stack:** Java（JDK 8+），git，LeetCode 在线判题，本地 `javac` 编译验证 ACM 模式。

**Spec 参考**：[2026-07-13-leetcode-top150-phase1-design.md](file:///c:/Users/26947/Desktop/summer/Algorithm/docs/superpowers/specs/2026-07-13-leetcode-top150-phase1-design.md)

---

## 文件结构总览

| 文件/目录 | 职责 | 创建时机 |
|-----------|------|----------|
| `.gitignore` | 排除构建产物与 IDE 文件 | Task 0 |
| `README.md` | 仓库说明 + Phase 进度表 + 题单索引 + 口诀速查 | Task 0（骨架），每天更新 |
| `NOTES.md` | 汇总笔记：Java 速查 + ACM I/O 专题 + 21 题 9 块笔记 + 7 个日小结 + Day7 串联表 | Task 0（骨架），每天追加 |
| `docs/superpowers/specs/*.md` | 已存在的设计文档 | Task 0 提交 |
| `docs/superpowers/plans/*.md` | 本计划文档 | Task 0 提交 |
| `src/phase1_arrays_strings/dayN_*/Solution_XXX.java` | 21 道题的双模式 Java 解法 | Task 1–7 |

**验证策略**（适配算法题场景，替代传统 TDD）：
- LeetCode 在线 AC 是主验证（方法体正确性）
- 本地 `javac Solution_XXX.java` 验证编译（含 main 与 import）
- 本地 `java Solution_XXX < input.txt` 验证 ACM I/O
- 每题通过后才进 git 提交

---

## Task 0: 仓库初始化与骨架

**Files:**
- Create: `c:\Users\26947\Desktop\summer\Algorithm\.gitignore`
- Create: `c:\Users\26947\Desktop\summer\Algorithm\README.md`
- Create: `c:\Users\26947\Desktop\summer\Algorithm\NOTES.md`
- Create: `c:\Users\26947\Desktop\summer\Algorithm\src\phase1_arrays_strings\day1_inplace_remove\.gitkeep`
- Create: `c:\Users\26947\Desktop\summer\Algorithm\src\phase1_arrays_strings\day2_pointer_merge_reverse\.gitkeep`
- Create: `c:\Users\26947\Desktop\summer\Algorithm\src\phase1_arrays_strings\day3_greedy_stock_gas\.gitkeep`
- Create: `c:\Users\26947\Desktop\summer\Algorithm\src\phase1_arrays_strings\day4_greedy_jump_majority\.gitkeep`
- Create: `c:\Users\26947\Desktop\summer\Algorithm\src\phase1_arrays_strings\day5_prefix_count\.gitkeep`
- Create: `c:\Users\26947\Desktop\summer\Algorithm\src\phase1_arrays_strings\day6_string_roman_prefix\.gitkeep`
- Create: `c:\Users\26947\Desktop\summer\Algorithm\src\phase1_arrays_strings\day7_string_match_ds_review\.gitkeep`

- [ ] **Step 1: 初始化 git 仓库**

Run:
```bash
cd "c:\Users\26947\Desktop\summer\Algorithm"
git init
git branch -M main
```
Expected: `Initialized empty Git repository in ...`

- [ ] **Step 2: 创建 `.gitignore`**

```
*.class
.idea/
*.iml
out/
bin/
```

- [ ] **Step 3: 创建 7 个 day 目录的 `.gitkeep`**

每个目录放空 `.gitkeep` 占位，确保空目录能被 git 跟踪。

- [ ] **Step 4: 创建 `README.md` 骨架**

```markdown
# AlgorithmLeecode

LeetCode 面试经典 150 题刷题仓库。Phase 1：「数组/字符串」分类 21 道非 Hard 题。

## Phase 进度

| Phase | 分类 | 范围 | 状态 |
|-------|------|------|------|
| 1 | 数组/字符串 | 21 道非 Hard | 进行中 |
| 2 | 数组/字符串 Hard 回补 | 135/42/68 | 待定 |
| 3 | 双指针/滑动窗口 | 待定 | 待定 |

## Phase 1 题单索引

| Day | 主题 | 题号 | 标题 | 难度 | 状态 |
|-----|------|------|------|------|------|
| 1 | 原地删除/双指针 | 27 | 移除元素 | E | ☐ |
| 1 | 原地删除/双指针 | 26 | 删除有序数组中的重复项 | E | ☐ |
| 1 | 原地删除/双指针 | 80 | 删除重复项 II | M | ☐ |
| 2 | 双指针进阶 | 88 | 合并有序数组 | E | ☐ |
| 2 | 双指针进阶 | 151 | 反转字符串中的单词 | M | ☐ |
| 2 | 双指针进阶 | 189 | 轮转数组 | M | ☐ |
| 3 | 贪心 I | 121 | 买卖股票 I | E | ☐ |
| 3 | 贪心 I | 122 | 买卖股票 II | M | ☐ |
| 3 | 贪心 I | 134 | 加油站 | M | ☐ |
| 4 | 贪心 II | 55 | 跳跃游戏 | M | ☐ |
| 4 | 贪心 II | 45 | 跳跃游戏 II | M | ☐ |
| 4 | 贪心 II | 169 | 多数元素 | E | ☐ |
| 5 | 前缀后缀+计数 | 238 | 除自身以外的乘积 | M | ☐ |
| 5 | 前缀后缀+计数 | 274 | H 指数 | M | ☐ |
| 5 | 前缀后缀+计数 | 6 | Z 字形变换 | M | ☐ |
| 6 | 字符串 I | 13 | 罗马数字转整数 | E | ☐ |
| 6 | 字符串 I | 14 | 最长公共前缀 | E | ☐ |
| 6 | 字符串 I | 58 | 最后一个单词的长度 | E | ☐ |
| 7 | 字符串 II+DS | 28 | 第一个匹配项下标 | E | ☐ |
| 7 | 字符串 II+DS | 380 | O(1) 插入删除随机 | M | ☐ |
| 7 | 复习 | - | 模板串联 + ACM I/O 整理 | - | ☐ |

## 模板口诀速查表

（Day 7 完成后填充）

## 仓库结构

- `src/phase1_arrays_strings/dayN_*/Solution_XXX.java` — 双模式 Java 解法
- `NOTES.md` — 汇总笔记（背诵卡 + 理解层 + ACM I/O）
- `docs/superpowers/` — 设计文档与实现计划
```

- [ ] **Step 5: 创建 `NOTES.md` 骨架**

```markdown
# Phase 1 笔记汇总

## Java 速查

- 方法签名：LeetCode 模板已给 `public XXX methodName(params)`；ACM 需自行写 `main`
- `import`：LeetCode 平台自动补全；本地 IDE / ACM 需手动 `import java.util.*`
- `int[]` vs `Integer[]`：算法题几乎只用 `int[]`
- 边界判空肌肉记忆：`if (nums == null || nums.length == 0) return ...;`
- `arr.length` 是字段（无括号）；`String.length()` 是方法（有括号）

## ACM 输入输出专题

### 输入类

- `Scanner sc = new Scanner(System.in);` — 最常用，慢但够用
  - `sc.nextInt()` / `sc.nextLong()` / `sc.nextDouble()` / `sc.next()` / `sc.nextLine()`
  - **陷阱**：`nextInt()` 后接 `nextLine()` 会读到空行——需多一次 `nextLine()` 消耗换行符
- `BufferedReader br = new BufferedReader(new InputStreamReader(System.in));` — 大数据量首选
  - 模板：
    ```java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StreamTokenizer st = new StreamTokenizer(br);
    st.nextToken(); int n = (int) st.nval;
    ```
- 读到 EOF：`while (sc.hasNextInt())` 或 `while ((line = br.readLine()) != null)`

### 输出类

- `System.out.print()` / `println()` / `printf("%d %.2f\n", a, b)`
- 大量输出用 `StringBuilder` 拼接后一次 `println`，避免 TLE
- `PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));` — 竞赛级，需 `pw.flush()`

### 4 种输入套路模板卡

（每天练习后回填此处）

#### 套路 1：单组 n + 数组（Day 1/2/5）
```java
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int[] a = new int[n];
for (int i = 0; i < n; i++) a[i] = sc.nextInt();
```

#### 套路 2：多组直到 EOF（Day 3/4）
```java
Scanner sc = new Scanner(System.in);
while (sc.hasNextInt()) {
    int n = sc.nextInt();
    // ...
}
```

#### 套路 3：带字符串 nextLine 分词（Day 6/7）
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String line;
while ((line = br.readLine()) != null) {
    String[] parts = line.split(" ");
    // ...
}
```

#### 套路 4：二维矩阵
```java
Scanner sc = new Scanner(System.in);
int m = sc.nextInt(), n = sc.nextInt();
int[][] a = new int[m][n];
for (int i = 0; i < m; i++)
    for (int j = 0; j < n; j++)
        a[i][j] = sc.nextInt();
```

---

## Day 1 · 原地删除 / 双指针

（Task 1 完成后追加）

<!-- 后续 Day 2–7 同样在此追加 -->
```

- [ ] **Step 6: 首次提交并推送**

Run:
```bash
cd "c:\Users\26947\Desktop\summer\Algorithm"
git add .
git commit -m "Init: Phase 1 仓库骨架与设计文档"
git remote add origin https://github.com/zrk494/AlgorithmLeecode.git
git push -u origin main
```
Expected: 推送成功；GitHub 仓库可见 `.gitignore`、`README.md`、`NOTES.md`、`docs/`、`src/` 骨架。

---

## Task 1: Day 1 — 原地删除 / 双指针

**Files:**
- Create: `src/phase1_arrays_strings/day1_inplace_remove/Solution_27.java`
- Create: `src/phase1_arrays_strings/day1_inplace_remove/Solution_26.java`
- Create: `src/phase1_arrays_strings/day1_inplace_remove/Solution_80.java`
- Modify: `NOTES.md`（追加 Day 1 三题笔记 + 今日口诀合集）
- Modify: `README.md`（勾选 Day 1 三题状态）

- [ ] **Step 1: 创建 `Solution_27.java`**

```java
import java.util.*;

// 题号: 27  标题: 移除元素  难度: E  模式: 原地删除/双指针
// 口诀: 快慢双指针，慢停快跑；遇到目标跳过，否则慢位接管。
// 复杂度: O(n) / O(1)
public class Solution_27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

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

- [ ] **Step 2: 编译验证 `Solution_27.java`**

Run:
```bash
cd "c:\Users\26947\Desktop\summer\Algorithm\src\phase1_arrays_strings\day1_inplace_remove"
javac Solution_27.java
```
Expected: 无报错，生成 `Solution_27.class`（被 `.gitignore` 排除）。

- [ ] **Step 3: 本地 ACM 测试 `Solution_27`**

输入文件 `test27.txt`：
```
4 2
3 2 2 3
```
Run: `java Solution_27 < test27.txt`
Expected:
```
2
3 3
```
测试后删除 `test27.txt`。

- [ ] **Step 4: LeetCode 在线提交 27 题**

将 `removeElement` 方法体复制到 https://leetcode.cn/problems/remove-element/ 提交。
Expected: Accept。

- [ ] **Step 5: 创建 `Solution_26.java`**

```java
import java.util.*;

// 题号: 26  标题: 删除有序数组中的重复项  难度: E  模式: 原地删除/双指针
// 口诀: 快慢双指针，慢停快跑；遇到重复跳过，否则慢位接管。
// 复杂度: O(n) / O(1)
public class Solution_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int k = new Solution_26().removeDuplicates(nums);
        System.out.println(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(nums[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
```

- [ ] **Step 6: 编译验证 `Solution_26.java`**

Run:
```bash
javac Solution_26.java
```
Expected: 无报错。

- [ ] **Step 7: LeetCode 在线提交 26 题**

提交 `removeDuplicates` 到 https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
Expected: Accept。

- [ ] **Step 8: 创建 `Solution_80.java`**

```java
import java.util.*;

// 题号: 80  标题: 删除有序数组中的重复项 II  难度: M  模式: 原地删除/双指针
// 口诀: 快慢双指针，慢位写新值；允许两次重复，慢针小于 2 直通。
// 复杂度: O(n) / O(1)
public class Solution_80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (slow < 2 || nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int k = new Solution_80().removeDuplicates(nums);
        System.out.println(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(nums[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
```

- [ ] **Step 9: 编译验证 `Solution_80.java`**

Run: `javac Solution_80.java`
Expected: 无报错。

- [ ] **Step 10: LeetCode 在线提交 80 题**

提交到 https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
Expected: Accept。

- [ ] **Step 11: 追加 Day 1 三题笔记到 `NOTES.md`**

在 `NOTES.md` 的 `## Day 1` 节下追加（替换 `（Task 1 完成后追加）` 占位）：

```markdown
### 27 移除元素 [E]  模式: 原地删除/双指针

**一句话题意**：原地删除数组中值为 val 的元素，返回新长度。

**记忆口诀**：
> 快慢双指针，慢停快跑；遇到目标跳过，否则慢位接管。

**可背模板**：
  init slow = 0
  for fast in [0, n):
      if nums[fast] != val:
          nums[slow++] = nums[fast]
  return slow

**Java 完整解法**：[Solution_27.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day1_inplace_remove/Solution_27.java)

**复杂度**：O(n) / O(1)，快针遍历一次，原地写入。

**关键易错点**：
1. slow 是「下一个写入位置」，返回值即 slow（不是 slow+1）
2. 空数组直接返回 0（fast 循环不执行）
3. `nums[slow++] = nums[fast]` 是先赋值再自增

**Java 基础点**：`arr.length` 字段、`slow++` 赋值顺序、`int` 默认 0
**ACM 输入套路**：套路 1 单组 n+val+数组

**关联题**：26（变体：比较对象从 val 变为前一个元素）、80（变体：允许重复 2 次）

---

### 26 删除有序数组中的重复项 [E]  模式: 原地删除/双指针

**一句话题意**：原地删除有序数组的重复项，返回新长度。

**记忆口诀**：
> 快慢双指针，慢从 1 起；与前值不同则写，相同则快针继续。

**可背模板**：
  if n == 0: return 0
  init slow = 1
  for fast in [1, n):
      if nums[fast] != nums[fast-1]:
          nums[slow++] = nums[fast]
  return slow

**Java 完整解法**：[Solution_26.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day1_inplace_remove/Solution_26.java)

**复杂度**：O(n) / O(1)

**关键易错点**：
1. 空数组必须特判（否则 slow=1 越界）
2. slow 从 1 开始（第一个元素必保留）
3. 比较的是 `nums[fast]` 与 `nums[fast-1]`，不是 `nums[slow-1]`

**Java 基础点**：边界判空、`fast-1` 索引比较
**ACM 输入套路**：套路 1 单组 n+数组

**关联题**：27（基础模板）、80（扩展到允许重复 k 次）

---

### 80 删除重复项 II [M]  模式: 原地删除/双指针

**一句话题意**：原地删除有序数组重复项，使每元素最多保留 2 次，返回新长度。

**记忆口诀**：
> 快慢双指针，慢位写新值；允许两次重复，慢针小于 2 直通。

**可背模板**：
  init slow = 0
  for fast in [0, n):
      if slow < 2 or nums[fast] != nums[slow-2]:
          nums[slow++] = nums[fast]
  return slow

**Java 完整解法**：[Solution_80.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day1_inplace_remove/Solution_80.java)

**复杂度**：O(n) / O(1)

**关键易错点**：
1. `slow < 2` 直通——前两个元素必保留，无需比较
2. 比较的是 `nums[fast]` 与 `nums[slow-2]`（不是 fast-2）
3. 推广：允许重复 k 次则改为 `slow < k` 与 `nums[slow-k]`

**Java 基础点**：短路或 `||` 的求值顺序（slow<2 先判断避免 slow-2 越界）
**ACM 输入套路**：套路 1 单组 n+数组

**关联题**：26（k=1 的特例）、27（删除指定值而非重复）

---

### 今日口诀合集（Day 1）

1. 快慢双指针，慢停快跑；遇到目标跳过，否则慢位接管。（27）
2. 快慢双指针，慢从 1 起；与前值不同则写，相同则快针继续。（26）
3. 快慢双指针，慢位写新值；允许两次重复，慢针小于 2 直通。（80）
```

- [ ] **Step 12: 更新 `README.md` Day 1 三题状态为 ☑**

将 Day 1 三行的 `☐` 改为 `☑`。

- [ ] **Step 13: 提交并推送 Day 1**

Run:
```bash
cd "c:\Users\26947\Desktop\summer\Algorithm"
git add .
git commit -m "Day1: 原地删除/双指针 - 27/26/80"
git push origin main
```
Expected: 推送成功。

---

## Task 2: Day 2 — 双指针进阶：合并 / 反转 / 轮转

**Files:**
- Create: `src/phase1_arrays_strings/day2_pointer_merge_reverse/Solution_88.java`
- Create: `src/phase1_arrays_strings/day2_pointer_merge_reverse/Solution_151.java`
- Create: `src/phase1_arrays_strings/day2_pointer_merge_reverse/Solution_189.java`
- Modify: `NOTES.md`（追加 Day 2 三题笔记 + 今日口诀合集）
- Modify: `README.md`（勾选 Day 2 三题状态）

- [ ] **Step 1: 创建 `Solution_88.java`**

```java
import java.util.*;

// 题号: 88  标题: 合并两个有序数组  难度: E  模式: 双指针进阶
// 口诀: 三针从尾填，大到小入位；nums2 空即止，否则剩直接留。
// 复杂度: O(m+n) / O(1)
public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[] nums1 = new int[m + n];
        for (int i = 0; i < m; i++) nums1[i] = sc.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) nums2[i] = sc.nextInt();
        new Solution_88().merge(nums1, m, nums2, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n; i++) sb.append(nums1[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
```

- [ ] **Step 2: 编译验证 + LeetCode AC（88）**

Run: `javac Solution_88.java` → 无报错
提交 `merge` 到 https://leetcode.cn/problems/merge-sorted-array/ → Accept

- [ ] **Step 3: 创建 `Solution_151.java`**

```java
import java.util.*;

// 题号: 151  标题: 反转字符串中的单词  难度: M  模式: 双指针进阶
// 口诀: 整体反转一次，逐词反转一次；多余空格 trim，单词间单空格。
// 复杂度: O(n) / O(n)（char 数组）或 O(1)（若语言可变字符串）
public class Solution_151 {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        // 1. 整体反转
        reverse(arr, 0, arr.length - 1);
        // 2. 逐词反转 + 压缩空格
        int n = arr.length;
        int idx = 0;
        int i = 0;
        while (i < n) {
            while (i < n && arr[i] == ' ') i++;
            if (i >= n) break;
            int start = idx;
            while (i < n && arr[i] != ' ') {
                arr[idx++] = arr[i++];
            }
            reverse(arr, start, idx - 1);
            if (idx < n) arr[idx++] = ' ';
        }
        return new String(arr, 0, idx == 0 ? 0 : (idx - (idx > 0 && arr[idx-1] == ' ' ? 1 : 0)));
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char t = arr[l]; arr[l] = arr[r]; arr[r] = t;
            l++; r--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // 消耗可能的换行
        String s = sc.hasNextLine() ? sc.nextLine() : "";
        System.out.println(new Solution_151().reverseWords(s));
    }
}
```

注：151 的纯手写 O(1) 空间实现较复杂，若 AC 困难可改用 `s.trim().split("\\s+")` + 反转数组的简化版本（牺牲空间换可读性，符合"先背诵"原则）：

```java
public String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
        sb.append(words[i]);
        if (i > 0) sb.append(' ');
    }
    return sb.toString();
}
```

- [ ] **Step 4: 编译验证 + LeetCode AC（151）**

Run: `javac Solution_151.java` → 无报错
提交到 https://leetcode.cn/problems/reverse-words-in-a-string/ → Accept

- [ ] **Step 5: 创建 `Solution_189.java`**

```java
import java.util.*;

// 题号: 189  标题: 轮转数组  难度: M  模式: 双指针进阶
// 口诀: k 先取模，三次反转搞定：全反转、前 k 反转、后 n-k 反转。
// 复杂度: O(n) / O(1)
public class Solution_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l]; nums[l] = nums[r]; nums[r] = t;
            l++; r--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        new Solution_189().rotate(nums, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(nums[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
```

- [ ] **Step 6: 编译验证 + LeetCode AC（189）**

Run: `javac Solution_189.java` → 无报错
提交到 https://leetcode.cn/problems/rotate-array/ → Accept

- [ ] **Step 7: 追加 Day 2 三题笔记到 `NOTES.md`**

按 Day 1 同样的 9 块结构，追加 88/151/189 三题。每题包含：
- 一句话题意
- 记忆口诀（见 .java 文件头）
- 可背模板（伪代码）
- Java 完整解法链接
- 复杂度
- 关键易错点（88：i/j/k 三针从尾；151：trim+split 简化版的边界；189：k%n 必做、k==0 早返回）
- Java 基础点（88：三元运算符；151：`toCharArray`/`new String(char[],off,len)`/`split("\\s+")`；189：`%` 取模）
- ACM 输入套路（88：套路 1 单组 m+n+两数组；151：套路 3 带字符串；189：套路 1 单组 n+k+数组）
- 关联题

最后追加：
```markdown
### 今日口诀合集（Day 2）
1. 三针从尾填，大到小入位；nums2 空即止，否则剩直接留。（88）
2. 整体反转一次，逐词反转一次；多余空格 trim，单词间单空格。（151）
3. k 先取模，三次反转搞定：全反转、前 k 反转、后 n-k 反转。（189）
```

- [ ] **Step 8: 更新 `README.md` Day 2 三题状态为 ☑**

- [ ] **Step 9: 提交并推送 Day 2**

Run:
```bash
git add .
git commit -m "Day2: 双指针进阶 - 88/151/189"
git push origin main
```

---

## Task 3: Day 3 — 贪心 I：股票 + 加油

**Files:**
- Create: `src/phase1_arrays_strings/day3_greedy_stock_gas/Solution_121.java`
- Create: `src/phase1_arrays_strings/day3_greedy_stock_gas/Solution_122.java`
- Create: `src/phase1_arrays_strings/day3_greedy_stock_gas/Solution_134.java`
- Modify: `NOTES.md`、`README.md`

- [ ] **Step 1: 创建 `Solution_121.java`**

```java
import java.util.*;

// 题号: 121  标题: 买卖股票的最佳时机  难度: E  模式: 贪心 I
// 口诀: 维护历史最小价，每日算利润差；最大利润即答案，一次遍历搞定。
// 复杂度: O(n) / O(1)
public class Solution_121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p : prices) {
            if (p < minPrice) minPrice = p;
            else maxProfit = Math.max(maxProfit, p - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) prices[i] = sc.nextInt();
            System.out.println(new Solution_121().maxProfit(prices));
        }
    }
}
```

- [ ] **Step 2: 编译验证 + LeetCode AC（121）**

Run: `javac Solution_121.java` → 无报错
提交到 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/ → Accept

- [ ] **Step 3: 创建 `Solution_122.java`**

```java
import java.util.*;

// 题号: 122  标题: 买卖股票的最佳时机 II  难度: M  模式: 贪心 I
// 口诀: 可多次买卖，累加正差价；今天比昨高，就把差吃下。
// 复杂度: O(n) / O(1)
public class Solution_122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) prices[i] = sc.nextInt();
            System.out.println(new Solution_122().maxProfit(prices));
        }
    }
}
```

- [ ] **Step 4: 编译验证 + LeetCode AC（122）**

Run: `javac Solution_122.java` → 无报错
提交到 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/ → Accept

- [ ] **Step 5: 创建 `Solution_134.java` ⭐重点题**

```java
import java.util.*;

// 题号: 134  标题: 加油站  难度: M  模式: 贪心 I
// 口诀: 总剩余判否，单站累加判起点；累加为负即重置，起点设为下一站。
// 复杂度: O(n) / O(1)
public class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] gas = new int[n], cost = new int[n];
            for (int i = 0; i < n; i++) gas[i] = sc.nextInt();
            for (int i = 0; i < n; i++) cost[i] = sc.nextInt();
            System.out.println(new Solution_134().canCompleteCircuit(gas, cost));
        }
    }
}
```

- [ ] **Step 6: 编译验证 + LeetCode AC（134）**

Run: `javac Solution_134.java` → 无报错
提交到 https://leetcode.cn/problems/gas-station/ → Accept

- [ ] **Step 7: 追加 Day 3 三题笔记到 `NOTES.md`**

9 块结构，关键内容：
- 121 易错：`Integer.MAX_VALUE` 初始化、空数组判空
- 122 易错：累加所有正差价（等价于贪心所有上升段）
- 134 易错 ⭐：`total >= 0` 才有解、`tank < 0` 重置起点为 `i+1`、`tank` 不必担心回不到起点（total 判否已保证）
- Java 基础点：`Integer.MAX_VALUE`、`Math.max`、增强 for、`long` 防溢出（134 用 int 通常够，大数据时升 long）
- ACM 套路：套路 2 多组直到 EOF
- 关联题：121/122 同源（单次 vs 多次买卖）、134 是贪心判否的典范

今日口诀合集：
```markdown
1. 维护历史最小价，每日算利润差；最大利润即答案，一次遍历搞定。（121）
2. 可多次买卖，累加正差价；今天比昨高，就把差吃下。（122）
3. 总剩余判否，单站累加判起点；累加为负即重置，起点设为下一站。（134）
```

- [ ] **Step 8: 更新 `README.md` Day 3 三题状态为 ☑**

- [ ] **Step 9: 提交并推送 Day 3**

Run:
```bash
git add .
git commit -m "Day3: 贪心I - 121/122/134"
git push origin main
```

---

## Task 4: Day 4 — 贪心 II：跳跃 + 摩尔投票

**Files:**
- Create: `src/phase1_arrays_strings/day4_greedy_jump_majority/Solution_55.java`
- Create: `src/phase1_arrays_strings/day4_greedy_jump_majority/Solution_45.java`
- Create: `src/phase1_arrays_strings/day4_greedy_jump_majority/Solution_169.java`
- Modify: `NOTES.md`、`README.md`

- [ ] **Step 1: 创建 `Solution_55.java`**

```java
import java.util.*;

// 题号: 55  标题: 跳跃游戏  难度: M  模式: 贪心 II
// 口诀: 维护最远可达，每步更新 maxReach；maxReach >= n-1 即可到。
// 复杂度: O(n) / O(1)
public class Solution_55 {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
            System.out.println(new Solution_55().canJump(nums));
        }
    }
}
```

- [ ] **Step 2: 编译验证 + LeetCode AC（55）**

提交到 https://leetcode.cn/problems/jump-game/ → Accept

- [ ] **Step 3: 创建 `Solution_45.java` ⭐重点题**

```java
import java.util.*;

// 题号: 45  标题: 跳跃游戏 II  难度: M  模式: 贪心 II
// 口诀: 维护当前边界，到了就跳一步；最远可达更新，到边界换新界。
// 复杂度: O(n) / O(1)
public class Solution_45 {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int steps = 0;
        int curEnd = 0;
        int maxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == curEnd) {
                steps++;
                curEnd = maxReach;
                if (curEnd >= nums.length - 1) break;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
            System.out.println(new Solution_45().jump(nums));
        }
    }
}
```

- [ ] **Step 4: 编译验证 + LeetCode AC（45）**

提交到 https://leetcode.cn/problems/jump-game-ii/ → Accept

- [ ] **Step 5: 创建 `Solution_169.java`**

```java
import java.util.*;

// 题号: 169  标题: 多数元素  难度: E  模式: 贪心 II（摩尔投票）
// 口诀: 计数归零换人，同则加一异减一；多数必胜出，最后候选人即答案。
// 复杂度: O(n) / O(1)
public class Solution_169 {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        for (int x : nums) {
            if (cnt == 0) candidate = x;
            cnt += (x == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
            System.out.println(new Solution_169().majorityElement(nums));
        }
    }
}
```

- [ ] **Step 6: 编译验证 + LeetCode AC（169）**

提交到 https://leetcode.cn/problems/majority-element/ → Accept

- [ ] **Step 7: 追加 Day 4 三题笔记到 `NOTES.md`**

关键内容：
- 55 易错：`i > maxReach` 才返回 false（不是 i+nums[i]==0）
- 45 易错 ⭐：循环到 `n-2`（最后一步不必跳）、`i == curEnd` 才步数++、`curEnd >= n-1` 早退出
- 169 易错：`cnt==0` 换人、三元运算符紧凑写法
- Java 基础点：`break`/`continue`、三元运算符、增强 for
- ACM 套路：套路 2 多组直到 EOF
- 关联题：55/45 同源（可达性 vs 最少步数）、169 是投票算法典范

今日口诀合集：
```markdown
1. 维护最远可达，每步更新 maxReach；maxReach >= n-1 即可到。（55）
2. 维护当前边界，到了就跳一步；最远可达更新，到边界换新界。（45）
3. 计数归零换人，同则加一异减一；多数必胜出，最后候选人即答案。（169）
```

- [ ] **Step 8: 更新 `README.md` Day 4 三题状态为 ☑**

- [ ] **Step 9: 提交并推送 Day 4**

Run:
```bash
git add .
git commit -m "Day4: 贪心II - 55/45/169"
git push origin main
```

---

## Task 5: Day 5 — 前缀后缀 + 计数统计

**Files:**
- Create: `src/phase1_arrays_strings/day5_prefix_count/Solution_238.java`
- Create: `src/phase1_arrays_strings/day5_prefix_count/Solution_274.java`
- Create: `src/phase1_arrays_strings/day5_prefix_count/Solution_6.java`
- Modify: `NOTES.md`、`README.md`

- [ ] **Step 1: 创建 `Solution_238.java`**

```java
import java.util.*;

// 题号: 238  标题: 除自身以外的数组的乘积  难度: M  模式: 前缀后缀
// 口诀: 左积正扫一遍，右积反扫一遍；左乘右即答案，无需除法。
// 复杂度: O(n) / O(1)（输出数组不算空间）
public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int[] ans = new Solution_238().productExceptSelf(nums);
        StringBuilder sb = new StringBuilder();
        for (int x : ans) sb.append(x).append(' ');
        System.out.println(sb.toString().trim());
    }
}
```

- [ ] **Step 2: 编译验证 + LeetCode AC（238）**

提交到 https://leetcode.cn/problems/product-of-array-except-self/ → Accept

- [ ] **Step 3: 创建 `Solution_274.java` ⭐重点题**

```java
import java.util.*;

// 题号: 274  标题: H 指数  难度: M  模式: 计数统计
// 口诀: 引用数封顶 n，计数映射到 n+1；从高到低累加，累加值 >= 当前引用即 H。
// 复杂度: O(n) / O(n)
public class Solution_274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int c : citations) {
            cnt[Math.min(c, n)]++;
        }
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += cnt[i];
            if (total >= i) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] citations = new int[n];
        for (int i = 0; i < n; i++) citations[i] = sc.nextInt();
        System.out.println(new Solution_274().hIndex(citations));
    }
}
```

- [ ] **Step 4: 编译验证 + LeetCode AC（274）**

提交到 https://leetcode.cn/problems/h-index/ → Accept

- [ ] **Step 5: 创建 `Solution_6.java` ⭐重点题**

```java
import java.util.*;

// 题号: 6  标题: Z 字形变换  难度: M  模式: 周期索引
// 口诀: 周期 T = 2*r-1；按行收集，下标按周期跳，中间行补一个反射位。
// 复杂度: O(n) / O(n)
public class Solution_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = s.length();
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
        int i = 0;
        int dir = 1;
        for (char c : s.toCharArray()) {
            rows[i].append(c);
            if (i == 0) dir = 1;
            else if (i == numRows - 1) dir = -1;
            i += dir;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) sb.append(row);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int numRows = sc.nextInt();
        System.out.println(new Solution_6().convert(s, numRows));
    }
}
```

注：6 题用方向标志法（dir = ±1）比纯周期索引更易背诵，符合"先背诵"原则。

- [ ] **Step 6: 编译验证 + LeetCode AC（6）**

提交到 https://leetcode.cn/problems/zigzag-conversion/ → Accept

- [ ] **Step 7: 追加 Day 5 三题笔记到 `NOTES.md`**

关键内容：
- 238 易错：`ans[0]=1` 初始化、右积用单变量 `right` 节省空间
- 274 易错 ⭐：`Math.min(c, n)` 封顶、从高到低累加、`total >= i` 即返回
- 6 易错 ⭐：`numRows==1` 特判（否则死循环）、方向标志在边界翻转
- Java 基础点：`int[]` 初始化默认 0、`Math.min`、`StringBuilder[]` 数组、增强 for 遍历数组
- ACM 套路：238/274 套路 1、6 套路 3（字符串+整数）
- 关联题：238 是前缀积典范、274 是计数排序思想

今日口诀合集：
```markdown
1. 左积正扫一遍，右积反扫一遍；左乘右即答案，无需除法。（238）
2. 引用数封顶 n，计数映射到 n+1；从高到低累加，累加值 >= 当前引用即 H。（274）
3. 方向标志 ±1，到边即翻转；逐行 StringBuilder，最后拼成串。（6）
```

- [ ] **Step 8: 更新 `README.md` Day 5 三题状态为 ☑**

- [ ] **Step 9: 提交并推送 Day 5**

Run:
```bash
git add .
git commit -m "Day5: 前缀后缀+计数 - 238/274/6"
git push origin main
```

---

## Task 6: Day 6 — 字符串 I：罗马 / 前缀 / 末词

**Files:**
- Create: `src/phase1_arrays_strings/day6_string_roman_prefix/Solution_13.java`
- Create: `src/phase1_arrays_strings/day6_string_roman_prefix/Solution_14.java`
- Create: `src/phase1_arrays_strings/day6_string_roman_prefix/Solution_58.java`
- Modify: `NOTES.md`、`README.md`

- [ ] **Step 1: 创建 `Solution_13.java`**

```java
import java.util.*;

// 题号: 13  标题: 罗马数字转整数  难度: E  模式: 字符串 I
// 口诀: 前小后减，否则加；从左到右扫一遍，值入 Map 查。
// 复杂度: O(n) / O(1)
public class Solution_13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
            if (cur < next) result -= cur;
            else result += cur;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(new Solution_13().romanToInt(s));
        }
    }
}
```

- [ ] **Step 2: 编译验证 + LeetCode AC（13）**

提交到 https://leetcode.cn/problems/roman-to-integer/ → Accept

- [ ] **Step 3: 创建 `Solution_14.java`**

```java
import java.util.*;

// 题号: 14  标题: 最长公共前缀  难度: E  模式: 字符串 I
// 口诀: 纵向扫描字符列，逐位比较所有串；遇到不同或越界，截断返回。
// 复杂度: O(S) / O(1)（S 为所有字符串总长度）
public class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) strs[i] = sc.next();
            System.out.println(new Solution_14().longestCommonPrefix(strs));
        }
    }
}
```

- [ ] **Step 4: 编译验证 + LeetCode AC（14）**

提交到 https://leetcode.cn/problems/longest-common-prefix/ → Accept

- [ ] **Step 5: 创建 `Solution_58.java`**

```java
import java.util.*;

// 题号: 58  标题: 最后一个单词的长度  难度: E  模式: 字符串 I
// 口诀: 从尾向前跳空格，跳完空格数字符；遇到空格或到头即停。
// 复杂度: O(n) / O(1)
public class Solution_58 {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        int len = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(new Solution_58().lengthOfLastWord(s));
        }
    }
}
```

- [ ] **Step 6: 编译验证 + LeetCode AC（58）**

提交到 https://leetcode.cn/problems/length-of-last-word/ → Accept

- [ ] **Step 7: 追加 Day 6 三题笔记到 `NOTES.md`**

关键内容：
- 13 易错：`i+1` 越界判空、`cur < next` 减否则加
- 14 易错：空数组判空、`i >= strs[j].length()` 越界检查、`substring(0, i)` 左闭右开
- 58 易错：先跳尾部空格、再数非空格、从尾向前的两段式
- Java 基础点：`Map.get`/`charAt`/`substring`/`length()` 方法（vs `arr.length` 字段）
- ACM 套路：13 套路 2 字符串、14 套路 1 n+字符串数组、58 套路 3 整行
- 关联题：14 是纵向扫描典范、58 是从尾向前思想

今日口诀合集：
```markdown
1. 前小后减，否则加；从左到右扫一遍，值入 Map 查。（13）
2. 纵向扫描字符列，逐位比较所有串；遇到不同或越界，截断返回。（14）
3. 从尾向前跳空格，跳完空格数字符；遇到空格或到头即停。（58）
```

- [ ] **Step 8: 更新 `README.md` Day 6 三题状态为 ☑**

- [ ] **Step 9: 提交并推送 Day 6**

Run:
```bash
git add .
git commit -m "Day6: 字符串I - 13/14/58"
git push origin main
```

---

## Task 7: Day 7 — 字符串 II + 数据结构设计 + 复习

**Files:**
- Create: `src/phase1_arrays_strings/day7_string_match_ds_review/Solution_28.java`
- Create: `src/phase1_arrays_strings/day7_string_match_ds_review/Solution_380.java`
- Modify: `NOTES.md`（追加 28/380 笔记 + Day7 总串联表 + ACM I/O 模板卡回填）
- Modify: `README.md`（勾选 Day 7 状态 + 填充模板口诀速查表）

- [ ] **Step 1: 创建 `Solution_28.java`**

```java
import java.util.*;

// 题号: 28  标题: 找出字符串中第一个匹配项的下标  难度: E  模式: 字符串匹配
// 口诀: 暴力双循环，外层 haystack，内层 needle；首字匹配才深入，全部对上即返回。
// 复杂度: O(n*m) / O(1)（KMP 可优化到 O(n+m)，本题暴力即可 AC）
public class Solution_28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String haystack = sc.next();
            String needle = sc.next();
            System.out.println(new Solution_28().strStr(haystack, needle));
        }
    }
}
```

- [ ] **Step 2: 编译验证 + LeetCode AC（28）**

提交到 https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/ → Accept

- [ ] **Step 3: 创建 `Solution_380.java`**

```java
import java.util.*;

// 题号: 380  标题: O(1) 时间插入、删除和获取随机元素  难度: M  模式: 数据结构设计
// 口诀: List 存值 Map 存位，插入尾追加；删除末位替换法，先换后删 O(1)。
// 复杂度: insert/remove/getRandom 均 O(1)
public class Solution_380 {
    private List<Integer> list;
    private Map<Integer, Integer> idx;

    public Solution_380() {
        list = new ArrayList<>();
        idx = new HashMap<>();
    }

    public boolean insert(int val) {
        if (idx.containsKey(val)) return false;
        idx.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!idx.containsKey(val)) return false;
        int i = idx.get(val);
        int last = list.get(list.size() - 1);
        list.set(i, last);
        idx.put(last, i);
        list.remove(list.size() - 1);
        idx.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }

    public static void main(String[] args) {
        // ACM 测试略，本题以 LeetCode 调用序列为主
        Solution_380 obj = new Solution_380();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}
```

- [ ] **Step 4: 编译验证 + LeetCode AC（380）**

提交到 https://leetcode.cn/problems/insert-delete-getrandom-o1/ → Accept

- [ ] **Step 5: 追加 Day 7 两题笔记到 `NOTES.md`**

关键内容：
- 28 易错：`needle.isEmpty()` 返回 0、外层循环上限 `haystack.length() - needle.length()`、内层 `charAt(i+j)` 比较
- 380 易错：删除时「先换后删」顺序、`last` 替换到 `i` 后更新 `idx.put(last, i)`、最后 `list.remove(size-1)` + `idx.remove(val)`
- Java 基础点：`List`/`Map`/`Random`、`list.set`/`list.remove`、`containsKey`
- ACM 套路：28 套路 2 双字符串、380 以 LeetCode 调用序列为主（ACM 化需自行解析操作序列）
- 关联题：28 是字符串匹配基础（KMP 进阶在 Phase 3）、380 是 HashMap+List 组合典范

今日口诀合集：
```markdown
1. 暴力双循环，外层 haystack，内层 needle；首字匹配才深入，全部对上即返回。（28）
2. List 存值 Map 存位，插入尾追加；删除末位替换法，先换后删 O(1)。（380）
```

- [ ] **Step 6: 在 `NOTES.md` 末尾追加「Day 7 总串联表」**

```markdown
---

## Day 7 总串联表（Phase 1 背诵卡）

| 模式 | 口诀 | 代表题 |
|------|------|--------|
| 快慢双指针 | 慢停快跑，命中跳过否则接管 | 27/26/80 |
| 三针从尾填 | 大到小入位，剩直接留 | 88 |
| 三次反转 | 全反+前 k 反+后 n-k 反 | 189 |
| 整体+逐词反转 | trim 后反转单词序 | 151 |
| 股票历史最小 | 维护 minPrice，算利润差 | 121 |
| 累加正差价 | 今天比昨高就吃差 | 122 |
| 贪心判否 | 总剩余判否，单站累加判起点 | 134 |
| 最远可达 | 维护 maxReach，到边即停 | 55 |
| 边界步数 | 到 curEnd 步数++，换新界 | 45 |
| 摩尔投票 | 计数归零换人，同加异减 | 169 |
| 左右前缀积 | 左正扫右反扫，相乘即答案 | 238 |
| 计数封顶 | min(c,n) 入桶，高到低累加 | 274 |
| 方向标志 | ±1 翻转，逐行拼接 | 6 |
| 罗马前小后减 | cur<next 减否则加 | 13 |
| 纵向扫描 | 逐位比较所有串，越界即截 | 14 |
| 从尾向前 | 跳空格数非空格 | 58 |
| 暴力匹配 | 双循环，charAt 比较 | 28 |
| List+Map | 末位替换法，先换后删 | 380 |

---

## ACM I/O 模板卡（回填）

（已在「ACM 输入输出专题」节完成 4 种套路模板，此处为索引）

- 套路 1（单组 n+数组）：Day 1/2/5 用
- 套路 2（多组直到 EOF）：Day 3/4 用
- 套路 3（带字符串 nextLine）：Day 6/7 用
- 套路 4（二维矩阵）：Phase 3 备用
```

- [ ] **Step 7: 在 `README.md` 的「模板口诀速查表」节填充内容**

将 Day 7 总串联表的内容复制到 README.md 对应节。

- [ ] **Step 8: 更新 `README.md` Phase 进度表与 Day 7 状态**

- Phase 1 状态改为「已完成」
- Day 7 三行 `☐` 改为 `☑`

- [ ] **Step 9: 提交并推送 Day 7**

Run:
```bash
git add .
git commit -m "Day7: 字符串II+DS+复习 - 28/380/串联"
git push origin main
```

- [ ] **Step 10: Phase 1 完成验收**

对照 spec 第 5.1 节硬性指标逐项检查：
1. ☐ 21 道 .java 齐备，含 LeetCode 方法 + main，全部 AC
2. ☐ NOTES.md 含 21 题笔记 + 7 个日小结 + Day7 串联表
3. ☐ README.md 含题单索引 + 口诀速查表
4. ☐ 7 天日小结按 Day 分节
5. ☐ ACM I/O 专题含 4 种套路模板卡
6. ☐ 全部推送至 GitHub main 分支

全部勾选即 Phase 1 完成。

---

## 自检结果

**Spec 覆盖**：
- 第 1 节题单 → Task 1–7 每题对应 ✓
- 第 2 节笔记模板 → 每个 Task 的 NOTES 追加步骤遵循 9 块结构 ✓
- 第 3 节仓库结构 → Task 0 创建骨架，Task 1–7 创建 .java ✓
- 第 4 节 Java 基础 + ACM I/O → Task 0 NOTES 骨架含专题节，Task 1–7 每题标注 ✓
- 第 5 节验收与风险 → Task 7 Step 10 验收对照 ✓
- 第 6 节 GitHub 同步 → Task 0 首推 + 每个 Task 末尾 push ✓

**占位符扫描**：无 TBD/TODO，所有代码块完整。✓

**类型一致性**：类名 `Solution_XXX`、方法名与 LeetCode 题目一致（`removeElement`/`removeDuplicates`/`merge`/`reverseWords`/`rotate`/`maxProfit`/`canCompleteCircuit`/`canJump`/`jump`/`majorityElement`/`productExceptSelf`/`hIndex`/`convert`/`romanToInt`/`longestCommonPrefix`/`lengthOfLastWord`/`strStr`/`Solution_380` 构造+insert+remove+getRandom）。✓
