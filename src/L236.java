public class L236 {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     *
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(lowestCommonAncestor(root, root.right.right, root.right).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 检查根节点是否为空
        if (root == null) {
            return null;
        }
        // 检查根节点是否为p或q，若是则返回根节点
        if (root == p || root == q) {
            return root;
        }
        // 向左子树寻找p和q的最低公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 向右子树寻找p和q的最低公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左右子树都找到了公共祖先，则当前节点为最低公共祖先
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            // 如果只有左子树找到公共祖先，则返回左子树的结果
            return left;
        } else if (right != null) {
            // 如果只有右子树找到公共祖先，则返回右子树的结果
            return right;
        } else {
            // 如果左右子树都没有找到公共祖先，则返回null
            return null;
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
