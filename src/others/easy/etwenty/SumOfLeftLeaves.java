package others.easy.etwenty;

import tools.TreeNode;

/**
 * 404 Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

public class SumOfLeftLeaves {

    private int sumOfLeftLeaves(TreeNode root) {
        int res = 0;

        if (root != null)
        {
            if (isLeaf(root.left))
                res += root.left.val;
            else
                res += sumOfLeftLeaves(root.left);
            res += sumOfLeftLeaves(root.right);
        }

        return res;
    }

    private boolean isLeaf(TreeNode node)
    {
        if (node == null)
            return false;
        return node.left == null && node.right == null;
    }
}
