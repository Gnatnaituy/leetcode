package others.easy.gtwenty;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 530 Minimum Absolute Difference in BST
 *
 * Given a binary search tree with non-negative values,
 * find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 *
 * Note: There are at least two nodes in this BST.
 */

public class MinimumAbsoluteDifferenceInBST {

    private static int getMinimumDifferernce(TreeNode root) {
        int res = Integer.MAX_VALUE;
        List<Integer> nodes = new ArrayList<>();

        iter(root, nodes);

        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                int dif = Math.abs(nodes.get(j) - nodes.get(i));
                res = res < dif ? res : dif;
            }
        }

        return res;
    }

    private static void iter(TreeNode root, List<Integer> nodes) {
        nodes.add(root.val);
        if (root.left != null) iter(root.left, nodes);
        if (root.right != null) iter(root.right, nodes);
    }
}
