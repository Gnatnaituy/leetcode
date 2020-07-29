package dfs.medium

import tools.TreeNode

import scala.collection.mutable

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/29 22:51
 * @Description HouseRobberIII
 */
object HouseRobberIII {

    /**
     * 1420 ms  33.33%
     * 52.2MB   100.00%
     * @param root
     * @return
     */
    def rob(root: TreeNode): Int = {
        if (root == null) return 0

        var money = root.value
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right))
        }
        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right))
        }

        Math.max(money, rob(root.left) + rob(root.right))
    }

    /**
     * 688 ms   100.00%
     * 59.2MB   100.00%
     * @param root
     * @return
     */
    def rob2(root: TreeNode): Int = {
        helper(root, mutable.Map[TreeNode, Int]())
    }

    def helper(root: TreeNode, map: mutable.Map[TreeNode, Int]): Int = {
        if (root == null) return 0
        if (map.contains(root)) return map(root)

        var money = root.value
        if (root.left != null) {
            money += (helper(root.left.left, map) + helper(root.left.right, map))
        }
        if (root.right != null) {
            money += (helper(root.right.left, map) + helper(root.right.right, map))
        }
        val res = math.max(money, helper(root.left, map) + helper(root.right, map))
        map.addOne(root, res)

        res
    }

    /**
     * 688 ms   100.00%
     * 52.5MB   100.00%
     * @param root
     * @return
     */
    def rob3(root: TreeNode): Int = {
        val res = helper(root)
        math.max(res(0), res(1))
    }

    def helper(node: TreeNode): Array[Int] = {
        if (node == null) return Array.fill(2)(0)
        val res = Array.fill(2)(0)

        val left = helper(node.left)
        val right = helper(node.right)

        res(0) = math.max(left(0), left(1)) + math.max(right(0), right(1))
        res(1) = left(0) + right(0) + node.value

        res
    }
}
