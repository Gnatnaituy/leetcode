package classify.binary_search_tree.medium;

import tools.TreeNode;

public class RecoverBinarySearchTree {
    
    private TreeNode prev = null;
    private TreeNode first = null;
    private TreeNode second = null;

    /**
     * 1ms      100.00%
     * 41.8MB   12.47%
     */
    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
