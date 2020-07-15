package dfs.medium

import tools.TreeNode

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/15 21:45
 * @Description ConstructBinaryTreeFromInorderAndPostorderTraversal
 */
object ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * 788 ms   42.86%
     * 98.8 MB  100.00%
     * @param inorder
     * @param postorder
     * @return
     */
    def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
        if (postorder == null || postorder.length == 0) return null

        val rootVal = postorder(postorder.length - 1)
        val rootIndex = inorder.indexOf(rootVal)
        val root = new TreeNode(rootVal)
        root.left = buildTree(inorder.slice(0, rootIndex), postorder.slice(0, rootIndex))
        root.right = buildTree(inorder.slice(rootIndex + 1, inorder.length), postorder.slice(rootIndex, postorder.length - 1))

        root
    }
}
