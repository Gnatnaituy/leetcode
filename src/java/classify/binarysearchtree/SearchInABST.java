package java.classify.binarysearchtree;

import java.others.tools.TreeNode;

public class SearchInABST {

    /**
     * 0ms 100.00%
     * 39.8MB 94.80%
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
