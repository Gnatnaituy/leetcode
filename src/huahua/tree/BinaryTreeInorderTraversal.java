package huahua.tree;

import others.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    /**
     * Recursive Approach
     * T(n) = O(n)      0ms 100.00%
     * S(n) = O(log n)  36.1MB 75.34%
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root != null){
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }

    /**
     * Iterating method using Stack
     * T(n) = O(n)  0ms 100.00%
     * S(n) = O(n)  36.2MB 40.53%
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }
}
