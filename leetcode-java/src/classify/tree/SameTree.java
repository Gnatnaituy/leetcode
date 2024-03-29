package classify.tree;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    /**
     * Recursive solution
     * 0ms 100.00%
     * 35.6MB 96.28%
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * Iterative solution
     * 0ms 100.00%
     * 35.6MB 96.28%
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null || left.val != right.val)
                return false;
            queue.add(left.left);
            queue.add(right.left);
            queue.add(left.right);
            queue.add(right.right);
        }

        return true;
    }

    private boolean isSameTree3(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.left == null && p.right == null && q.left == null && q.right == null && p.val == q.val)
            return true;
        else if (p.right == null && q.right == null && p.left != null && q.left != null && p.val == q.val)
            return isSameTree3(p.left, q.left);
        else if (p.left == null && q.left == null && p.right != null && q.right != null && p.val == q.val)
            return isSameTree3(p.right, q.right);
        else if (p.left != null && q.left != null && p.right != null && q.right != null && p.val == q.val)
            return isSameTree3(p.left, q.left) && isSameTree3(p.right, q.right);
        else
            return false;
    }
}
