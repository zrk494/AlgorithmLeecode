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
