import sun.reflect.generics.tree.Tree;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTest {
    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    // 要求不能创建任何新的结点，只能调整树中结点指针的指向。
    public class Solution {
        // 为了保证有序性, 使用后序遍历
        // 最终的链表 => 左子树的链表 + 根节点 + 右子树的链表
        // 需要用左子树链表的尾巴和根节点相连, 在用右子树的头部和根节点相连

        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null) {
                return null;
            }
            if (pRootOfTree.left == null && pRootOfTree.right == null) {
                return pRootOfTree;
            }
            // 1. 先递归处理左子树
            // left 就是左子树的链表的根节点
            TreeNode left = Convert(pRootOfTree.left);
            // 2. 还需要找到 left 的尾部
            TreeNode leftTail = left;
            while (leftTail != null && leftTail.right != null) {
                leftTail = leftTail.right;
                // right 相当于链表中的 next
            }
            // 循环结束, left 就指向了左侧链表的尾部
            // 3. 把左子树和当前节点连接起来
            if (left != null) {
                leftTail.right = pRootOfTree;
                pRootOfTree.left = leftTail;
                // 双向链表
            }
            // 4. 再递归处理右子树
            TreeNode right = Convert(pRootOfTree.right);
            // 因为右子树的头部与当前节点相连, 所以不用找到 right 的尾部
            // 5. 把当前节点和右子树连接起来
            if (right != null) {
                right.left = pRootOfTree;
                pRootOfTree.right = right;
            }
            // 6. 最终返回头结点
            // 如果 left 为空, 链表的头结点就是 pRootOfTree
            // 如果 left 为非空, 链表的头结点就是 left
            return left == null ? pRootOfTree : left;
        }
    }
}
