package classify.binary_search_tree.medium;

import tools.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0);
    }

    private TreeNode helper(int[] preorder, int index) {
        if (index >= preorder.length) return null;

        TreeNode node = new TreeNode(preorder[index]);
        node.left = helper(preorder, index + 1);
        node.right = helper(preorder, index + 2);
        
        return node;
    }
}
