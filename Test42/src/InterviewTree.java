import sun.reflect.generics.tree.Tree;

import java.util.Stack;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTree {
    // 非递归的方式进行二叉树的中序遍历

//     1. 从 root 出发一直向左找, 直到左子树为 null
//     2. 取栈顶元素, 出栈并且访问这个元素
//     3. 把刚才栈顶元素的右子树作为起点, 继续往左找, 遇到的元素依次入栈.
//     重复 2, 3

    public static void inOrderByLoon(TreeNode root) {
        if (root == null) {
            return;
        }
        // 借助栈来操作
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            // 1. 循环一直找左子树, 把遇到的所有的左子树都入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 2. 如果当前栈为空, 遍历结束
            if (cur == null) {
                break;
            }
            // 3. 获取栈顶元素并访问
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            /// 4. 从当前节点的右子树出发, 继续刚才的过程
            cur = top.right;
        }
    }
}
