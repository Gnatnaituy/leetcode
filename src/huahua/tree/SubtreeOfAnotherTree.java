package huahua.tree;

import others.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {

    /**
     * Iterative
     * 6ms 93.74%
     * 40.7MB 91.38%
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == t.val && isSameTree(node, t)) return true;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return false;
    }

    /**
     * Recursive
     * 6ms 93.74%
     * 41MB 90.86%
     */
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSameTree(s, t)) return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
