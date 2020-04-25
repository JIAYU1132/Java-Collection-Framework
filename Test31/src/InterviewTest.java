import java.util.Stack;

public class InterviewTest {
    //根据逆波兰表示法，求表达式的值。

    //有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

    //说明：
    //整数除法只保留整数部分。
    //给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
    class Solution {

        // 借助栈来操作
        // 1. 将数字都入栈
        // 2. 如果遇到字符, 将栈顶两个元素出栈, 进行字符操作
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            Integer tmp1 = 0;
            Integer tmp2 = 0;
            for (String s : tokens) {
                switch (s) {
                    case "+":
                        tmp1 = stack.pop();
                        tmp2 = stack.pop();
                        stack.push(tmp1 + tmp2);
                        break;
                    case "-":
                        tmp1 = stack.pop();
                        tmp2 = stack.pop();
                        stack.push(tmp2 - tmp1);
                        break;
                    case "*":
                        tmp1 = stack.pop();
                        tmp2 = stack.pop();
                        stack.push(tmp1 * tmp2);
                        break;
                    case "/":
                        tmp1 = stack.pop();
                        tmp2 = stack.pop();
                        stack.push(tmp2 / tmp1);
                        break;
                    default:
                        // default 语句进行入栈操作, 将数字全部入栈
                        stack.push(Integer.valueOf(s));
                        break;
                }
            }
            return stack.pop();
        }
    }
}

