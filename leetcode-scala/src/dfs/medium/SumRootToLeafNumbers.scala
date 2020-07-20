package dfs.medium

import tools.TreeNode

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/20 15:15
 * @Description SumRootToLeafNumbers
 */
object SumRootToLeafNumbers {

    /**
     * 592 ms   50.00%
     * 51.1 MB  100.00%
     * @param root
     * @return
     */
    def sumNumbers(root: TreeNode): Int = {
        if (root == null) return 0
        dfs(root, 0)
    }

    def dfs(node: TreeNode, value: Int): Int = {
        if (node.left == null && node.right == null) return value * 10 + node.value
        Array(node.left, node.right).filter(_ != null).map(dfs(_, value * 10 + node.value)).sum
    }


    def main(args: Array[String]): Unit = {
        val root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(3)
        println(sumNumbers(root))
    }
}
