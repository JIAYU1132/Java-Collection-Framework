import java.util.Stack;

class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTree {
    // 非递归的方式完成先序遍历

    // 1. 准备一个栈, 把根节点入栈
    // 2. 循环取栈顶元素, 并且访问
    // 3. 判断当前节点的右子树是否为空, 非空就入栈
    // 4. 判断当前节点的左子树是否为空, 非空就入栈
    // 循环操作2, 3, 4

    public static void preOrderByLoop(TreeNode root) {
        // 借助栈来辅助
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            // 访问这个节点
            System.out.print(top.val + " ");
            // 先将右子树入栈, 再将左子树入栈, 因为栈后进先出, 先序遍历顺序是根左右, 要先访问左子树
            while (top.left != null) {
                stack.push(root.left);
            }
            while (top.right != null) {
                stack.push(root.right);
            }
        }
    }
}
