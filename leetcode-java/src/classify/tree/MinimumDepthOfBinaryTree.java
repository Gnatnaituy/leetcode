package classify.tree;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    /**
     * Recursive
     * 0ms 100.00%
     * 40.6MB 5.07%
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return search(root, 0);
    }

    private int search(TreeNode node, int depth) {
        if (node.left == null && node.right == null) return depth + 1;
        if (node.left == null) return search(node.right, depth + 1);
        if (node.right == null) return search(node.left, depth + 1);
        return Math.min(search(node.left, depth + 1), search(node.right, depth + 1));
    }

    /**
     * Iterative
     * 0ms 100.00%
     * 39.5MB 15.71%
     */
    public int minDepth2(TreeNode root) {
        int res = 0;
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return res;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
        }

        return res;
    }
}
