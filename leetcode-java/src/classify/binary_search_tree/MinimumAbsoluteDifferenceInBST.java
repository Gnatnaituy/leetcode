package classify.binary_search_tree;

import tools.TreeNode;

import java.util.TreeSet;

public class MinimumAbsoluteDifferenceInBST {
    private int min = Integer.MAX_VALUE;

    /**
     * Inorder Traversal
     * 0ms      100.00%
     * 41.3MB   31.46%
     */
    private Integer previous = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);
        if (previous != null) min = Math.min(min, root.val - previous);
        previous = root.val;
        getMinimumDifference(root.right);

        return min;
    }

    /**
     * Preorder Traversal, Suit for non-BST
     * 12ms     9.93%
     * 46.3MB   5.59%
     */
    private TreeSet<Integer> set = new TreeSet<>();
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) return min;

        if (!set.isEmpty()) {
            min = set.floor(root.val) == null ? min : Math.min(min, root.val - set.floor(root.val));
            min = set.ceiling(root.val) == null ? min : Math.min(min, set.ceiling(root.val) - root.val);
        }

        set.add(root.val);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return min;
    }
}
