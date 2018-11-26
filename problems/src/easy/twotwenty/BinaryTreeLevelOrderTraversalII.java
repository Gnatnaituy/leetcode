package easy.twotwenty;


import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 107 Binary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */

public class BinaryTreeLevelOrderTraversalII {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> levelStack = new Stack<>();
        List<Integer> level = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        if(root == null)
            return result;

        current.add(root);

        while(!current.isEmpty()){
            TreeNode node = current.remove();

            if(node.left != null)
                next.add(node.left);
            if(node.right != null)
                next.add(node.right);

            level.add(node.val);
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                levelStack.push(level);
                level = new ArrayList<>();
            }

        }

        while (!levelStack.isEmpty())
            result.add(levelStack.pop());

        return result;
    }
}
