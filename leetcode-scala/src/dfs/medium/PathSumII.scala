package dfs.medium

import tools.TreeNode

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/17 10:08
 * @Description PathSumII
 */
object PathSumII {

    var res = List[List[Int]]()

    /**
     * 600 ms   100.00%
     * 52.2 MB  100.00%
     * @param root
     * @param sum
     * @return
     */
    def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {

        if (root == null) return List()
        if (root.left == null && root.right == null && root.value == sum) return List(List(root.value))

        val resLeft = pathSum(root.left, sum - root.value)
        val resRight = pathSum(root.right, sum - root.value)

        resLeft.map(_.prepended(root.value)) ++: resRight.map(_.prepended(root.value))
    }
}
