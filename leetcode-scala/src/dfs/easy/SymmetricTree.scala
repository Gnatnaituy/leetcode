package dfs.easy

import tools.TreeNode

object SymmetricTree {

    /**
     * 580 ms   65.91%
     * 51.5 MB  100.00%
     * @param root
     * @return
     */
    def isSymmetric(root: TreeNode): Boolean = {
        if (root == null) return true

        def isSymmetricTree(left: TreeNode, right: TreeNode): Boolean = {
            if (left == null && right == null) return true
            if (left == null) return false
            if (right == null) return false
            if (left.value != right.value) return false
            isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left)
        }

        isSymmetricTree(root.left, root.right)
    }
}
