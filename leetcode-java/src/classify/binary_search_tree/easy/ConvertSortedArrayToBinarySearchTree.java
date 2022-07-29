package classify.binary_search_tree.easy;

import tools.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    
    /**
     * 0ms      100.00%
     * 41.6MB   11.2%
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = construct(nums, left, mid - 1);
        node.right = construct(nums, mid + 1, right);

        return node;
    }
}