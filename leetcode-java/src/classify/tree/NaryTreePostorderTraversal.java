package classify.tree;

import tools.NNode;

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

        while (!stack.isEmpty()) {
            root = stack.removeLast();
            list.add(root.val);
            stack.addAll(root.children);
        }

        Collections.reverse(list);

        return list;
    }


    private List<Integer> postorder3(NNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<NNode> stack = new Stack<>();
        NNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            NNode curr = stack.peek();
            if ((curr.children.size() == 0) || (pre != null && (curr.children.contains(pre)))) {
                res.add(curr.val);
                pre = curr;
                stack.pop();
            } else {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    stack.push(curr.children.get(i));
                }
            }
        }

        return res;
    }
}
