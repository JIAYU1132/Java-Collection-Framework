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
    // 非递归完成后序遍历

//     1. 创建一个 cur 变量, 指向 root
//        从 cur 出发循环向左找, 只要非空, 都入栈
//     2. 获取栈顶元素(peek()), 判断栈顶元素能不能被访问
//        1) 如果栈顶元素没有右子树, 说明该节点可以被访问
//        2) 如果栈顶元素的右子树已经被访问过了(看看上一个被访问的元素是不是他的右子树), 该节点也可以被访问
//     3. 从刚才栈顶元素的右子树开始, 继续执行这个过程
    public static void postOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        // 创建一个栈来辅助
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        // prev 用来记录已经访问过的节点中的最后一个节点(即将被访问元素的前一个节点)
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            // 拿出栈顶元素的值, 看他能不能被访问
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                // 此时说明这个栈顶元素是可以访问的
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
                // 更新 prev 的值, 让他时刻指向已经访问的最后一个元素
            } else {
                cur = top.right;
            }
        }
    }
}
