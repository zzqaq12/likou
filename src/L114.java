public class L114 {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     */
    public static void main(String[] args) {
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            } else {
                cur = cur.right;
            }

        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
