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
