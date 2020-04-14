class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}

// 写一个方法, 求树中所有节点的个数
// 访问所有节点 size + 1
// 使用递归"拆分问题"
// 整个树的节点数 = 根节点数 + 左子树节点数 + 右子树节点数
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

    public static int size(Node root) {
        if (root == null) {
            // 递归结束条件
            return 1;
        }
        return 1 + size(root.right) + size(root.left);
    }

}
