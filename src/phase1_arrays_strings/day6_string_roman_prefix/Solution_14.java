import java.util.*;

// 题号: 14  标题: 最长公共前缀  难度: E  模式: 字符串 I
// 口诀: 纵向扫描字符列，逐位比较所有串；遇到不同或越界，截断返回。
// 复杂度: O(S) / O(1)（S 为所有字符串总长度）
public class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) strs[i] = sc.next();
            System.out.println(new Solution_14().longestCommonPrefix(strs));
        }
    }
}
