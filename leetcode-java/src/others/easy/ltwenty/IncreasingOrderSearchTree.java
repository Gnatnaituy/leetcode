package others.easy.ltwenty;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 897 Increasing Order Search Tree
 */

public class IncreasingOrderSearchTree {
    private List<Integer> vals = new ArrayList<>();

    private TreeNode increasingBST(TreeNode root) {
        inOrder(root, vals);
        TreeNode res = new TreeNode(vals.get(0));
        TreeNode cur = res;
        for (int i = 1; i < vals.size(); i++) {
            cur.right = new TreeNode(vals.get(i));
            cur = cur.right;
        }

        return res;
    }

    private void inOrder(TreeNode root, List<Integer> vals) {
        if (root != null) {
            inOrder(root.left, vals);
            vals.add(root.val);
            inOrder(root.right, vals);
        }
    }
}
