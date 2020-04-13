import java.util.Stack;

public class MinStack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>(); // B 中存最小值

    // 入栈
    public void push(int x) {
        A.push(x);
        // 如果 B 为空, 直接将 x 入栈即可
        if (B.isEmpty()) {
            B.push(x);
            return;
        }
        // 如果 B 不为空, 将 B 中栈顶元素取出与 x 比较, 将二者最小值入栈
        int min = B.peek();
        if (x < min) {
            min = x;
        }
        B.push(min);
    }

    // 删除栈顶元素
    public Integer pop() {
        if (A.isEmpty()) {
            return null;
        }
        B.pop(); // B 和 A 要保持同步
        return A.pop();
    }

    // 获取栈顶元素
    public Integer top() {
        if (A.isEmpty()) {
            return null;
        }
        return A.peek();
    }

    // 检索最小元素
    public Integer getMin() {
        if (B.isEmpty()) {
            return null;
        }
        return B.peek();
    }
}
