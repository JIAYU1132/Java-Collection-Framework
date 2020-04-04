public class MyQueueByLinkedList {
    // 队列先进先出
    // 基于链表来实现队列, 可以以尾部入队列, 出队列从头部开始删除; 也可以以头部入队列, 以尾部出队列

    // Node 这个类叫做内部类, 定义在某个类或方法中的类
    // static 的作用就是: 创建 Node 的实例不依赖于 MyQueueByLinkedList 这个类的实例
    static class Node {
        public int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    //创建一个链表就得有头结点
    // 最好把头和尾都记录下来
    private Node head = null;
    private Node tail = null;

    // 入队列
    // 以尾部入队列, 头部出队列的方式
    public void offer(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        // 如果不是空链表
        tail.next = newNode;
        tail =tail.next;
    }

    // 出队列
    public Integer  poll() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            // 删除当前元素之后, 队列变成了空队列
            tail = null;
        }
        return ret;
    }

    // 取栈顶元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
