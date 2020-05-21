import java.util.HashSet;
import java.util.Set;

public class Interview {

//    给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
//      S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
//    J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头
    public int numJewelsInStones(String J, String S) {
        // 1. 先遍历 J 把所有吧的宝石加入到 set 中
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        // 2. 再遍历 S 拿到的元素在 set 中查找, 如果找到了, 就是宝石
        int ret = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                ret++;
            }
        }
        return ret;
    }
}
