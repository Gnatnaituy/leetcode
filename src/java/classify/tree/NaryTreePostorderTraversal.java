package java.classify.tree;

import java.others.tools.NNode;

import java.util.*;

public class NaryTreePostorderTraversal {
    private List<Integer> res = new ArrayList<>();

    /**
     * Recursive solution
     * 1ms 100.00%
     * 46.6MB 81.60%
     */
    public List<Integer> postorder(NNode root) {
        if (root == null) return res;

        for (NNode node : root.children) {
            postorder(node);
        }
        res.add(root.val);

        return res;
    }

    /**
     * Iterative solution
     * 3ms 54.74%
     * 46.6MB 81.01%
     */
    public List<Integer> postorder2(NNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<NNode> stack = new LinkedList<>();
        stack.addLast(root);

        while(!stack.isEmpty()) {
            root = stack.removeLast();
            list.add(root.val);
            stack.addAll(root.children);
        }

        Collections.reverse(list);

        return list;
    }
}
