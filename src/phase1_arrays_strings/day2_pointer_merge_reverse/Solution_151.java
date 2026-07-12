import java.util.*;

// 题号: 151  标题: 反转字符串中的单词  难度: M  模式: 双指针进阶
// 口诀: 整体反转一次，逐词反转一次；多余空格 trim，单词间单空格。
// 复杂度: O(n) / O(n)
public class Solution_151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.hasNextLine() ? sc.nextLine() : "";
        System.out.println(new Solution_151().reverseWords(s));
    }
}
