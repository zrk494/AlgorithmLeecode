import java.util.*;

// 题号: 28  标题: 找出字符串中第一个匹配项的下标  难度: E  模式: 字符串匹配
// 口诀: 暴力双循环，外层 haystack，内层 needle；首字匹配才深入，全部对上即返回。
// 复杂度: O(n*m) / O(1)
public class Solution_28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String haystack = sc.next();
            String needle = sc.next();
            System.out.println(new Solution_28().strStr(haystack, needle));
        }
    }
}
