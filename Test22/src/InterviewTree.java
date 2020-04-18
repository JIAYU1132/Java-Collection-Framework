
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTree {
    // 判断两个树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 判断有 null 的情况
        // 1. p 和 q 都为 null, 认为相同
        if (p == null && q == null) {
            return true;
        }
        // 2. p 和 q 中有一个为 null, 认为不同
        if (p == null || q == null) {
            return false;
        }
        // 判断没有 null 的情况
        // 1. 根相同
        if (p.val != q.val) {
            return false;
        }
        // 2. 左右子树都相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
