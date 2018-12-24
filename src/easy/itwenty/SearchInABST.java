package easy.itwenty;
import tools.TreeNode;

/**
 * 700 Search in a BST
 */

public class SearchInABST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) { // 在左子树中查找
            return searchBST(root.left, val);
        } else { // 在右子树中查找
            return searchBST(root.right, val);
        }
    }
}