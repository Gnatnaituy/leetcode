package java.others.easy.btwenty;


import java.others.tools.TreeNode;

import java.util.Arrays;

/**
 * 108 Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

public class ConvertSortedArrayToBST {

    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0]);

        TreeNode result = new TreeNode(nums[nums.length/2]);
        int[] left = Arrays.copyOfRange(nums, 0, nums.length/2);
        int[] right = Arrays.copyOfRange(nums, nums.length/2 + 1, nums.length);
        result.left = sortedArrayToBST(left);
        result.right = sortedArrayToBST(right);

        return result;
    }
}
