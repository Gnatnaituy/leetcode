package classify.tree;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @package java.discovery.binary.tree
 * @author 余天堂
 * @create 2020/5/22 15:53
 * @description BinaryTreePostOrderTraversal
 */
public class BinaryTreePostOrderTraversal {

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root.left == null && root.right == null) {

            }

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
