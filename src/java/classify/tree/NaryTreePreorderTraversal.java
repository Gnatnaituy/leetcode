package java.classify.tree;

import java.tools.NNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaryTreePreorderTraversal {

    /**
     * Iterative solution
     * 2ms 81.73%
     * 49.9MB 14.05%
     */
    public List<Integer> preorder(NNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<NNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.removeLast();
            res.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get((i)));
            }
        }

        return res;
    }

    /**
     * Recursive solution
     * 1ms 100.00%
     * 48MB 48.53%
     */
    private List<Integer> res2 = new ArrayList<>();
    private List<Integer> preorder2(NNode root) {
        if (root == null) return res2;

        res2.add(root.val);
        for (NNode node : root.children) {
            preorder2(node);
        }

        return res2;
    }
}
