package classify.binary_search_tree.medium;

import tools.TreeNode;

public class TrimABinarySearchTree {

    /**
     * 0ms      100.00%
     * 40.7MB   90.90%
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val == low) {
            root.left = null;
            root.right = trimBST(root.right, low, high);
        }
        if (root.val == high) {
            root.right = null;
            root.left = trimBST(root.left, low, high);
        }
        if (root.val > low && root.val < high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        if (root.val < low) {
            root = trimBST(root.right, low, high);
        }
        if (root.val > high) {
            root = trimBST(root.left, low, high);
        }

        return root;
    }

    /**
     * 0ms      100.00%
     * 41.6MB   5.00%
     */
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        return midOrder(root, low, high);
    }

    private TreeNode midOrder(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val > high) return midOrder(root.left, low, high);
        if (root.val < low) return midOrder(root.right, low, high);
        root.left = midOrder(root.left, low, high);
        root.right = midOrder(root.right, low, high);
        return root;
    }
}
