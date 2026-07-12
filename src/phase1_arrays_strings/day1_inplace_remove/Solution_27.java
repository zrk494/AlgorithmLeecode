import java.util.*;

// 题号: 27  标题: 移除元素  难度: E  模式: 原地删除/双指针
// 口诀: 快慢双指针，慢停快跑；遇到目标跳过，否则慢位接管。
// 复杂度: O(n) / O(1)
public class Solution_27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), val = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int k = new Solution_27().removeElement(nums, val);
        System.out.println(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(nums[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
