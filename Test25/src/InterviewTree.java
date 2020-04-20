
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class InterviewTree {
    // 判断一个二叉树是否是高度平衡二叉树(一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。)
    public boolean isBalanced(TreeNode root) {
        // 1. root 为空 和 左右子树为空
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        // 2. 自己的左右子树高度差的绝对值不超过 1
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            return false;
        }
        // 3. 且左右子树也为平树
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.right);
        int rightDepth = maxDepth(root.left);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
