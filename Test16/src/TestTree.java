import java.util.LinkedList;
import java.util.Queue;

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}

public class TestTree {

    public static Node build() {
        // 手动构造一棵树
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;

        return a;
    }

    // 先序遍历
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 后序遍历
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);

        postOrder(root.right);
        System.out.print(root.val + " ");;
    }

    // 层序遍历
    public static void levelOrder(Node root) {
        // 借助队列完成
        // 将根节点入队列, 再取出队首元素, 访问这个元素, 再入队列, 循环这个过程
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node ret = queue.poll();
            System.out.print(ret.val + " ");
            // 将左右子树入队列
            if (ret.left != null) {
                queue.offer(ret.left);
            }
            if (ret.right != null) {
                queue.offer(ret.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println("先序遍历: ");
        preOrder(root);
        System.out.println();

        System.out.println("中序遍历: ");
        inOrder(root);
        System.out.println();

        System.out.println("后序遍历");
        postOrder(root);
        System.out.println();

        System.out.println("层序遍历: ");
        levelOrder(root);
        System.out.println();
    }
}
