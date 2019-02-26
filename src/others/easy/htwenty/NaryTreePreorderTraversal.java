package others.easy.htwenty;

import tools.NNode;

import java.util.*;

/**
 * 589 N-ary Tree Preorder Traversal
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Note:
 * Recursive solution is trivial, could you do it iteratively?
 */

public class NaryTreePreorderTraversal {

    private List<Integer> preorder(NNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<NNode> stack = new Stack<>();
        if (root == null) return res;
        stack.add(root);
        while (!stack.isEmpty()) {
            NNode node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--)
                stack.add(node.children.get(i));
        }

        return res;

        // iter version
//        if (root == null) return res;
//        res.add(root.val);
//        for (NNode node : root.children)
//            preorder(node);
//
//        return res;
    }
}
