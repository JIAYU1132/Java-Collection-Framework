import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

public class Interview {

    // 前 K 个高频单词
    // 给一非空的单词列表，返回前 k 个出现次数最多的单词。
    // 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序

    // 思路:这个问题不是 topK 问题
    //  1. 先统计这个数组中某个单词出现的次数
    //  2. 把键值对组织到 ArrayList 中
    //  3. 降序排序(字典序), 取前 k 个返回即可
    static class MyComparator implements Comparator<String> {

        private Map<String, Integer> map;

        public MyComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                // compareTo 是在使用 String 默认的比较规则
                return o1.compareTo(o2);
            }
            // 这两种表达式就是在重新定义"什么叫小"
            // count1 - count2 就是定义出现次数小的比较小
            // count2 - count1 就是定义出现次数多比较小
            return count2 - count1;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        // 1. 统计单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            // 如果 map 中没有这个单词, 就先给他的 value 值定为 0
            Integer count = map.getOrDefault(s, 0);
            map.put(s, count + 1);
        }
        // 把刚才统计的字符串内容放到 ArrayList 中
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        // keySet 相当于得到了一个 Set , Set 中存放的就是所有的 key 值
        // 接下来, 对 ArrayList 进行排序即可
        // 此处的 sort 是默认进行升序排序的, 但我们需要降序排序
        // 这里需要比较器进行自定制比较
        Collections.sort(arrayList, new MyComparator(map));
        return arrayList.subList(0, k);
    }
}
