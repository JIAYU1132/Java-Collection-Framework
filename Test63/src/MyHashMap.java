import java.util.List;

public class MyHashMap {
    // 通过开散列的方式处理 hash 冲突
    static class Node{
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final double LOAD_FACTOR = 0.75; // 负载因子

    // array 就是 hash 表的本体, 数组的每个元素又是一个链表的头结点
    private Node[] array = new Node[101];
    private int size = 0; // 表示当前 hash 表中的元素个数

    private int hashFuc(int key) {
        return key % array.length;
    }

    // 插入元素
    // 如果 key 存在, 就修改当前的 value 的值
    // 如果 key 不存在, 就插入新的键值对
    private void put(int key, int value) {
        // 1. 把 key 映射成数组下标
        int index = hashFuc(key);
        // 2. 根据下标找到对应的链表
        Node list = array[index];
        // 3. 判断当前 key 是否存在
        for (Node cur = list; cur != null; cur = cur.next) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
        }
        // 4. 循环结束, 没找到对应的 key 值, 直接插入新的键值对(头插)
        Node newNode = new Node(key,value);
        newNode.next = list;
        array[index] = newNode;
        size++;
        if (size / array.length > LOAD_FACTOR) {
            // 进行扩容
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        // 把原来 hash 表上的所有元素搬运到新的数组上
        for (int i = 0; i < array.length; i++) {
            for (Node cur = array[i]; cur != null; cur = cur.next) {
                int index = cur.key % newArray.length;
                Node newNode = new Node(cur.key, cur.value);
                newNode.next = array[index];
                array[index] = newNode;
            }
        }
        // 让新数组代替原来数组即可
        array = newArray;
    }

    // 查找元素
    // 找到返回 value, 没找到返回 null
    private Integer get(int key) {
        // 1. 计算 key对应下标
        int index = hashFuc(key);
        // 2. 根据下标找对应的链表
        Node list = array[index];
        // 3. 在链表中查找指定元素
        for (Node cur = list; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur.value;
            }
        }
        return null;
    }
}
