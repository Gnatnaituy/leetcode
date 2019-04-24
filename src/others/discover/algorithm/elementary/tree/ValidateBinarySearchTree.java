package others.discover.algorithm.elementary.tree;


import others.tools.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidateBinarySearchTree {
    private double last = -Double.MAX_VALUE;

    /**
     * 1ms 87.93%
     * 24.9MB 48.95%
     * 绝望就是 给了你代码 你也看不懂...
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }

        return false;
    }

    /**
     * 6ms 15.53%
     * 28.4m 17.72%
     * 搜索二叉树的中序遍历为升序
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<Integer> stack = new Stack<>();
        inOrder(root, stack);
        int pre = stack.pop();
        while (!stack.isEmpty()) {
            if (stack.peek() >= pre) return false;
            pre = stack.pop();
        }

        return true;
    }

    private void inOrder(TreeNode root, Stack<Integer> stack) {
        if (root == null) return;

        inOrder(root.left, stack);
        stack.add(root.val);
        inOrder(root.right, stack);
    }
}
