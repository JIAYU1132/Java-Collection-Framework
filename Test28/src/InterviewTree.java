import java.util.Scanner;

class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

public class InterviewTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            TreeNode root = build(line);
            inOrder(root);
            System.out.println();
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 为了在后面的递归过程中能够时刻知道当前访问到 line 中的哪个元素, 创建一个变量来记录位置
    private static int index;
    private static TreeNode build(String line) {
        index = 0;
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line) {
        // 获取当前处理的那个字符
        char cur = line.charAt(index);
        if (cur == '#') {
            return null;
        }
        // 如果字符不是 # 就创建一个节点
        TreeNode root = new TreeNode(cur);
        index++;
        // 准备处理下一个节点, 下一个节点就是当前 root 的左子树的先序遍历结果
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }
}
