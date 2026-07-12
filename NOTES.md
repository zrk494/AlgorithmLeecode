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

<!-- 后续 Day 2–7 同样在此追加 -->
