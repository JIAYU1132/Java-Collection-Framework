class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
//        简单测试代码
//    public static void main(String[] args) {
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtTail(0);
//        myLinkedList.addAtTail(1);
//        myLinkedList.addAtTail(2);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(3, 4);
//        //System.out.println(myLinkedList.get(3));
//        myLinkedList.display();
//        myLinkedList.deleteAtIndex(1);
//        myLinkedList.display();
//    }

    private Node head = null;

    public void display() {
        // 把链表中的每个元素都打印出来
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
        System.out.println();
    }

    public int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node cur = head;
        if (index < 0 || index >= getSize()) {
            return -1;
        }
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        // 此时 tail 指向的是链表的最后一个节点
        tail.next = node;
    }

//    在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
//    如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        if (index == getSize()) {
            addAtTail(val);
            return;
        }
        if (index > getSize()) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        Node cur = head;
        // 找到 cur 的前一个节点位置
        cur = getPos(index - 1);
        node.next = cur.next;
        cur.next = node;
    }

    // 给定 index 下标, 找到对应的节点
    public Node getPos(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= getSize()) {
            return;
        }
        Node cur = head;
        // 如果要删除的是头结点
        if (index == 0) {
            head = head.next;
            return;
        }
        // 找到 cur 前一个节点的位置
        cur = getPos(index - 1);
        cur.next = cur.next.next;
    }
}


