class Node{
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyLinkedList {
    private Node head = null;

    public void display() {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
    }

    public void addFirst(int data) {
        // 1. 根据 data 值构建一个链表节点
        Node node = new Node(data);
        // 2. 处理链表为空链表情况
        if (head == null) {
            head = node;
            return;
        }
        // 3. 处理不是空链表的情况
       node.next = head;
        head = node;
    }

    public void addLast(int data) {
        // 1. 根据 data 值构建一个链表节点
        Node node = new Node(data);
        // 2. 如果链表为空, 直接插入
        if (head == null) {
            head = node;
            return;
        }
        // 3. 链表非空, 先找到链表的最后节点, 再进行插入操作
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        // 此时, tail 指向最后一个节点
        tail.next = node;
    }

    public int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public Node getPos(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void addIndex(int index, int data) {
        Node node = new Node(data);
        // 1. 判断 index 情况
        // 1) Index 不合法
        if (index < 0 || index > getSize()) {
            return;
        }
        // 2) index == 0, 相当于头插
        if (index == 0) {
            addFirst(data);
            return;
        }
        // 3) index == getSize, 相当于尾插
        if (index == getSize()) {
            addLast(data);
            return;
        }
        // 4) index 的其他常规情况(中间插入)
        // 找到 index 的前一个节点
        Node cur = head;
        cur = getPos(index - 1);
        node.next = cur.next;
        cur.next = node;
    }

    public boolean contains(int toFind) {
        Node cur = head;
        while (cur != null) {
            if (cur.val == toFind) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void remove(int toRemove) {
        // 1. 如果要删除的节点是头结点
        if (toRemove == head.val) {
            head =  head.next;
            return;
        }
        // 2. 如果要删除的不是头结点, 找到他的前一个节点
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == toRemove) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
    }


}
