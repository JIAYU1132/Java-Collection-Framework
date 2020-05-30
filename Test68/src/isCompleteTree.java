import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class isCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            // 如果二叉树是空树, 认为他是完全二叉树
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                flag = true;
                continue;
            }
            if (flag) {
                // 此时说明空子树后面还有子树
                return false;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }
}
