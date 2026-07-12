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
