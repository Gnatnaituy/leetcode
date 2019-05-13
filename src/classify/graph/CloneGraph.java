package classify.graph;

import others.tools.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    /**
     * 2ms 68.99%
     * 34.6MB 100.00%
     * Depth First solution
     */
    public GraphNode cloneGraph(GraphNode node) {
        return clone(node, new HashMap<>());
    }

    private GraphNode clone(GraphNode node, Map<GraphNode, GraphNode> store) {
        if (node == null) return null;

        if (store.containsKey(node)) {
            return store.get(node);
        }

        GraphNode cloneNode = new GraphNode();
        cloneNode.val = node.val;
        store.put(node, cloneNode);

        if (node.neighbors == null) return cloneNode;

        List<GraphNode> neighbors = new ArrayList<>();
        for (GraphNode neighbor : node.neighbors) {
            neighbors.add(clone(neighbor, store));
        }
        cloneNode.neighbors = neighbors;

        return cloneNode;
    }
}
