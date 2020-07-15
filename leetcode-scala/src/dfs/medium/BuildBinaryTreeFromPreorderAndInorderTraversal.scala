package dfs.medium

import tools.TreeNode

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/15 20:42
 * @Description BuildBinaryTreeFromPreorderAndInorderTraversal
 */
object BuildBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 752 ms   85.71%
     * 93.4 MB  100.00%
     * @param preorder
     * @param inorder
     * @return
     */
    def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
        if (preorder == null || preorder.length == 0) return null
        val rootValue = preorder(0)
        val root = new TreeNode(rootValue)
        val rootIndex = inorder.indexOf(rootValue)
        root.left = buildTree(preorder.slice(1, rootIndex + 1), inorder.slice(0, rootIndex))
        root.right = buildTree(preorder.slice(rootIndex + 1, preorder.length), inorder.slice(rootIndex + 1, inorder.length))

        root
    }
}
