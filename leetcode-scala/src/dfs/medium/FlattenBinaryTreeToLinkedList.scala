package dfs.medium

import tools.TreeNode

import scala.collection.mutable.ArrayBuffer

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/18 21:57
 * @Description FlattenBinaryTreeToLinkedList
 */
object FlattenBinaryTreeToLinkedList {

    /**
     * 624 ms   33.33%
     * 53MB     100.00%
     * 使用数组保存二叉树的前序遍历 再构建二叉树
     * 不满足题目 原地 的要求
     * @param root
     */
    def flatten(root: TreeNode): Unit = {
        if (root == null) return

        val elements = ArrayBuffer[TreeNode]()

        def dfs(node: TreeNode): Unit = {
            if (node == null) return
            elements += node
            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)
        var head = elements.remove(0)
        head.left = null
        while (elements.nonEmpty) {
            head.right = elements.remove(0)
            head.right.left = null
            head = head.right
        }
    }
}
