package classify.recursion;

import tools.TreeNode;

/**
 * @author yutiantang
 * @create 2021/3/31 22:09
 */
public class MaximunDepthOfBinaryTree {

    /**
     * 0ms      100.00%
     * 38.2MB   86.34%
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
