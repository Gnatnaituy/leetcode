package dfs.easy

import tools.Node

object MaximumDepthOfNaryTree {

    /**
     * 872 ms   33.33%
     * 50.9 MB  100.00%
     *
     * @param root
     * @return
     */
    def maxDepth(root: Node): Int = {
        if (root == null) return 0
        if (root.children.isEmpty) return 1

        var maxDep = 1
        for (neighbor <- root.children) {
            maxDep = Math.max(maxDep, maxDepth(neighbor) + 1)
        }

        maxDep
    }

    /**
     * 800 ms   66.67%
     * 50.9 MB  100.00%
     * @param root
     * @return
     */
    def maxDepth2(root: Node): Int = {
        if (root == null) return 0
        if (root.children.isEmpty) return 1

        root.children.map(maxDepth).max + 1
    }

}
