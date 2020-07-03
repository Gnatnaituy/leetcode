package tree;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @package java.discovery.binary.tree
 * @author 余天堂
 * @create 2020/5/22 15:36
 * @description BinaryTreePreOrderTraversal
 */
public class BinaryTreePreOrderTraversal {

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return res;
    }
}
