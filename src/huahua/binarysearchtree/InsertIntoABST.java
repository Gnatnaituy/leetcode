package huahua.binarysearchtree;

import others.tools.TreeNode;

public class InsertIntoABST {

    /**
     * 0ms 100.00%
     * 40.4MB 15.69%
     * Recursion
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val > root.val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);

        return root;
    }

    /**
     * Iteration
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        TreeNode node = root;

        while (node != null) {
            if (val > root.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);

                    return root;
                } else node = node.right;
            } else {
                if (root.left == null) {
                    node.left = new TreeNode(val);

                    return root;
                } else node = node.left;
            }
        }

        return new TreeNode(val);
    }
}
