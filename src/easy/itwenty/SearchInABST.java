package easy.itwenty;
import tools.TreeNode;

/**
 * 700 Search in a BST
 */

public class SearchInABST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}