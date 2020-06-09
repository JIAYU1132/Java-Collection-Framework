import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    // 找不同

    // 给定两个字符串 s 和 t，它们只包含小写字母。
    // 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    // 请找出在 t 中被添加的字母。

//     思路:
//     把 s 中的每个字符存入 Hash 表中, 如果出现一次, 在 Hash 表中的次数加一, 然后再遍历 t 再 Hash 表中进行操作
//     如果找到对应的字符, 就把次数减 1
//     之所以用次数来判断, 是因为考虑到一种情况: 新增的字符是 s 中本来就有的字符, 如果单纯判断字符是否在 t 中存在的话, 不能实现

    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        int i = 0;
        for (; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (hash[index] == 0) {
                // 如果对应的次数为 0 直接跳出循环, 返回这个字符
                break;
            } else {
                // 如果对应字符不为 0, 就把他的次数减 1
                hash[index]--;
            }
        }
        return t.charAt(i);
    }
}
