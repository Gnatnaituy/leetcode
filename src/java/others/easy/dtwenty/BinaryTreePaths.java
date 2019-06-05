package java.others.easy.dtwenty;

import java.others.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257 Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

public class BinaryTreePaths {

    private static List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            result.add("" + root.val);

        if (root.right != null) {
            for (String oneRode : binaryTreePaths(root.right))
                result.add(root.val + "->" + oneRode);
        }

        if (root.left != null) {
            for (String oneRode : binaryTreePaths(root.left))
                result.add(root.val + "->" + oneRode);
        }

        return result;
    }
}
