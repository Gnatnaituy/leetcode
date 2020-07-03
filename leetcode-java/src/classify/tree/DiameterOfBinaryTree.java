package classify.tree;

import tools.TreeNode;

public class DiameterOfBinaryTree {
    private int maxDiameter;

    /**
     * 0ms 100.00%
     * 38MB 89.74%
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        maxDiameterDown(root);

        return maxDiameter;
    }

    private int maxDiameterDown(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, maxDiameterDown(node.left));
        int right = Math.max(0, maxDiameterDown(node.right));
        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(left, right) + 1;
    }
}
