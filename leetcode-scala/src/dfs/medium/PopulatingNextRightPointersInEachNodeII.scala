package dfs.medium

import scala.collection.mutable

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/20 00:07
 * @Description PopulatingNextRightPointersInEachNodeII
 */
object PopulatingNextRightPointersInEachNodeII {

    class Node(var _value: Int) {
        var value: Int = _value
        var left: Node = _
        var right: Node = _
        var next: Node = _
    }

    /**
     * 600ms    25.00%
     * 53.4MB   100.00%
     * @param root
     * @return
     */
    def connect(root: Node): Node = {
        if (root == null) return null

        val head= root
        val queue1 =  mutable.Queue[Node]()
        val queue2 =  mutable.Queue[Node]()
        queue1.enqueue(root)
        while (queue1.nonEmpty) {
            val node = queue1.dequeue()
            if (node.left != null) queue2.enqueue(node.left)
            if (node.right != null) queue2.enqueue(node.right)
            node.next = if (queue1.isEmpty) null else queue1.head
            if (queue1.isEmpty) {
                queue1.enqueueAll(queue2.removeAll())
            }
        }

        head
    }

}
