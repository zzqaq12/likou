public class L124 {
    /**
     * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     *
     * 路径和 是路径中各节点值的总和。
     *
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     */

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        // 初始化最大值为最小值
        max[0] = Integer.MIN_VALUE;
        dfs(root, max);
        return max[0];
    }

    public static int dfs(TreeNode root, int[] max) {
        if (root == null) return 0;

        int left = Math.max(dfs(root.left, max), 0);

        int right = Math.max(dfs(root.right, max), 0);
        // 当前节点的最大路径和为当前节点的值加上左右子树中的最大值
        max[0] = Math.max(max[0], root.val + left + right);
        // 返回当前节点的值加上左右子树中的最大值
        return Math.max(left, right) + root.val;
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
