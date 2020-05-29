import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    // ping(int t)，其中 t 代表以毫秒为单位的某个时间。
    //返回从 3000 毫秒前到现在的 ping 数。
    //任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
    //保证每次对 ping 的调用都使用比之前更大的 t 值

//     题目分析:
//     这道题实际上就是当 t 时, 在 t 之前的 3000 毫秒的 ping 数都要统计

//     思路:
//     创建一个队列, 将这些 ping 值全部存入队列
//     当收到一个时间 t 的 ping 值时, 将它加入队列, 并且把在 t 之前 3000 毫秒的 ping 值都出队列

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
