public class L230 {
    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(kthSmallest(root, 3));
    }

    static int count = 0;
    static int res = 0;
    public static int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public static void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        ++count;
        if (count == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
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
