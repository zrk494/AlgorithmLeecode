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
