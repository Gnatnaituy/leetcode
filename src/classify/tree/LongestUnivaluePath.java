package classify.tree;

import others.tools.TreeNode;

public class LongestUnivaluePath {
    private int res = 0;

    /**
     * 4ms 83.42%
     * 42.9MB 10.65%
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) dfs(root);

        return res;
    }

    private int dfs(TreeNode node) {
        int l = node.left != null ? dfs(node.left) : 0;
        int r = node.right != null ? dfs(node.right) : 0;
        int left = node.left != null && node.left.val == node.val ? l + 1 : 0;
        int right = node.right != null && node.right.val == node.val ? r + 1 : 0;
        res = Math.max(res, left + right);
        
        return Math.max(left, right);
    }
}
