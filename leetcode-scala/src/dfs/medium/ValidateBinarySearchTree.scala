package dfs.medium

import tools.TreeNode

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/15 00:02
 * @Description ValidateBinarySearchTree
 */
object ValidateBinarySearchTree {

    /**
     * 660 ms   94.74%
     * 52.7 MB  100.00%
     * 使用Long是因为测试用例卡Integer的边界值
     * @param root
     * @return
     */
    def isValidBST(root: TreeNode): Boolean = {

        def validate(node: TreeNode, min: Long, max: Long): Boolean = {
            if (node == null) return true
            if (node.value <= min || node.value >= max) return false
            validate(node.left, min, node.value) && validate(node.right, node.value, max)
        }

        validate(root, Long.MinValue, Long.MaxValue)
    }

    /**
     * 搜索二叉树的中序遍历是升序
     * leetcode执行代码是正确的 但是提交过不了 本地结果是正确的
     * @param root
     * @return
     */
    var pre: Long = Long.MinValue
    def isValidBST2(root: TreeNode): Boolean = {
        if (root == null) return true

        def validate(node: TreeNode): Boolean = {
            if (pre >= node.value) return false
            pre = node.value.toLong
            true
        }

        isValidBST2(root.left) && validate(root) && isValidBST2(root.right)
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(0)
        print(isValidBST2(root))
    }

}
