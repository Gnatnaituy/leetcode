package others.easy.ftwenty;

import tools.TreeNode;

import java.util.Stack;

/**
 * 437 Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */

public class PathSumIII {

    private static int pathSum(TreeNode root, int sum) {
        int count = 0;
        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            count += pathSumIter(node, sum);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return count;
    }

    private static int pathSumIter(TreeNode root, int sum) {
        int count = 0;
        if (root == null)
            return 0;
        if (sum == root.val)
            count++;

        count += pathSumIter(root.left, sum - root.val);
        count += pathSumIter(root.right, sum - root.val);

        return count;
    }
}
