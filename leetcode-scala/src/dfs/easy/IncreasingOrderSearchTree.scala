package dfs.easy

import tools.TreeNode

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/14 10:05
 * @Description IncreasingOrderSearchTree
 */
object IncreasingOrderSearchTree {

    /**
     * 560 ms   25.00%
     * 51.1MB   100.00%
     * @param root
     * @return
     */
    def increasingBST(root: TreeNode): TreeNode = {
        var values = List[Int]()

        def inorderTraversal(node: TreeNode): Unit = {
            if (node == null) return
            inorderTraversal(node.left)
            values :+= node.value
            inorderTraversal(node.right)
        }

        inorderTraversal(root)

        val res = new TreeNode(0)
        var cur = res
        for (value <- values) {
            cur.right = new TreeNode(value)
            cur = cur.right
        }

        res.right
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(3)
        val res = increasingBST(root)
    }

}
