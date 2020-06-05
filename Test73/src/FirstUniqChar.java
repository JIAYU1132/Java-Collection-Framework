import java.util.HashMap;

public class FirstUniqChar {
    // 字符串中的第一个唯一字符
    // 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1

//     思路: 借助 HashMap 来操作
//     key 中存字符串中的每个字符, value 中存这个字符出现的次数
//     所有的字符存入 HashMap 中后, 再次遍历字符数组, 在 map 中查找, 如果这个字符在 map 中对应的 value 等于 1, 就直接返回当前这个字符

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 把 s 中的每个字符存入 map 中, 如果当前 key 存在, 就把 value 加 1, 如果 key 不存在, 就把 value 定为 1
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        // 此时, s 中所有的字符以及他出现的次数都存在 map 中了
        // 再遍历一遍, 找到第一个 value 等于 1 的字符, 返回
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
