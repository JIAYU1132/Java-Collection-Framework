import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Interview {
    //给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    //要求返回这个链表的 深拷贝。 
    //我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
    //val：一个表示 Node.val 的整数。
    //random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null

    // 思路:
    // 方法一: 先把链表按照普通链表的方式复制一份, 遍历每个节点
    //        看该节点 random 指针指向的位置相对于头结点的偏移量是几(从头结点出发, 走几步能达到 random 指向的位置)
    //        然后根据这个偏移量, 决定新链表中每个节点的 random 的指向

    // 方法二: 创建一个 Map(Node, Node), key 存旧链表的节点, value 存新链表的节点(旧链表的拷贝)

    public Node copyRandomList(Node head) {
        // 1. 先遍历旧链表, 把每个节点依次插入到 map 中
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 2. 再次遍历链表, 修改新链表的 next 和 random
        for (Node cur = head; cur != null; cur = cur.next) {
            // 先从 map 中找到每个节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        return map.get(head);
    }
    }

