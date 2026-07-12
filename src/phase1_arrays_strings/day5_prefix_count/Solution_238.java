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
