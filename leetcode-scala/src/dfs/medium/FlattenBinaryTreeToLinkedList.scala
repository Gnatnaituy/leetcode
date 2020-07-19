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

    /**
     * 652 ms   33.33%
     * 50.9MB   100.00%
     * 将左子树插入到右子树的地方
     * 将原来的右子树接到左子树的最右边节点
     * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     * @param root
     */
    def flatten2(root: TreeNode): Unit = {
        var cur = root

        while (cur != null) {
            // 如果左子树为null 直接跳过
            if (cur.left == null) {
                cur = cur.right
            } else {
                //找到左子树最右的节点
                var pre = cur.left
                while (pre.right != null) {
                    pre = pre.right
                }
                // 将原来的右子树连接到左子树最右节点的右子树
                pre.right = cur.right
                // 将左子树挪到右子树
                cur.right = cur.left
                cur.left = null
                cur = cur.right
            }
        }
    }
}
