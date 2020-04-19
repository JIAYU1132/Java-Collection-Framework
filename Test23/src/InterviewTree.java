 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
  }

public class Interview{
    // 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
    // s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

    public boolean isSubtree(TreeNode s, TreeNode t) {
        // s 是否包含 t => s 和 t 是否相等 || s.right 是否包含 t || s.left 是否包含 t
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        Boolean ret = isSameTree(s, t);
        // 判断 s 的左右子树是否包含 t
        return ret || isSubtree(s.right, t) || isSubtree(s.left, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
