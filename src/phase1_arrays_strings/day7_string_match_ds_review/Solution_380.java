import java.util.*;

// 题号: 380  标题: O(1) 时间插入、删除和获取随机元素  难度: M  模式: 数据结构设计
// 口诀: List 存值 Map 存位，插入尾追加；删除末位替换法，先换后删 O(1)。
// 复杂度: insert/remove/getRandom 均 O(1)
public class Solution_380 {
    private List<Integer> list;
    private Map<Integer, Integer> idx;

    public Solution_380() {
        list = new ArrayList<>();
        idx = new HashMap<>();
    }

    public boolean insert(int val) {
        if (idx.containsKey(val)) return false;
        idx.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!idx.containsKey(val)) return false;
        int i = idx.get(val);
        int last = list.get(list.size() - 1);
        list.set(i, last);
        idx.put(last, i);
        list.remove(list.size() - 1);
        idx.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }

    public static void main(String[] args) {
        Solution_380 obj = new Solution_380();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}
