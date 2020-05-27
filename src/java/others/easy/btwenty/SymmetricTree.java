package java.others.easy.btwenty;


import java.tools.TreeNode;

/**
 * 101 Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */

public class SymmetricTree {

    private static boolean isSymmetricTree(TreeNode root) {
        if ((root == null) || (root.right == null && root.left == null))
            return true;
        else if (root.right != null && root.left != null)
            return isMirrorTree(root.right, root.left);
        else
            return false;
    }

    private static boolean isMirrorTree(TreeNode rightNode, TreeNode leftNode) {
        if (rightNode == null)
            return leftNode == null;
        else if (leftNode == null)
            return false;
        else if (rightNode.val == leftNode.val)
            return isMirrorTree(rightNode.right, leftNode.left) && isMirrorTree(rightNode.left, leftNode.right);
        else
            return false;
    }
}
