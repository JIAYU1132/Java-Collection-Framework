import java.util.Stack;

public class InterviewTest {
//    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
//    假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
//    但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

    public class Solution {

        // 将 pushA 中元素按顺序入栈,
        // 再每次入栈的时候, 都要进行一次判断: 入栈元素是否与 popA 中的第一个元素相同
        // 相同的话, 将该元素出栈, 继续判断下一个元素
        // 如果最后栈为空, 返回 true

        public boolean IsPopOrder(int[] pushA, int[] popA) {
            // 先判断两个数组是否合法
            if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
                return false;
            }
            Stack<Integer> stack = new Stack<>(); // 创建一个栈, 进行操作
            int tmp = 0; // 创建一个变量, 作为 popA 中元素的下标
            for (int i = 0; i < pushA.length; i++) {
                stack.push(pushA[i]);
                while (!stack.isEmpty() && stack.peek() == popA[tmp]) {
                    stack.pop();
                    tmp++;
                }
            }
            return stack.isEmpty();
        }
    }
}
