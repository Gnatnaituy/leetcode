package java.others.easy.mtwenty;

import java.tools.TreeNode;

/**
 * 965 Univalued Binary Tree
 */

public class UnivaluedBinaryTree {

    private boolean inUnivaluedTree(TreeNode root) {
//        if (root == null) return true;
//        return dfs(root, root.val);

        return isUnivalTree(root, root.val);
    }

    private boolean dfs(TreeNode node, int val) {
        if (node == null) return true;
        return dfs(node.left, val) && dfs(node.right, val) && node.val == val;
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) { return true; }
        if (root.val != val) { return false; }

        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }
}
