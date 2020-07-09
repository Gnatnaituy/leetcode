package dfs

import tools.TreeNode

object ConvertSortedArrayToBinarySearchTree {

    /**
     * 1152 ms    65.00%
     * 58.3 MB    100.00%
     * @param nums
     * @return
     */
    def sortedArrayToBST(nums: Array[Int]): TreeNode = {
        recursiveHelper(nums, 0, nums.length - 1)
    }

    def recursiveHelper(nums: Array[Int], start: Int, end: Int): TreeNode = {
        if (start > end) return null

        val mid = (start + end) >> 1
        val root = new TreeNode(nums(mid))
        root.left = recursiveHelper(nums, start, mid - 1)
        root.right = recursiveHelper(nums, mid + 1, end)

        root
    }

    def main(args: Array[String]): Unit = {
        val treeNode = sortedArrayToBST(Array.range(0, 10))
        print(treeNode.toString)
    }
}
