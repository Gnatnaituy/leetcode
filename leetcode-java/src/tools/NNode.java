package tools;

import java.util.List;

public class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val,List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
