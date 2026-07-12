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
