package java.classify.binarysearchtree;

import java.tools.TreeNode;

import java.util.Stack;

public class ValidateBST {

    /**
     * 2ms 24.11%
     * 40.5MB 5.01%
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {
            while (root  != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }

        return true;
    }

    /**
     * 1ms 35.01%
     * 40.5MB 5.01%
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, Long minVal, Long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;

        return isValidBST(root.left, minVal, (long) root.val) && isValidBST(root.right, (long) root.val, maxVal);
    }
}
