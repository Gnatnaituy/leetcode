package dfs.easy

import tools.TreeNode

object MinimumDepthOfBinaryTree {

    /**
     * 712 ms   11.11%
     * 51.6 MB  100.00%
     * @param root
     * @return
     */
    def minDepth(root: TreeNode): Int = {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1
        if (root.left == null) return minDepth(root.right) + 1
        if (root.right == null) return minDepth(root.left) + 1
        Math.min(minDepth(root.left), minDepth(root.right)) + 1
    }
}
