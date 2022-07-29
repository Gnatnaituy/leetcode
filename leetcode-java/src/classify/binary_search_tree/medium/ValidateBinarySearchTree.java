package classify.binary_search_tree.medium;


import tools.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree {
    private double last = -Double.MAX_VALUE;

    /**
     * Inorder Traversal
     * 0ms      100.00%
     * 40.9MB   70.27%
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }

        return false;
    }

    /**
     * 搜索二叉树的中序遍历为升序
     * 2ms      19.68%
     * 40.8MB   85.16%
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<Integer> stack = new Stack<>();
        inOrder(root, stack);
        int pre = stack.pop();
        while (!stack.isEmpty()) {
            if (stack.peek() >= pre) return false;
            pre = stack.pop();
        }

        return true;
    }

    private void inOrder(TreeNode root, Stack<Integer> stack) {
        if (root == null) return;

        inOrder(root.left, stack);
        stack.add(root.val);
        inOrder(root.right, stack);
    }

    /**
     * 0ms      100.00%
     * 40.8MB   73.98%
     */
    public boolean isValidBST3(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, Long minVal, Long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;

        return isValidBST(root.left, minVal, (long) root.val) 
            && isValidBST(root.right, (long) root.val, maxVal);
    }
}
