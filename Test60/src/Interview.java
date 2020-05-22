import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Interview {
    // 旧键盘
//
//     题目分析:
//      换掉的键: 按下没有输出
//      给定一个"预期输出的字符串", 在给定一个"实际输出的字符串"
//      找到"预期输出的字符串"中有, 但是"实际输出的字符串"中没有的字符, 这样的字符就是坏掉的键
//      如果某个键坏了, 大小写都无法输出, 需要把大小写看成一种情况

//     思路:
//     1. 循环读入两个字符串, 第一个是预期输出的, 第二个是实际输出的
//     2. 把读入的字符全部转成大写
//     3. 主要任务就是, 判定预期输出的哪个字符在实际输出中不存在
//        搞一个 Set 把实际输出的每个字符都存进去, 然后遍历预期输出字符, 看看哪个字符在 Set 不存在
//     注意!!! 最后需要对坏掉的键进行去重(使用 Set 来操作)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String expected = scanner.next(); // 预期输出
            String actual = scanner.next(); // 实际输出
            // 转大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            // 创建 Set 保存实际输出字符
            Set<Character> actualSet = new HashSet<>();
            Set<Character> brokenKeySet = new HashSet<>(); // brokenKeySet 用于辅助去重
            for (int i = 0; i < actual.length(); i++) {
                actualSet.add(actual.charAt(i));
                // Set 中的元素不能重复, 在 add 的时候如果这个元素已经存在, add 就不会进行(没有负面影响)
            }
            // 遍历预期输出字符串判断是否在 actualSet 中存在
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (actualSet.contains(c)) {
                    // 如果预期字符在实际字符中存在, 直接跳过当前循环即可
                    continue;
                }
                if (brokenKeySet.contains(c)) {
                    // 如果这个字符在 brokenKeySet 中存在, 说明需要进行去重, 此时直接跳过本次循环, 不执行下面的打印即可
                    continue;
                }
                // 此时预期字符在实际字符中不存在, 需要进行打印
                // 还需要考虑一个去重问题
                System.out.print(c);
                brokenKeySet.add(c);
            }
        }
    }
}
