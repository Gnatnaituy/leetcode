package classify.binary_search_tree.medium;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

public class BinarySearchTreeToGreaterSumTree {

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        helper(root, 0, values);

        values.forEach(o -> System.out.print(o + " "));
        return null;
    }

    private int helper(TreeNode node, int parentVal, List<Integer> values) {
        if (node == null) return 0;
        int rightVal = helper(node.right, parentVal, values);
        int value = node.val + rightVal + parentVal;
        int leftVal = helper(node.left, value, values);
        values.add(value);

        return node.val + leftVal + rightVal;
    }

    // private TreeNode construct(int upper, int lower, 0)

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        BinarySearchTreeToGreaterSumTree a = new BinarySearchTreeToGreaterSumTree();
        a.bstToGst(root);
    }
}
