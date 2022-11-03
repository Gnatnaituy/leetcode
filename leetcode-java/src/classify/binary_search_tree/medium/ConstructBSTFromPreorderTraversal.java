package classify.binary_search_tree.medium;

import tools.TreeNode;

public class ConstructBSTFromPreorderTraversal {

    /**
     * 0ms      100.00%
     * 39.4MB   83.22%
     */
    private int index = -1;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(Integer.MAX_VALUE, Integer.MIN_VALUE, preorder);
    }

    private TreeNode buildTree(int upper, int lower, int[] preorder) {
        if (index == preorder.length - 1) return null;
        int val = preorder[index + 1];
        if (val > upper || val < lower) return null;
        TreeNode node = new TreeNode(val);
        index++;
        node.left = buildTree(val, lower, preorder);
        node.right = buildTree(upper, val, preorder);
        return node;
    }
}
