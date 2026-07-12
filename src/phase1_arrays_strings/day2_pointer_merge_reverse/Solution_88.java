import java.util.*;

// 题号: 88  标题: 合并两个有序数组  难度: E  模式: 双指针进阶
// 口诀: 三针从尾填，大到小入位；nums2 空即止，否则剩直接留。
// 复杂度: O(m+n) / O(1)
public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[] nums1 = new int[m + n];
        for (int i = 0; i < m; i++) nums1[i] = sc.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) nums2[i] = sc.nextInt();
        new Solution_88().merge(nums1, m, nums2, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n; i++) sb.append(nums1[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
