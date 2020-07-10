package dfs

import tools.TreeNode

object SameTree {

    /**
     * 544 ms   56.25%
     * 50.5 MB  100.00%
     * @param p
     * @param q
     * @return
     */
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
        if (p == null) return q == null
        if (q == null) return p == null
        if (p.value != q.value) return false
        isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

}
