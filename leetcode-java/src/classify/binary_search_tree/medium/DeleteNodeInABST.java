package classify.binary_search_tree.medium;

import tools.TreeNode;

public class DeleteNodeInABST {

    /**
     * 0ms      100.00%
     * 39.3MB   87.42%
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode minNode = findMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) node = node.left;

        return node;
    }

    /**
     * 0ms      100.00%
     * 41.5MB   85.08%
     */
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode rightMin = root.right;
            while (rightMin.left != null) {
                rightMin = rightMin.left;
            }
            rightMin.left = root.left;
            root = root.right;
        }

        return root;
    }
}
