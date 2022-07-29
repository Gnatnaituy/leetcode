package classify.binary_search_tree.easy;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumIV {

    /**
     * Preorder traversal + Hash
     * 2ms      95.08%
     * 41.8MB   62.28%
     */
    public boolean findTarget(TreeNode root, int k) {
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

    /**
     * Inorder traversal + Two pointers
     * 2ms      95.08%
     * 42.2MB   19.58%
     */
    private List<Integer> nums = new ArrayList<>();
    public boolean findTarget2(TreeNode root, int k) {
        inorderTraversal(root);
        return findValue(nums, k);
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left);
        nums.add(node.val);
        inorderTraversal(node.right);
    }

    private boolean findValue(List<Integer> nums, int value) {
        int left = 0, right = nums.size() - 1, curValue;
        while (left < right) {
            curValue = nums.get(left) + nums.get(right);
            if (curValue < value) {
                left++;
            } else if (curValue > value) {
                right--;
            } else {
                return true;
            }
        }

        return false;
    }
}
