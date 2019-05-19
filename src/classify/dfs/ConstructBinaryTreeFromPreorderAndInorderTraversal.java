package classify.dfs;

import others.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int pStart = 0;

    /**
     * 2ms 97.46%
     * 41.7MB 6.57%
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, indexes);

    }

    private TreeNode helper(int[] preorder, int pstart, int pend, Map<Integer, Integer> indexes) {
        if (pstart > pend || pStart >= preorder.length) {
            return null;
        }
        
        int index = indexes.get(preorder[pStart]);
        TreeNode root = new TreeNode(preorder[pStart]);
        pStart++;
        root.left = helper(preorder, pstart, index - 1, indexes);
        root.right = helper(preorder, index + 1, pend, indexes);

        return root;
    }
}
