import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


//      给定 100 亿个数字, 找出其中前 1000 大的数字

//     1. 用一个数组保存刚才的数字, 直接在这个数组上建一个大堆, 循环 1000 次进行取栈顶元素 + 调整操作, 得到前 1000 大
//
//     2. 先取集合中的前 1000 个数字, 构成一个小堆(堆顶元素就是前 1000 大元素的守门员). 再一个一个遍历集合中的数字,
//        依次和守门员进行比较, 遇到大于守门员的元素, 就把守门员删掉, 把这个元素入堆, 并且调整堆
//        当所有元素都遍历完成后, 堆中的元素就是前 1000 大的元素

class Pair implements Comparable<Pair>{
    public int n1;
    public int n2;
    public int sum;

    public Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.sum = n1 + n2;
    }

    @Override
    public int compareTo(Pair o) {
        return this.sum - o.sum;
    }
}

public class InterviewTest {

    // 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
    //定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
    //找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。

//     思路:
//     1. 获取到所有的数对
//     2. 把数对放到优先队列里
//     3. 从优先队列里取前 k 个即可

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        // 当前需要第 k 小的元素, 需要建立一个小堆
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        // 将所有的数对入队列
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new Pair(nums1[i], nums2[j]));
            }
        }
        // 循环结束后, 只需要取前 k 对即可
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            Pair cur = queue.poll();
            List tmp = new ArrayList();
            tmp.add(cur.n1);
            tmp.add(cur.n2);
            result.add(tmp);
        }
        return result;
    }
}
