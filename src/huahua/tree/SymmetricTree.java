package huahua.tree;

import others.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    /**
     * Recursive solution
     * 0ms 100.00%
     * 39MB 27.03%
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetricTree(root.left, root.right);
    }

    private boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }

    /**
     * Iterative solution
     * 1ms 73.13%
     * 36.8MB 92.67%
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }

        return true;
    }
}
