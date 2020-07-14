package dfs.easy

import tools.TreeNode

/**
 * @package dfs
 * @author 余天堂
 * @create 2020/7/12 23:33
 * @description BinaryTreePaths
 */
object BinaryTreePaths {

    /**
     * 680 ms   20.00%
     * 51.4 MB  100.00%
     * @param root
     * @return
     */
    def binaryTreePaths(root: TreeNode): List[String] = {
        if (root == null) return Nil
        if (root.left == null && root.right == null) return List(root.value.toString)
        val paths: List[String] = binaryTreePaths(root.left) ::: binaryTreePaths(root.right)

        paths.map(x => root.value.toString + "->" + x)
    }

}
