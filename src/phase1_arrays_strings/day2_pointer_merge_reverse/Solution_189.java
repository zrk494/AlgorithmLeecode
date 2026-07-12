import java.util.*;

// 题号: 189  标题: 轮转数组  难度: M  模式: 双指针进阶
// 口诀: k 先取模，三次反转搞定：全反转、前 k 反转、后 n-k 反转。
// 复杂度: O(n) / O(1)
public class Solution_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l]; nums[l] = nums[r]; nums[r] = t;
            l++; r--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        new Solution_189().rotate(nums, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(nums[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
