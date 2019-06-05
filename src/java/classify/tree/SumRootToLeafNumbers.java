package java.classify.tree;

import java.others.tools.TreeNode;

public class SumRootToLeafNumbers {
    private int res = 0;

    /**
     * 0ms 100.00%
     * 36.9MB 39.61%
     */
    public int sumNumbers(TreeNode root) {
        if (root != null) helper(root, 0);

        return res;
    }

    private void helper(TreeNode root, int number) {
        if (root.left == null && root.right == null) {
            res += number * 10 + root.val;
            return;
        }
        if (root.left != null) helper(root.left, number * 10 + root.val);
        if (root.right != null) helper(root.right, number * 10 + root.val);
    }
}
