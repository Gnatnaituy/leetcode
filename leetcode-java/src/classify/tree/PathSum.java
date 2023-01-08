package classify.tree;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {

    /**
     * 0ms      100.00%     O(n)
     * 38.9MB   8.05%       O(1)
     * DFS
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * 2ms      6.86%       O(n)
     * 41.5MB   40.09%      O(n)
     * BFS
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> sums = new LinkedList<>();
        nodes.offer(root);
        sums.offer(root.val);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int sum = sums.poll();
            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    return true;
                }
                continue;
            }

            if (node.left != null) {
                nodes.offer(node.left);
                sums.offer(node.left.val + sum);
            }

            if (node.right != null) {
                nodes.offer(node.right);
                sums.offer(node.right.val + sum);
            }
        }

        return false;
    }
}
