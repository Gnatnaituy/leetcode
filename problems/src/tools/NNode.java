package tools;

import java.util.List;

public class NNode {
    public int val;
    public List<QuadNode> children;

    public NNode() {}

    public NNode(int _val,List<QuadNode> _children) {
        val = _val;
        children = _children;
    }
}
