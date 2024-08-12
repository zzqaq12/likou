public class L530 {
    /**
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     *
     * 差值是一个正数，其数值等于两值之差的绝对值。
     */
    public static void main(String[] args) {


        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(getMinimumDifference(root));
    }

    static int min = Integer.MAX_VALUE;
    static int pre = -1;
    public static int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    public static void dfs(TreeNode root) {
        // 检查根节点是否为空，如果为空则直接返回
        if (root == null) {
            return;
        }
        // 如果左子节点存在，则递归调用dfs函数处理左子节点
        if (root.left != null) {
            dfs(root.left);
        }
        // 更新最小值，如果前一个节点值不为-1，则计算当前节点值与前一个节点值的差，并更新最小值
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        // 如果右子节点存在，则递归调用dfs函数处理右子节点
        if (root.right != null) {
            dfs(root.right);
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
