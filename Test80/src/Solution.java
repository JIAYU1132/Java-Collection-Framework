import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    // 最常见的单词

    // 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
    //题目保证至少有一个词不在禁用列表中，而且答案唯一。
    //禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。

//     思路: 利用 HashMap 实现
//     这个题目看似简单, 实则有很多坑:
//     1. 段落中大小写字母都有, 但 banned 中只有小写字母
//     2. 段落中单词的间隔不仅仅有空格, 还有标点符号, 这样就不能直接根据 String 类型存入 HashMap 中
//     解决方法:
//     1. 先把 banned 存入一个 HashSet 中, 以便于判断
//     2. 逐个字符遍历整个段落, 如果遇到标点符号, 就把之前遍历的字母转小写作为一个单词
//     3. 判断这个单词是否在 HashSet 中存在, 如果不存在, 就存到 HashMap 中
//     4. 把每个单词的 key 和 value 值记录下来, 并不断更新, 保存最大值, 最后返回记录最大值的单词即可

    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        HashMap<String, Integer> map = new HashMap<>();
        String result = " "; // 用于存放更新最大值的单词
        int max = 0; // 用于存放更新单词的 value
        StringBuilder word = new StringBuilder(); // 用于存放遍历 paragraph 得到的每个单词

        paragraph += "."; // 处理 paragraph 中的最后一个单词
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                // 如果这个单词是字母, 把他存入 word 中, 在存的时候注意转成小写
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                // 处理这个单词
                String s = word.toString();
                if (!set.contains(s)) {
                    // 这个单词不在 banned 中, 把他存入 map 中
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    // 记录更新 word 和他的 value
                    if (map.get(s) > max) {
                        result = s;
                        max = map.get(s);
                    }
                }
                // 这里已经处理完 word 里存的这个单词了, 需要更新 word 记录 paragraph 中的下一个单词
                word = new StringBuilder();
            }
        }
        // 这里 result 中存的就是 map 中 value 最大的元素
        return result;
    }
}
