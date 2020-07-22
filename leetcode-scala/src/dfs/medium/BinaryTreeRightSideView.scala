package dfs.medium

import tools.TreeNode

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/22 22:37
 * @Description BinaryTreeRightSideView
 */
object BinaryTreeRightSideView {

    /**
     * 552ms    100.00%
     * 51.4MB   100.00%
     * @param root
     * @return
     */
    def rightSideView(root: TreeNode): List[Int] = {
        if (root == null) return List()
        val leftNodes = List(root.value) ::: rightSideView(root.left)
        var rightNodes = List(root.value) ::: rightSideView(root.right)

        if (leftNodes.length > rightNodes.length) {
            rightNodes :++= leftNodes.splitAt(rightNodes.length)._2
        }

        rightNodes
    }
}
