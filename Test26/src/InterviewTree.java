 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 给定一个二叉树，检查它是否是镜像对称的。
 public class InterviewTree{
    public boolean isSymmetric(TreeNode root) {
        // 判断这个树的左右子树 A B 是否对称 => A.val == B.val && A.left 和 B.right 是否镜像关系 &&
        // A.righ 和 B.left 是否镜像关系
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        // 如果 t1.val 和 t2.val 不相等, 他们就不是镜像关系
        if (t1.val != t2.val) {
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}

