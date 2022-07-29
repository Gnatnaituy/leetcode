package classify.binary_search_tree.easy;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

public class IncreasingOrderSearchTree {

    /**
     * 0ms      100.00%
     * 38.7MB   98.46%
     */
    private List<Integer> elements = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        TreeNode dummy = new TreeNode(0);
        TreeNode cur = dummy;
        for (int element : elements) {
            TreeNode node = new TreeNode(element);
            cur.right = node;
            cur = cur.right;
        }

        return dummy.right;
    }

    private void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        elements.add(node.val);
        if (node.right != null) {
            inOrder(node.right);
        }
    }


    /**
     * 0ms      100.00%
     * 39.2MB   30.52%
     */
    private TreeNode previous;
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        previous = dummy;
        inorder(root);

        return dummy.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        previous.right = node;
        node.left = null;
        previous = previous.right;

        inorder(node.right);
    }
}
