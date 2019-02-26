package others.easy.btwenty;

import tools.TreeNode;

/**
 * 100 Same Tree
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 *
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 *
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */

public class SameTree {

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.left == null && p.right == null && q.left == null && q.right == null && p.val == q.val)
            return true;
        else if (p.right == null && q.right == null && p.left != null && q.left != null && p.val == q.val)
            return isSameTree(p.left, q.left);
        else if (p.left == null && q.left == null && p.right != null && q.right != null && p.val == q.val)
            return isSameTree(p.right, q.right);
        else if (p.left != null && q.left != null && p.right != null && q.right != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(9);
        System.out.println(isSameTree(a, b));
    }
}
