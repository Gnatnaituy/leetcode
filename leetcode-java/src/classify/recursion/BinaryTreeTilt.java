package classify.recursion;

import tools.TreeNode;

/**
 * @author yutiantang
 * @create 2021/3/31 22:38
 */
public class BinaryTreeTilt {

    /**
     * 15ms     17.00%
     * 38.4MB   76.42%
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.val + sum(node.left) + sum(node.right);
    }


    /**
     * 官方题解
     */
    int tilt=0;

    public int findTilt2(TreeNode root) {
        traverse(root);

        return tilt;
    }

    public int traverse(TreeNode root) {
        if (root==null ) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);

        return left + right + root.val;
    }
}
