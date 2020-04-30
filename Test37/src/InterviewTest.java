import sun.reflect.generics.tree.Tree;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}


public class InterviewTest {
    // 根据一棵树的前序遍历与中序遍历构造二叉树。

    // 1. 根据先序遍历找到当前这个树的根节点
    // 2. 拿着这个根节点去中序遍历中查找, 可以找到哪个部分是左子树, 哪个部分是右子树

    private int index;

    // index 记录当前访问到先序遍历的第几个元素了
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    // [left, right) 这个区间表示当前这个 preorde[index], 对应的中序遍历结果
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if (left >= right) {
            // 区间不合法
            return null;
        }
        if (index >= preorder.length) {
            // 遍历元素结束
            return null;
        }
        // 根据当前先序遍历中的节点创建出根节点
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        // 一个节点创建完毕就准备处理下一个节点
        // 根据该节点在中序遍历中的位置, 将 inorder 数组划分成两个部分
        int pos = find(inorder, left, right, root.val);
        // 此时, [left, pos) 表示当前 root 左子树的中序遍历结果
        // [pos + 1, right) 表示当前 root 右子树的中序遍历结果
        root.left = buildTreeHelper(preorder, inorder, left, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, right);
        return root;
    }

    private int find(int[] inorder, int left, int right, int toFind) {
        for (int i = left; i < right; i++) {
            if (inorder[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
}


