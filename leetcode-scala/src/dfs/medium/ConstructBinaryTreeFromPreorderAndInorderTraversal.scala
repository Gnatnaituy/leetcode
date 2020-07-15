package dfs.medium

import tools.TreeNode

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/15 20:42
 * @Description ConstructBinaryTreeFromPreorderAndInorderTraversal
 */
object ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 752 ms   85.71%
     * 93.4 MB  100.00%
     * 1. preorder的第一个元素为树的根结点
     * 2. 由根结点在inorder中找到根结点的位置 根结点左侧为左子树left 右侧为右子树right
     * 3. preorder中根结点往右left.length个元素为左子树 剩下的为右子树
     * 4. 1、2、3循环
     * @param preorder
     * @param inorder
     * @return
     */
    def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
        if (preorder == null || preorder.length == 0) return null
        val rootValue = preorder(0)
        val rootIndex = inorder.indexOf(rootValue)
        val root = new TreeNode(rootValue)
        root.left = buildTree(preorder.slice(1, rootIndex + 1), inorder.slice(0, rootIndex))
        root.right = buildTree(preorder.slice(rootIndex + 1, preorder.length), inorder.slice(rootIndex + 1, inorder.length))

        root
    }
}
