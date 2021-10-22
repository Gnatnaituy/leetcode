package classify.tree;

import tools.TreeNode;

import java.util.ArrayList;
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

    /**
     * 迭代法
     * Not completed!
     */
    public boolean isSymmetric3(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        LinkedList<TreeNode> list = new LinkedList<>();

        list.add(root);
        while (!list.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = list.size();

            // Add the node values at the same depth to the level list
            while (size > 0) {
                TreeNode node = list.removeFirst();
                if (node.left != null) list.add(node.left);
                // else list.add(new TreeNode(Integer.MAX_VALUE));
                // Try to solve [1,2,2,null,3,null,3], but getting stuck in an infinite loop
                if (node.right != null) list.add(node.right);
                level.add(node.val);
                size--;
            }

            // Judge if the level list is symmetric
            // return false if the level list is not symmetric
            int start = 0, end = level.size() - 1;
            while (start < end) {
                if (!level.get(start).equals(level.get(end)))
                    return false;
                start++;
                end--;
            }
        }

        return true;
    }
}
