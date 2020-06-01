// 同构字符串
// 给定两个字符串 s 和 t，判断它们是否是同构的。
//
//如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//
//所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

import java.util.HashMap;
import java.util.Map;

public class isIsomorphic {

//     使用 Map 解决一一对应问题, key 存 s 中的字符, value 中存 t 中对应 s 的映射
//     Map 中只能存在一个 key 但是可以存在多个相同的 value, 即 key -> value, 即 A 中每个元素只能对应一个 B 中的元素,
//     但是 B 中的一个元素可以对应多个 A 中的元素
//     这个题比较特殊, 要求的应该是 key < -- > value, 即 B 中的每个元素也只能对应 A 中的一个元素,
//     所以应该用 containsValue 保证 B 中的元素没有建立映射关系

    public boolean isIsomorphic(String s, String t) {
        //如果 s 和 t 的长度不相等, 直接 false
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            // 保证此时 A 和 B 中元素没有映射关系
            if (map.get(sc) == null) { // 保证 A 没有映射关系
                if (map.containsValue(tc)) { // 保证 B 没有映射关系
                    return false;
                }
                // 此时 B 中元素没有映射关系, 建立 A 和 B 的一一映射关系
                map.put(sc, tc);
            }
            // 如果 A 中的元素对应不到 B 中的映射元素, 返回 false
            if (map.get(sc) != tc) {
                return false;
            }
        }
        // 循环结束还没有返回 false, 说明此时一一映射关系建立好了, 返回 true 即可
        return true;
    }
}
