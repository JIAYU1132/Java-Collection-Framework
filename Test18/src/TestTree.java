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

    // 写一个方法, 求叶子节点的个数
    // 叶子结点个数 = 左子树叶子结点的个数 + 右子树叶子节点的个数
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println(leafSize(root));
    }
}
