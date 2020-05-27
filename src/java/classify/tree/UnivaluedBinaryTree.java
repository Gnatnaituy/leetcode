package java.classify.tree;

import java.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree {

    /**
     * Recursive
     * 0ms 100.00%
     * 35.6MB 92.59%
     */
    public boolean isUnivalTree(TreeNode root) {
        return root == null || isUniValue(root, root.val);
    }

    private boolean isUniValue(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;

        return isUniValue(root.left, val) && isUniValue(root.right, val);
    }

    /**
     * Iterative
     * 0ms 100.00%
     * 35.6MB 92.59%
     */
    public boolean isUnivalTree2(TreeNode root) {
        if (root == null) return true;

        int uniVal = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val != uniVal) return false;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return true;
    }
}
