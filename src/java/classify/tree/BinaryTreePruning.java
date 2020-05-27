package java.classify.tree;

import java.tools.TreeNode;

public class BinaryTreePruning {

    /**
     * 0ms 100.00%
     * 35.6MB 99.48%
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = noOne(root.left) ? null : pruneTree(root.left);
        root.right = noOne(root.right) ? null : pruneTree(root.right);

        return root;
     }

    private boolean noOne(TreeNode root) {
        if (root == null) return true;
        if (root.val == 1) return false;

        return noOne(root.left) && noOne(root.right);
    }
}
