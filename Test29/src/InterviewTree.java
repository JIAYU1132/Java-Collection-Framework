import java.util.ArrayList;
import java.util.List;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTree {

    // 二叉树的层序遍历(用二维List保存结果)
     List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        // helper 方法辅助递归, 第二个参数表示当前的层数
        helper(root, 0);
        return result; 
    }

    public void helper(TreeNode root, int level) {
        if (level == result.size()) {
            // 如果 level 层数等于那一层的长度, 就新建一层
            result.add(new ArrayList<>());
        }
        // 把当前节点加入到 result 中适当的位置
       // result.get(level).add(root.val);
        List<Integer> row = result.get(level);
        row.add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }
}
