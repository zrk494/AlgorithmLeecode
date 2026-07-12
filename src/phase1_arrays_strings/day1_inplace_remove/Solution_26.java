import java.util.*;

// 题号: 26  标题: 删除有序数组中的重复项  难度: E  模式: 原地删除/双指针
// 口诀: 快慢双指针，慢从 1 起；与前值不同则写，相同则快针继续。
// 复杂度: O(n) / O(1)
public class Solution_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
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
        int k = new Solution_26().removeDuplicates(nums);
        System.out.println(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(nums[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
