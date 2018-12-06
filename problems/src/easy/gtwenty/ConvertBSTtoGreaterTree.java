package easy.gtwenty;

import tools.TreeNode;

import java.util.Stack;

/**
 * 538 Convert BST to Greater Tree
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */

public class ConvertBSTtoGreaterTree {

    private static int preNum = 0;

    private static TreeNode convertBST(TreeNode root) {
        unPreOrder(root);
        return root;
    }

    private static void unPreOrder(TreeNode root) {
        if (root == null) return;
        unPreOrder(root.right);
        root.val += preNum;
        preNum = root.val;
        unPreOrder(root.left);
    }

    private static TreeNode nonIterVersion(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(root);
                node = node.right;
            }
            node = stack.pop();
            node.val += preNum;
            preNum = node.val;
            if (node.left != null)
                node = node.left;
            else
                node = null;
        }
        return root;
    }
}
