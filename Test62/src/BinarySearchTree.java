class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {
    private TreeNode root = null;

    private TreeNode find(int key) {
        // 查找 key 是否存在, 存在返回对应的 TreeNode
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > key) {
                // 如果当前节点小于 key , 在他的左子树中找
                cur = cur.left;
            } else if (cur.val < key) {
                // 如果大于 key , 就在右子树中找
                cur = cur.right;
            } else {
                return cur;
            }
        }
        // 循环结束也没找到 key
        return null;
    }

    // 二叉树中不能存在 val 值相同的节点
    // 如果有和 key 相同的节点, 返回 false
    // 如果插入成功返回 true
    private boolean insert (int key) {
        if (root == null) {
            root = new TreeNode(key);
            return true;
        }
        // 和查找类似, 先找到合适的位置
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else {
                return false;
            }
        }
        // 循环结束, 此时已经找到合适的插入位置, 插入即可, 但是 cur 此时指向的是 null
        // 此时需要和链表一样创建一个负责记录的节点 parent, 负责记录 cur 的父节点, 当 cur 指向 null 时, parent 没有子结点
        // 插入时需要判断要插入到 parent 的左子树还是右子树
        if (key < parent.val) {
            parent.left = new TreeNode(key);
        } else {
            parent.right = new TreeNode(key);
        }
        return true;
    }

    // 删除成功返回 true, 删除失败返回 false
    // 判断 key 值在书中存在吗, 存在就删除失败, 不存在就删除成功
    private boolean remove(int key) {
        // 先找到待删除元素
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else {
                // 进行删除操作
                removeAction(parent, cur);
                return true;
            }
        }
        return false;
    }

    // 在这个方法中进行六种情况的判断删除
    // 此时 cur 是要删除的节点, parent 是待删除节点的父节点
    private void removeAction(TreeNode parent, TreeNode cur) {
        if (cur.left == null) {
            // 第一种情况: cur 没有左子树
            if (cur == root) {
                // 1. 如果要删除节点是 root
                root = cur.right;
            } else if (cur == parent.left) {
                // 2. cur 是 parent 的左子树, 对应情况 (1)
                parent.left = cur.right;
            } else if (cur == parent.right) {
                // 3. cur 是 parent 的右子树, 对应情况 (2)
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            // 第二种情况: cur 没有右子树
            if (cur == root) {
                // 1. 如果要删除元素是 root
                root = cur.left;
            } else if (cur == parent.left) {
                // 2. cur 是 parent 的左子树, 对应情况 (3)
                parent.left = cur.left;
            } else if (cur == parent.right) {
                // 3. cur 是 parent 的右子树, 对应情况 (4)
                parent.right = cur.left;
            }
        } else {
            // 第三种情况: cur 左右子树都不为空, 对应情况 (6) (7)
            // 1) 先找到 cur 右子树中的最小值(替罪羊)
            TreeNode goatParent = cur; // 替罪羊的父节点
            TreeNode goat = cur.right;
            while (goat.left != null) {
                // 最小值总是往左子树中找
                goatParent = goat;
                goat = goat.left;
            }
            // 此时 goat 指向的就是 cur 右子树的最小值
            // 2) 把找到的替罪羊赋值给 cur (待删除元素)
            cur.val = goat.val;
            // 3) 删除替罪羊节点
            // 替罪羊节点一定没有左子树(这种情况和情况 (1) (2) 相似)
            if (goat == goatParent.left) {
                goatParent.left = goat.right;
            } else {
                goatParent.right = goat.right;
            }
        }
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 简单测试
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(9);
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(20);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);

        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();

        TreeNode cur = binarySearchTree.find(9);
        System.out.println(cur.val);
        System.out.println("===============");
        System.out.println("after remove:");
        binarySearchTree.remove(5);
        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.root);
    }
}
