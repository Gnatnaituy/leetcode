package dfs.medium

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/10 21:07
 * @Description FlattenAMultilevelDoublyLinkedList
 */
object FlattenAMultilevelDoublyLinkedList {

    class Node(var _value: Int) {
        var value: Int = _value
        var prev: Node = _
        var next: Node = _
        var child: Node = _
    }

    /**
     * 516ms    100.00%
     * 49.3MB   100.00%
     * @param head
     * @return
     */
    def flatten(head: Node): Node = {
        if (head == null) return head

        val pseudoHead = new Node(0)
        flattenDfs(pseudoHead, head)
        pseudoHead.next.prev = null

        pseudoHead.next
    }

    def flattenDfs(prev: Node, cur: Node): Node = {
        if (cur == null) return prev
        cur.prev = prev
        prev.next = cur

        val tempNext = cur.next
        val tail = flattenDfs(cur, cur.child)
        cur.child = null

        flattenDfs(tail, tempNext)
    }
}
