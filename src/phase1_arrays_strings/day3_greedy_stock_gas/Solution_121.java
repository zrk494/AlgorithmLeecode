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
