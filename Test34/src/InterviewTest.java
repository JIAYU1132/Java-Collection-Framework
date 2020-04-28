import java.util.Stack;

public class InterviewTest {
    //给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
    // 判断二者是否相等，并返回结果。 # 代表退格字符。
    class Solution {

//         # 相当于栈中的出栈操作, 这里直接用栈来实现操作
//         创建一个方法, 将 S 和 T 内的 # 执行完成, 返回一个 String
        public boolean backspaceCompare(String S, String T) {
            return build(S).equals(build(T));
        }

        private String build(String A) {
            // 1. 获取字符串中每个字符, 如果不是 '#', 执行入栈操作
            // 2. 如果是, 且栈不为空, 直接出栈
            // 创建一个栈(应该是字符类型)
            Stack<Character> stack = new Stack<>();
            // 遍历每一个字符
            for (char c : A.toCharArray()) {
                if (c != '#') {
                    stack.push(c);
                } else if (!stack.isEmpty()){
                    stack.pop();
                }
            }
            return String.valueOf(stack);
        }
    }
}
