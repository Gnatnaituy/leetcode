package java.others.tools;

import java.util.List;

public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {}

    public GraphNode(int _val, List<GraphNode> _neighbors) {
        this.val = _val;
        this.neighbors = _neighbors;
    }
}
