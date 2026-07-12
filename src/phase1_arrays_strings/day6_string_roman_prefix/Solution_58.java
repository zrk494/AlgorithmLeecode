import java.util.*;

// 题号: 58  标题: 最后一个单词的长度  难度: E  模式: 字符串 I
// 口诀: 从尾向前跳空格，跳完空格数字符；遇到空格或到头即停。
// 复杂度: O(n) / O(1)
public class Solution_58 {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        int len = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(new Solution_58().lengthOfLastWord(s));
        }
    }
}
