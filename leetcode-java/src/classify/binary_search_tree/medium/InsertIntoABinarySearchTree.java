package classify.binary_search_tree.medium;

import tools.TreeNode;

public class InsertIntoABinarySearchTree {
    
    /**
     * Recursion
     * 0ms      100.00%
     * 42.2MB   36.28%
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    /**
     * Iteration
     * 0ms      100.00%
     * 41.8MB   93.84%
     */
    public TreeNode inserIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode parent = root, cur =root;
        while (cur != null) {
            parent = cur;
            cur = cur.val < val ? cur.right : cur.left;
        }

        if (parent.val > val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }

        return root;
    }
}
