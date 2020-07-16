package dfs.medium

import tools.{ListNode, TreeNode}

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/16 10:24
 * @Description ConvertSortedListToBinarySearchTree
 */
object ConvertSortedListToBinarySearchTree {

    /**
     * 2744 ms  33.33%
     * 58 MB    100.00%
     * 将ListNode转为升序数组 再根据数组构建二叉搜索树
     * @param head
     * @return
     */
    def sortedListToBST(head: ListNode): TreeNode = {
        var elements = Array[Int]()
        var cur = head
        Iterator.continually(cur).takeWhile(_ != null).foreach(t => {
            elements :+= t.x
            cur = cur.next
        })

        def constructBSTFromArray(elements: Array[Int]): TreeNode = {
            if (elements == null || elements.length == 0) return null
            if (elements.length == 1) return new TreeNode(elements(0))

            val mid = elements.length / 2
            val root = new TreeNode(elements(mid))
            if (mid > 0) {
                root.left = constructBSTFromArray(elements.slice(0, mid))
            }
            if (mid < elements.length) {
                root.right = constructBSTFromArray(elements.slice(mid + 1, elements.length))
            }

            root
        }

        constructBSTFromArray(elements)
    }
}
