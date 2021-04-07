package classify.recursion;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yutiantang
 * @create 2021/4/6 22:43
 */
public class ValidateBinarySearchTree {


    /**
     * 中序遍历
     * 2ms      27.69%
     * 38.3MB   11.01%
     * @param root
     * @return
     */
    private final List<Integer> values = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        midTraversal(root);
        if (values.size() < 2) {
            return true;
        }
        long pre = Long.MIN_VALUE;
        for (int value : values) {
            if (pre >= value) {
                return false;
            }
            pre = value;
        }

        return true;
    }

    private void midTraversal(TreeNode node) {
        if (node.left != null) {
            midTraversal(node.left);
        }
        values.add(node.val);
        if (node.right != null) {
            midTraversal(node.right);
        }
    }

    /**
     * 官方题解
     * 0ms      100.00%
     * 37.8MB   95.43%
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
