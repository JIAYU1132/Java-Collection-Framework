import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {

//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
//    有效字符串需满足：
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。

        public boolean isValid(String s) {
            // 创建一个 Map， key 对应左括号， value 存放右括号， 可以根据 key 查找 value
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            // 1. 先创建一个栈
            Stack<Character> stack = new Stack<>();
            // 2. 循环遍历字符串中的每个字符，如果是左括号，就进行入栈操作
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                    continue;
                }
                // 如果此时不是左括号，且栈为空的话，直接返回
                if (stack.empty()) {
                    return false;
                }
                // 3. 判断 c 是否是右括号， 如果是右括号，就取出栈顶元素来对比一下
                char top = stack.pop();
                if(map.get(top) == c) {
                    continue;
                }
                return false;
            }
            if (stack.empty()) {
                return true;
            }
            return false;
        }
    }

