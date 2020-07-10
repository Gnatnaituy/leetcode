package dfs

import tools.TreeNode

object PathSum {

    /**
     * 660 ms   23.08%
     * 52.1 MB  100.00%
     * @param root
     * @param sum
     * @return
     */
    def hasPathSum(root: TreeNode, sum: Int): Boolean = {
        if (root == null) return false
        if (root.left == null && root.right == null && root.value == sum) return true
        hasPathSum(root.right, sum - root.value) || hasPathSum(root.left, sum - root.value)
    }
}
