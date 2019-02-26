package discover.algorithm.elementary.tree;


import tools.TreeNode;

import java.util.Arrays;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
 */
public class ConvertSortedArrayToBST {

    /**
     * 1ms 97.11%
     * 26.8m 16.20%
     * 搜索二叉树的中序遍历为有序数组
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);

        int mid = nums.length / 2;

        TreeNode res = new TreeNode(nums[mid]);
        res.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        res.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return res;
    }
}