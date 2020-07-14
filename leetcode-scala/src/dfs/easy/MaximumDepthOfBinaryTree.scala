package dfs.easy

import tools.TreeNode

/**
 * @package dfs
 * @author 余天堂
 * @create 2020/7/13 20:16
 * @description MaximumDepthOfBinaryTree
 */
object MaximumDepthOfBinaryTree {

    /**
     * 600 ms   88.24%
     * 51.9 MB  100.00%
     * @param root
     * @return
     */
    def maxDepth(root: TreeNode): Int = {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1
        if (root.left == null) return maxDepth(root.right) + 1
        if (root.right == null) return maxDepth(root.left) + 1
        Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }

    /**
     * 672 ms   20.59%
     * 51.7 MB  100.00%
     * @param root
     * @return
     */
    def maxDepth2(root: TreeNode): Int = {
        if (root == null) return 0
        Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}
