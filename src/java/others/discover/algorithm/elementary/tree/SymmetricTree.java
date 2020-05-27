package java.others.discover.algorithm.elementary.tree;


import java.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分
 */
public class SymmetricTree {

    /**
     * 递归法
     * 15ms 61.07%
     * 31.6m 2.73%
     */
     public boolean isSymmetric(TreeNode root) {
         return root == null || isMirrorTreeNode(root.left, root.right);
     }

     private boolean isMirrorTreeNode(TreeNode left, TreeNode right) {
         if (left == null && right == null)
             return true;
         if (left == null || right == null || left.val != right.val)
             return false;
         return isMirrorTreeNode(left.left, right.right) && isMirrorTreeNode(left.right, right.left);
     }

    /**
     * 迭代法
     * Not completed!
     */
    public boolean isSymmetric2(TreeNode root) {
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
