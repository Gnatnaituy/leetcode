package others.easy.btwenty;


import tools.TreeNode;

import static tools.StringToTreeNode.stringToTreeNode;

/**
 * 110 Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */

public class BalancedBinaryTree {

    private static boolean isBalancedBinaryTree(TreeNode root) {

        int leftMax, rightMax, sub;

        if (root == null)
            return true;

        if (root.left == null) {
            if (root.right == null)
                return true;
            else {
                return maxDepth(root.right) < 2;
            }
        }

        if (root.right == null) {
            return maxDepth(root.left) < 2;
        } else {
            leftMax = maxDepth(root.left);
            rightMax = maxDepth(root.right);
            sub = leftMax > rightMax ? leftMax - rightMax : rightMax - leftMax;
            if (sub > 1)
                return false;
            else
                return isBalancedBinaryTree(root.left) && isBalancedBinaryTree(root.right);
        }
    }

    private static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }



    public static void main(String[] args) {
        String input = "[0,2,4,1,null,3,-1,5,1,null,6,null,8]";
        System.out.print(isBalancedBinaryTree(stringToTreeNode(input)));
    }
}
