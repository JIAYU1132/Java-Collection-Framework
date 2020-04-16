class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
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

    // 写一个方法, 求树的第 k 层节点个数
    public static int kLevelSize(Node root, int k) {
        // 如果 k < 1 , 此时是空树, 返回0
        // 如果 k == 1 , 此时是根节点, 返回 1
        // 如果 k > 1 , 此时第 k 层节点个数 = 第 k - 1 层左子树节点个数 + 第 k - 1 层右子树节点个数
        if (k < 1 || root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left, k - 1) + kLevelSize(root.right, k - 1);
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println(kLevelSize(root, 3));
    }
}
