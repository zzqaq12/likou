public class L108 {
    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
     * 平衡
     *  二叉搜索树。
     *
     *
     */

    public static void main(String[] args) {

        int[] nums = {-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private static TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = dfs(nums, left, mid - 1);
        treeNode.right = dfs(nums, mid + 1, right);
        return treeNode;

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

