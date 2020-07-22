package dfs.medium

import scala.collection.mutable

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/21 23:08
 * @Description CloneGraph
 */
object CloneGraph {

    class Node(var _value: Int) {
        var value: Int = _value
        var neighbors: List[Node] = List()
    }

    val visited: mutable.Map[Node, Node] = mutable.Map()

    /**
     * 616ms    100.00%
     * 51.7MB   100.00%
     * DFS
     * @param graph
     * @return
     */
    def cloneGraph(graph: Node): Node = {
        if (graph == null) return graph
        if (visited.contains(graph)) return visited(graph)

        val clonedNode = new Node(graph.value)
        visited.addOne(graph -> clonedNode)
        clonedNode.neighbors = graph.neighbors.map(cloneGraph)

        clonedNode
    }

    /**
     * 632ms    100.00%
     * 54.3MB   100.00%
     * BFS
     * @param graph
     * @return
     */
    def cloneGraphBFS(graph: Node): Node = {
        if (graph == null) return graph

        val visited: mutable.Map[Node, Node] = mutable.Map()
        val queue: mutable.Queue[Node] = mutable.Queue()
        visited(graph) = new Node(graph.value)
        queue.enqueue(graph)

        while (queue.nonEmpty) {
            val node = queue.dequeue()
            node.neighbors.map(o => {
                if (!visited.contains(o)) {
                    visited(o) = new Node(o.value)
                    queue.enqueue(o)
                }
                visited(node).neighbors :+= visited(o)
            })
        }

        visited(graph)
    }

    def main(args: Array[String]): Unit = {
        val node1 = new Node(1)
        val node2 = new Node(2)
        val node3 = new Node(3)
        val node4 = new Node(4)
        node1.neighbors = List(node2, node4)
        node2.neighbors = List(node1, node3)
        node3.neighbors = List(node2, node4)
        node4.neighbors = List(node1, node3)
        cloneGraphBFS(node1)
    }
}
