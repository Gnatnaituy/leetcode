package classify.btree;

import tools.TreeNode;

public class RecoverBST {
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode prevElement = null;

    /**
     * 2ms 94.67%
     * 40.4MB 99.12%
     */
    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            if (prevElement != null && prevElement.val > root.val) {
                if (firstElement != null) firstElement = prevElement;
                secondElement = root;
            }
            prevElement = root;
            inorder(root.right);
        }
    }
}
