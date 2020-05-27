package java.classify.tree;

import java.tools.TreeNode;

public class TrimABinarySearchTree {

    /**
     * 0ms 100.00%
     * 39.3MB 78.26%
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val == L) {
            root.left = null;
            root.right = trimBST(root.right, L, R);
        }
        if (root.val == R) {
            root.right = null;
            root.left = trimBST(root.left, L, R);
        }
        if (root.val > L && root.val < R) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        if (root.val < L) {
            root = trimBST(root.right, L, R);
        }
        if (root.val > R) {
            root = trimBST(root.left, L, R);
        }

        return root;
    }
}
