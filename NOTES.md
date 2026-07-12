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

## Day 2 · 双指针进阶：合并 / 反转 / 轮转

### 88 合并两个有序数组 [E]  模式: 双指针进阶

**一句话题意**：把 nums2 合并进 nums1 末尾，结果有序。

**记忆口诀**：
> 三针从尾填，大到小入位；nums2 空即止，否则剩直接留。

**可背模板**：
  i = m-1, j = n-1, k = m+n-1
  while i >= 0 and j >= 0:
      nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--]
  while j >= 0:
      nums1[k--] = nums2[j--]

**Java 完整解法**：[Solution_88.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day2_pointer_merge_reverse/Solution_88.java)

**复杂度**：O(m+n) / O(1)，从尾填避免覆盖。

**关键易错点**：
1. 三针 i/j/k 都从尾部开始（避免正向覆盖未处理元素）
2. nums1 剩余不必处理（已在位），只需处理 nums2 剩余
3. 三元运算符紧凑写法 `a >= b ? a-- : b--`

**Java 基础点**：三元运算符、`--` 自减在表达式中的时机
**ACM 输入套路**：套路 1 单组 m+n+两数组

**关联题**：与 27/26 同属双指针家族，区别在「合并」而非「删除」

---

### 151 反转字符串中的单词 [M]  模式: 双指针进阶

**一句话题意**：反转字符串中的单词顺序，单词间单空格。

**记忆口诀**：
> 整体反转一次，逐词反转一次；多余空格 trim，单词间单空格。

**可背模板**（简化版）：
  words = s.trim().split("\\s+")
  sb = StringBuilder
  for i in [len-1, 0]:
      sb.append(words[i])
      if i > 0: sb.append(' ')
  return sb.toString()

**Java 完整解法**：[Solution_151.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day2_pointer_merge_reverse/Solution_151.java)

**复杂度**：O(n) / O(n)

**关键易错点**：
1. `trim()` 去首尾空格，`split("\\s+")` 按多空格分词
2. 反向遍历 words 数组拼接
3. 最后一个单词后不加空格（`if (i > 0)` 判断）

**Java 基础点**：`String.trim()`、`split("\\s+")` 正则、`StringBuilder.append`
**ACM 输入套路**：套路 3 带字符串 nextLine

**关联题**：189 同用「反转」思想，151 反转单词序、189 反转数组段

---

### 189 轮转数组 [M]  模式: 双指针进阶

**一句话题意**：数组向右轮转 k 步，原地修改。

**记忆口诀**：
> k 先取模，三次反转搞定：全反转、前 k 反转、后 n-k 反转。

**可背模板**：
  k = k % n
  if k == 0: return
  reverse(nums, 0, n-1)
  reverse(nums, 0, k-1)
  reverse(nums, k, n-1)

**Java 完整解法**：[Solution_189.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day2_pointer_merge_reverse/Solution_189.java)

**复杂度**：O(n) / O(1)

**关键易错点**：
1. `k = k % n` 必做（k 可能大于 n）
2. `k == 0` 早返回（避免无意义反转）
3. 三段反转顺序：全反→前 k 反→后 n-k 反

**Java 基础点**：`%` 取模、私有 reverse 辅助方法、while 交换
**ACM 输入套路**：套路 1 单组 n+k+数组

**关联题**：151 同用反转思想

---

### 今日口诀合集（Day 2）

1. 三针从尾填，大到小入位；nums2 空即止，否则剩直接留。（88）
2. 整体反转一次，逐词反转一次；多余空格 trim，单词间单空格。（151）
3. k 先取模，三次反转搞定：全反转、前 k 反转、后 n-k 反转。（189）

## Day 3 · 贪心 I：股票 + 加油

### 121 买卖股票的最佳时机 [E]  模式: 贪心 I

**一句话题意**：单次买卖，求最大利润。

**记忆口诀**：
> 维护历史最小价，每日算利润差；最大利润即答案，一次遍历搞定。

**可背模板**：
  minPrice = MAX, maxProfit = 0
  for p in prices:
      if p < minPrice: minPrice = p
      else: maxProfit = max(maxProfit, p - minPrice)
  return maxProfit

**Java 完整解法**：[Solution_121.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day3_greedy_stock_gas/Solution_121.java)

**复杂度**：O(n) / O(1)

**关键易错点**：
1. `Integer.MAX_VALUE` 初始化 minPrice
2. 空数组判空返回 0
3. `if-else` 结构：更新最小价 OR 更新最大利润（同一天不能既买又卖，但若 p < minPrice 则无利润可算，逻辑自洽）

**Java 基础点**：`Integer.MAX_VALUE`、`Math.max`、增强 for
**ACM 输入套路**：套路 2 多组直到 EOF

**关联题**：122（多次买卖版）、123/188（限次数版，进阶）

---

### 122 买卖股票的最佳时机 II [M]  模式: 贪心 I

**一句话题意**：可多次买卖，求最大利润。

**记忆口诀**：
> 可多次买卖，累加正差价；今天比昨高，就把差吃下。

**可背模板**：
  profit = 0
  for i in [1, n):
      if prices[i] > prices[i-1]:
          profit += prices[i] - prices[i-1]
  return profit

**Java 完整解法**：[Solution_122.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day3_greedy_stock_gas/Solution_122.java)

**复杂度**：O(n) / O(1)

**关键易错点**：
1. 累加所有正差价（等价于贪心所有上升段）
2. 从 i=1 开始，比较 `prices[i]` 与 `prices[i-1]`
3. 不需要记录买卖点，直接累加差价

**Java 基础点**：`for (int i = 1; ...)` 起点为 1
**ACM 输入套路**：套路 2 多组直到 EOF

**关联题**：121（单次买卖版）

---

### 134 加油站 [M]  模式: 贪心 I ⭐重点题

**一句话题意**：环形路 n 个加油站，求能跑完一圈的起点。

**记忆口诀**：
> 总剩余判否，单站累加判起点；累加为负即重置，起点设为下一站。

**可背模板**：
  total = 0, tank = 0, start = 0
  for i in [0, n):
      diff = gas[i] - cost[i]
      total += diff
      tank += diff
      if tank < 0:
          start = i + 1
          tank = 0
  return total >= 0 ? start : -1

**Java 完整解法**：[Solution_134.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day3_greedy_stock_gas/Solution_134.java)

**复杂度**：O(n) / O(1)

**关键易错点**：
1. `total >= 0` 才有解（总油量 ≥ 总耗油）
2. `tank < 0` 时重置起点为 `i+1`，tank 清零
3. 不必担心回不到起点——total 判否已保证（若 total ≥ 0，从 start 出发必然能跑完）

**Java 基础点**：三元运算符返回、累加变量
**ACM 输入套路**：套路 2 多组直到 EOF（双数组 gas + cost）

**关联题**：贪心判否的典范，与 121/122 同属贪心家族但思想不同

---

### 今日口诀合集（Day 3）

1. 维护历史最小价，每日算利润差；最大利润即答案，一次遍历搞定。（121）
2. 可多次买卖，累加正差价；今天比昨高，就把差吃下。（122）
3. 总剩余判否，单站累加判起点；累加为负即重置，起点设为下一站。（134）

## Day 4 · 贪心 II：跳跃 + 摩尔投票

### 55 跳跃游戏 [M]  模式: 贪心 II

**一句话题意**：数组每元素代表最大跳数，判断能否到末尾。

**记忆口诀**：
> 维护最远可达，每步更新 maxReach；maxReach >= n-1 即可到。

**可背模板**：
  maxReach = 0
  for i in [0, n):
      if i > maxReach: return false
      maxReach = max(maxReach, i + nums[i])
      if maxReach >= n-1: return true
  return true

**Java 完整解法**：[Solution_55.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day4_greedy_jump_majority/Solution_55.java)

**复杂度**：O(n) / O(1)

**关键易错点**：
1. `i > maxReach` 才返回 false（当前位置不可达）
2. `maxReach >= n-1` 早返回 true（已能到末尾）
3. 不是 `nums[i] == 0` 判断（即使某点为 0，只要之前能跳过即可）

**Java 基础点**：`Math.max`、for 循环早返回
**ACM 输入套路**：套路 2 多组直到 EOF

**关联题**：45（求最少步数版）

---

### 45 跳跃游戏 II [M]  模式: 贪心 II ⭐重点题

**一句话题意**：每元素代表最大跳数，求到末尾的最少步数。

**记忆口诀**：
> 维护当前边界，到了就跳一步；最远可达更新，到边界换新界。

**可背模板**：
  if n <= 1: return 0
  steps = 0, curEnd = 0, maxReach = 0
  for i in [0, n-1):
      maxReach = max(maxReach, i + nums[i])
      if i == curEnd:
          steps++
          curEnd = maxReach
          if curEnd >= n-1: break
  return steps

**Java 完整解法**：[Solution_45.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day4_greedy_jump_majority/Solution_45.java)

**复杂度**：O(n) / O(1)

**关键易错点**：
1. 循环到 `n-2`（最后一步不必跳，到了 curEnd 自动 +1）
2. `i == curEnd` 才步数++（到达当前边界必须跳一步）
3. `curEnd >= n-1` 早退出（已能到末尾）
4. `n <= 1` 特判返回 0（已在起点）

**Java 基础点**：`break` 早退出、边界变量维护
**ACM 输入套路**：套路 2 多组直到 EOF

**关联题**：55（可达性判断版）

---

### 169 多数元素 [E]  模式: 贪心 II（摩尔投票）

**一句话题意**：找出现次数超过 n/2 的元素。

**记忆口诀**：
> 计数归零换人，同则加一异减一；多数必胜出，最后候选人即答案。

**可背模板**：
  candidate = 0, cnt = 0
  for x in nums:
      if cnt == 0: candidate = x
      cnt += (x == candidate) ? 1 : -1
  return candidate

**Java 完整解法**：[Solution_169.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day4_greedy_jump_majority/Solution_169.java)

**复杂度**：O(n) / O(1)

**关键易错点**：
1. `cnt == 0` 换人（当前候选被抵消完）
2. 三元运算符紧凑写法 `(x == candidate) ? 1 : -1`
3. 题目保证存在多数元素，无需二次验证；若不保证需再扫一遍统计 candidate 出现次数

**Java 基础点**：三元运算符、增强 for
**ACM 输入套路**：套路 2 多组直到 EOF

**关联题**：摩尔投票典范，229（求超过 n/3 的多数元素，进阶）

---

### 今日口诀合集（Day 4）

1. 维护最远可达，每步更新 maxReach；maxReach >= n-1 即可到。（55）
2. 维护当前边界，到了就跳一步；最远可达更新，到边界换新界。（45）
3. 计数归零换人，同则加一异减一；多数必胜出，最后候选人即答案。（169）

## Day 5 · 前缀后缀 + 计数统计

### 238 除自身以外的数组的乘积 [M]  模式: 前缀后缀

**一句话题意**：返回数组 ans，ans[i] = nums 中除 nums[i] 外其余元素之积，禁用除法。

**记忆口诀**：
> 左积正扫一遍，右积反扫一遍；左乘右即答案，无需除法。

**可背模板**：
  ans[0] = 1
  for i in [1, n): ans[i] = ans[i-1] * nums[i-1]   // 左积
  right = 1
  for i in [n-1, 0]:                                 // 反扫叠加右积
      ans[i] *= right
      right *= nums[i]
  return ans

**Java 完整解法**：[Solution_238.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day5_prefix_count/Solution_238.java)

**复杂度**：O(n) / O(1)（输出数组不算空间）

**关键易错点**：
1. `ans[0] = 1` 初始化（左积的起点）
2. 右积用单变量 `right` 节省空间（无需额外数组）
3. 反扫时先 `ans[i] *= right` 再 `right *= nums[i]`（顺序不能反）

**Java 基础点**：`int[]` 初始化默认 0、单变量滚动累乘
**ACM 输入套路**：套路 1 单组 n+数组

**关联题**：前缀积典范，与 Day 1 双指针属不同家族

---

### 274 H 指数 [M]  模式: 计数统计 ⭐重点题

**一句话题意**：求最大 h，使至少 h 篇论文引用数 ≥ h。

**记忆口诀**：
> 引用数封顶 n，计数映射到 n+1；从高到低累加，累加值 >= 当前引用即 H。

**可背模板**：
  cnt = new int[n+1]
  for c in citations: cnt[min(c, n)]++
  total = 0
  for i in [n, 0]:
      total += cnt[i]
      if total >= i: return i
  return 0

**Java 完整解法**：[Solution_274.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day5_prefix_count/Solution_274.java)

**复杂度**：O(n) / O(n)

**关键易错点**：
1. `Math.min(c, n)` 封顶——引用数 > n 的等价于 n（不影响 h ≤ n）
2. 从高到低累加（i = n 递减到 0）
3. `total >= i` 即返回 i（至少 i 篇引用 ≥ i）

**Java 基础点**：`Math.min`、`int[]` 计数数组、反向 for
**ACM 输入套路**：套路 1 单组 n+数组

**关联题**：计数排序思想，275（已排序数组的 H 指数，进阶）

---

### 6 Z 字形变换 [M]  模式: 周期索引 ⭐重点题

**一句话题意**：字符串按 Z 字形排成 numRows 行，输出按行读的结果。

**记忆口诀**：
> 方向标志 ±1，到边即翻转；逐行 StringBuilder，最后拼成串。

**可背模板**：
  if numRows == 1: return s
  rows = StringBuilder[numRows]
  i = 0, dir = 1
  for c in s:
      rows[i].append(c)
      if i == 0: dir = 1
      elif i == numRows-1: dir = -1
      i += dir
  return concat(rows)

**Java 完整解法**：[Solution_6.java](file:///c:/Users/26947/Desktop/summer/Algorithm/src/phase1_arrays_strings/day5_prefix_count/Solution_6.java)

**复杂度**：O(n) / O(n)

**关键易错点**：
1. `numRows == 1` 特判（否则 dir 永远翻转，死循环）
2. 方向标志在边界翻转：i==0 向下，i==numRows-1 向上
3. 用 `StringBuilder[]` 按行收集，最后拼接

**Java 基础点**：`StringBuilder[]` 数组、`toCharArray`、增强 for 遍历
**ACM 输入套路**：套路 3 字符串+整数

**关联题**：方向标志法典范，与 238/274 同属「扫描技巧」家族

---

### 今日口诀合集（Day 5）

1. 左积正扫一遍，右积反扫一遍；左乘右即答案，无需除法。（238）
2. 引用数封顶 n，计数映射到 n+1；从高到低累加，累加值 >= 当前引用即 H。（274）
3. 方向标志 ±1，到边即翻转；逐行 StringBuilder，最后拼成串。（6）

<!-- 后续 Day 2–7 同样在此追加 -->
