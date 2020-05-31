import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//最后一块石头的重量

//有一堆石头，每块石头的重量都是正整数。
//每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//如果 x == y，那么两块石头都会被完全粉碎；
//如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

public class lastStoneWeight {
    // 1. 可以排序数组进行操作, 把每次排序后的最大值和第二大的值取出来进行操作, 然后继续排序循环进行
    // 2. 可以直接使用优先队列来求解(大根堆)

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return (o2 - o1);
            }
        });
        // 遍历数组, 把数组中所有元素进行入队列
        for (int i : stones) {
            queue.offer(i);
        }
        // 直接进行两次出队列操作, 取出的元素就是最大的两个元素
        // 循环进行这个操作, 直到队列中只剩一个元素
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            int res = x - y;
            // 如果 两个数差不为 0, 就把差入队列
            if (res != 0) {
                queue.offer(res);
            }
            }
        // 循环结束如果没有石头剩下, 就返回 0
        if (queue.isEmpty()) {
            return 0;
        }
        // 如果有石头剩下, 就取队首元素即可
        return queue.peek();
    }
}
