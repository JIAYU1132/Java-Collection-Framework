import java.util.LinkedList;
import java.util.Queue;

public class MyStackBy2Queue {
    // 栈原则是"后进先出"  队列是"先进先出"
    // 把元素移到另一个队列中, 直到只剩最后一个元素, 此时这个元素就是最后进来的元素
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

        // 入栈
        public void push(int x) {
            // x 直接往 A 中入队列即可
            A.offer(x);
        }

        // 移除栈顶元素
        public Integer pop() {
            if (empty()) {
                return null;
            }
            //  把 A 中的元素往 B 中倒腾
            while (A.size() > 1) {
                Integer front = A.poll();
                B.offer(front);
            }
            // 当循环结束后, A 中还剩一个元素
            // 这个元素就是应该被出栈的元素
            int ret = A.poll();
            // 交换 A 和 B
            swapAB();
            return ret;
        }

        private void swapAB() {
            Queue<Integer> tmp = A;
            A = B;
            B = tmp;
        }

        // 获取栈顶元素
        public Integer top() {
            if (empty()) {
                return null;
            }
            //  把 A 中的元素往 B 中倒腾
            while (A.size() > 1) {
                Integer front = A.poll();
                B.offer(front);
            }
            // 当循环结束后, A 中还剩一个元素
            // 这个元素就是应该被出栈的元素
            int ret = A.poll();
            // 交换 A 和 B 身份, 保证新入栈的元素始终是 A 入
            B.offer(ret); // 这句 是 pop 和 top 唯一的区别, 获取栈顶元素后要放回
            swapAB();
            return ret;
        }


        public boolean empty() {
            return A.isEmpty() && B.isEmpty();
        }
    }


