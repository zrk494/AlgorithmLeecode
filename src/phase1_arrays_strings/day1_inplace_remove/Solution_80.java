import java.util.*;

// 题号: 80  标题: 删除有序数组中的重复项 II  难度: M  模式: 原地删除/双指针
// 口诀: 快慢双指针，慢位写新值；允许两次重复，慢针小于 2 直通。
// 复杂度: O(n) / O(1)
public class Solution_80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (slow < 2 || nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int k = new Solution_80().removeDuplicates(nums);
        System.out.println(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(nums[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
