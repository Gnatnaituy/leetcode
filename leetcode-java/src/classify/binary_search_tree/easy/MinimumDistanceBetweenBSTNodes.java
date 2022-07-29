package classify.binary_search_tree.easy;

import tools.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    int res = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;

    /**
     * 0ms      100.00%
     * 39.5MB   5.53%
     */
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (pre == Integer.MAX_VALUE) {
                pre = root.val;
            } else {
                res = Math.min(res, root.val - pre);
                pre = root.val;
            }
            inOrder(root.right);
        }
    }
}
