import java.util.*;

// 题号: 13  标题: 罗马数字转整数  难度: E  模式: 字符串 I
// 口诀: 前小后减，否则加；从左到右扫一遍，值入 Map 查。
// 复杂度: O(n) / O(1)
public class Solution_13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
            if (cur < next) result -= cur;
            else result += cur;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(new Solution_13().romanToInt(s));
        }
    }
}
