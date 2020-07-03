package classify.tree;

import tools.TreeNode;

public class PathSum {

    /**
     * 0ms 100.00%
     * 38.9MB 8.05%
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && sum == root.val)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
