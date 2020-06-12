class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

// 开散列
public class MyHashSet {

    //  array 是 hash 的本体, 数组的每个元素又是一个链表的头结点
    private Node[] array = new Node[1001];

    // 实现 hash 函数
    public int hashFuc(int key) {
        return key % array.length;
    }

    public void add(int key) {
        int index = hashFuc(key);
        Node list = array[index];
        // 如果已经存在, 直接返回
        if (contains(key)) {
            return;
        }
        // 此时 key 不存在, 直接插入即可(头插)
        Node newNode = new Node(key);
        newNode.next = list;
        array[index] = newNode;
    }

    public void remove(int key) {
        int index = hashFuc(key);
        // 如果不存在, 直接返回
        if (!contains(key)) {
            return;
        }
        // 此时 key 不存在, 是为要删除的
        Node prev = array[index];
        Node cur = prev.next;
        // 先判断 index 位置的 val 是不是 key, 是就直接让 index 位置存当前节点的 next,
        // 如果不是就循环判断 index 的下一个节点的 val, 如果下个节点是, 就让 index 位置的 next 指向下个节点的 next, 删除成功
        if (prev.val == key) {
            array[index] = cur;
        }  else {
            while (cur != null) {
                if (cur.val == key) {
                    prev.next = cur.next;
                    return;
                }
                prev = prev.next;
                cur = cur.next;
            }
        }
    }

    public boolean contains(int key) {
        int index = hashFuc(key);
        if (array[index] == null) {
            return false;
        }
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.val == key) {
                return true;
            }
        }
        return false;
    }
}
