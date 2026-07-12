import java.util.*;

// 题号: 169  标题: 多数元素  难度: E  模式: 贪心 II（摩尔投票）
// 口诀: 计数归零换人，同则加一异减一；多数必胜出，最后候选人即答案。
// 复杂度: O(n) / O(1)
public class Solution_169 {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        for (int x : nums) {
            if (cnt == 0) candidate = x;
            cnt += (x == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
            System.out.println(new Solution_169().majorityElement(nums));
        }
    }
}
