package dfs.easy

import tools.TreeNode

object BalancedBinaryTree {

    /**
     * 620 ms   72.22%
     * 51.6 MB  100.00%
     * @param root
     * @return
     */
    def isBalanced(root: TreeNode): Boolean = {
        if (root == null) return true
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false
        isBalanced(root.left) && isBalanced(root.right)
    }

    def maxDepth(root: TreeNode): Int = {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1
        Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }

}
