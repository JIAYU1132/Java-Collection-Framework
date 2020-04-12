import java.util.Stack;

public class MyQueue {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    // 入队列
    public void offer(int x) {
        // 1. 先把 B 中的元素倒腾到 A 中
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
           }
        // 2. 把新元素入 A 即可
        A.push(x);
    }

    // 出队列
    public Integer poll() {
        // 1. 如果队列是空, 直接返回
        if (empty()) {
            return null;
        }
        // 2. 把 A 中的元素全部转移到 B 中
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 3. 针对 B 进行出栈, 就是将先入队列的元素先出队列了
        return B.pop();
    }

    public Integer peek() {
        // 1. 如果队列是空, 直接返回
        if (empty()) {
            return null;
        }
        // 2. 把 A 中的元素全部转移到 B 中
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 3. 此时 B 的栈顶元素就是原队列中队首元素
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }

}
