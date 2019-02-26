package discover.algorithm.elementary.tree;

import tools.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点
 */

public class MaxDepthOfBinaryTree {

    /**
     * 递归法
     * 所有人用的都是递归法
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }
}
