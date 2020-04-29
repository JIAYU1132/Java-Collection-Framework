class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTest {
    // 二叉树的最近公共祖先

    // 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    //百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
    // 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    //例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
    class Solution {
        // 借助递归, 按照后序遍历的方法尝试找 p 和 q
        // 如果从某个节点开始, 后序遍历的时候可以把 p 和 q 都找齐, 说明该节点就是 p 和 q 的祖先
        // 只要找到的 p 和 q 不是在同一个子树中, 就认为是最近公共节点
        // 在后序遍历的过程中,  p 和 q 可能出现在三个位置, 左子树, 左子树或者当前节点
        // 只要 p 和 q 分布在三个位置中的两个, 就认为这个节点是最近的公共祖先

        private TreeNode lca = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            // findNode 递归找的过程中, 一旦找到结果, 就放到 lca 这个成员变量中
            findNode(root, p, q);
            return lca;
        }

        private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            // 创建三个变量, 记录三个位置
            int left = findNode(root.left, p, q) ? 1 : 0;
            int right = findNode(root.right, p ,q) ? 1 : 0;
            int mid = (root == p || root == q) ? 1 : 0;
            if (left + right + mid == 2) {
                // 相加为 0, 当前 root 不是 p 和 q 的祖先
                // 相加为 1, 当前节点 root 可能是 p 的祖先也可能是 q 的祖先, 也可能是 p 和 q 的公共祖先,
                //           但一定不是最近的公共祖先
                // 相加为 2, 当前 root 就是 p 和 q 的公共祖先
                lca = root;
            }
            return (left + right + mid) > 0;
        }
    }
}
