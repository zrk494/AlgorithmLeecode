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
