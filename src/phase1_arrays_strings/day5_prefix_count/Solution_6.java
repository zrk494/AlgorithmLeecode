import java.util.*;

// 题号: 6  标题: Z 字形变换  难度: M  模式: 周期索引
// 口诀: 方向标志 ±1，到边即翻转；逐行 StringBuilder，最后拼成串。
// 复杂度: O(n) / O(n)
public class Solution_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = s.length();
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
        int i = 0;
        int dir = 1;
        for (char c : s.toCharArray()) {
            rows[i].append(c);
            if (i == 0) dir = 1;
            else if (i == numRows - 1) dir = -1;
            i += dir;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) sb.append(row);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int numRows = sc.nextInt();
        System.out.println(new Solution_6().convert(s, numRows));
    }
}
