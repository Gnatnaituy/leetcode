package classify.btree;

import tools.TreeNode;

public class SearchInABST {

    /**
     * Recursion
     * 0ms      100.00%
     * 39.8MB   94.80%
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;
        if (root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    /**
     * Iteration
     * 0ms      100.00%
     * 42MB     24.89%
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else {
                root = root.val < val ? root.right : root.left;
            }
        }

        return null;
    }
}
