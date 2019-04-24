package others.easy.htwenty;

import others.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 637 Average of Levels in Binary Tree
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */

public class AverageOfLevelsInBinarayTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            int count = size;
            double sum = 0.0;
            while (size > 0) {
                TreeNode node = nodes.poll();
                assert node != null;
                sum += node.val;
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
                size--;
            }
            res.add(sum / count);
        }
        return res;
    }
}
