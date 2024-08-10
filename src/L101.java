public class L101 {

    /**
     * 你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }
        return root.val == root1.val && isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
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
