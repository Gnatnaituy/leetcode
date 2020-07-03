package classify.graph;

import java.util.HashMap;
import java.util.Map;

public class CopyListWothRandomPointer {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    /**
     * 1ms 81.32%
     * 34.4MB 100.00%
     */
    public Node copyRandomList(Node head) {

        return clone(new HashMap<>(), head);
    }

    private Node clone(Map<Node, Node> map, Node node) {
        if (node == null) return null;

         // 已经遍历过的节点不再遍历
        if (map.containsKey(node)) return map.get(node);

        Node cloneNode = new Node();
        cloneNode.val = node.val;
        map.put(node, cloneNode);
        cloneNode.next = clone(map, node.next);
        cloneNode.random = clone(map, node.random);

        return cloneNode;
    }
}
