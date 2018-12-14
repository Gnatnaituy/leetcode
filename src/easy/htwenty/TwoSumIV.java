package easy.htwenty;

import tools.TreeNode;

import java.util.HashSet;

/**
 * 653 Two Sum IV -- input is a BST
 *
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */

public class TwoSumIV {

    private boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hashset = new HashSet<>();
        return preOrder(root, hashset, k);
    }

    private boolean preOrder(TreeNode root, HashSet<Integer> hashset, int k){
        if(root == null)
            return false;
        if(hashset.contains(k - root.val))
            return true;
        hashset.add(root.val);
        return preOrder(root.left, hashset, k) || preOrder(root.right, hashset, k);
    }
}
