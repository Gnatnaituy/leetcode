package classify.tree;

import others.tools.TreeNode;

public class LowestCommonAncestorOfBST {

    /**
     * 4ms 100.00%
     * 35.2MB 22.32%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q || (root.val - p.val > 0) != (root.val - q.val > 0)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        else if (left == null) return right;
        else return left;
    }
}
