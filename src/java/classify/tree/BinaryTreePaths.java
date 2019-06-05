package java.classify.tree;

import java.others.tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    List<String> res = new LinkedList<>();

    /**
     * 1ms 100.00%
     * 37.7MB 62.66%
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) helper(root, new StringBuilder());

        return res;
    }

    private void helper(TreeNode root, StringBuilder path) {
        if (root.left == null && root.right == null) {
            res.add(path.append(root.val).toString());
            return;
        }

        if (root.left != null) helper(root.left, new StringBuilder(path).append(root.val).append("->"));
        if (root.right != null) helper(root.right, new StringBuilder(path).append(root.val).append("->"));
    }
}
