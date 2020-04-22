import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class CompleteTree {
    // 对于完全二叉树, 在层序遍历时, 会出现两种状态:
    // 1. 任何一个节点都有左右子树
    //    当遇到某个节点没有子树或只有左子树, 切换到第二状态
    //    如果遇到某个节点, 只有右子树, 那他一定不是完全二叉树
    // 2. 任何一个节点, 一定没有子树

    public boolean isCompleteTree(TreeNode root) {
        // 创建一个标志位, 判断是第一阶段还是第二阶段
        boolean isSecondStep = false;

        if (root == null) {
            return true;
        }

        // 针对这个树进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 访问这个节点(判断是否符合完全二叉树的要求)
            if (!isSecondStep) {
                // 第一阶段
                if (cur.left != null && cur.right != null) {
                    queue.offer(root.left);
                    queue.offer(root.right);
                } else if (cur.right != null && cur.left == null) {
                    // 只有右子树, 没有左子树, 一定不是完全二叉树
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    // 只有左子树, 没有右子树,切换到第二形态
                    isSecondStep = true;
                } else {
                    // 第二阶段
                    // 第二阶段任何一个节点都没有子树
                    if (cur.left != null || cur.right != null) {
                        return false;
                    }
                }
            }
        }
        // 循环结束, 整个树都遍历完了, 还是没有找到反例, 说明这个数是完全二叉树
        return true;
    }

}
