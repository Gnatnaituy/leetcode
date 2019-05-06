package huahua.binarysearchtree;

import others.tools.TreeNode;

import java.util.TreeSet;

public class MinimumAbsoluteDifferenceInBST {
    private int min = Integer.MAX_VALUE;
    private Integer previous = null;

    private TreeSet<Integer> set = new TreeSet<>();

    /**
     * 1ms 97.47%
     * 40.3MB 53.85%
     * InOrder Traversal
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);
        if (previous != null) min = Math.min(min, root.val - previous);
        previous = root.val;
        getMinimumDifference(root.right);

        return min;
    }

    /**
     * 12ms 9.93%
     * 46.3MB 5.59%
     * PreOrder Traversal
     * Suit for non-BST
     */
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
