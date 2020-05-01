class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTree {
//采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
    private StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
            // 返回一个空字符
        }
        // 借助 builder 方法访问二叉树
        helper(t);
        // 将递归得到的最前面和最后面的两个括号去掉
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void helper(TreeNode t) {
        if (t == null) {
            return;
        }
        // 访问根节点, 此处的访问操作是将该节点的值加到字符串中
        sb.append("(");
        sb.append(t.val);
        helper(t.left);
        // 递归访问左子树
        if (t.left == null && t.right != null) {
            // 如果左子树为空, 右子树不为空, 必须加上括号
            sb.append("()");
        }
        // 递归访问右子树
        helper(t.right);
        sb.append(")");
    }
}
