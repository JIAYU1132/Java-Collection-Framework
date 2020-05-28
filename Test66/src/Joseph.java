import java.util.LinkedList;

// 约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。
// 然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。
// 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
//给定一个int n，代表游戏的人数。请返回最后一个人的编号

public class Joseph {
    // 思路:
    // 每次报数完毕后, 把最后一个元素移到首部, 开始新一轮的报数

    public int getResult(int n) {
        // write code here
        if (n <= 2) {
            return 1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        // 直接执行第一轮报数操作, 把报 1 的人加入到链表中
        for (int i = 1; i <= n; i+= 2) {
            list.add(i);
        }
        int count = 3; // 记录第几轮报数, 从第 3 轮开始
        while (count <= n) {
            // 把尾部的元素移到头部去重新开始报数
            list.addFirst(list.removeLast());
            int len = list.size(); // 用来保存链表长度
            int k = 1;
            for (int i = 1; i <= len; i++) { // 接下来链表的长度是不停变化的
                if (i % count != 1) {
                    list.remove(i - k);
                    k++; // 删除一个元素, 后面的元素就会自动前移, 所以要更新 k 的值
                }
            }
            if (count >= list.size()) {
                return list.getLast();
            }
            count++;
        }
        return -1;
    }
}
