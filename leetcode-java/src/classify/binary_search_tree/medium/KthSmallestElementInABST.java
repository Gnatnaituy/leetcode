package classify.binary_search_tree.medium;

import tools.TreeNode;

public class KthSmallestElementInABST {
    private int res = 0;
    private int step;

    /**
     * 0ms      100.00%
     * 41MB     81.89%
     */
    public int kthSmallest(TreeNode root, int k) {
        step = k;
        helper(root);

        return res;
    }

    private void helper(TreeNode root) {
        if (root != null) {
            helper(root.left);
            if (step-- == 1) res = root.val;
            helper(root.right);
        }
    }
}
