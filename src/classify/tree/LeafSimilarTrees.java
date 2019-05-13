package classify.tree;

import others.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    /**
     * 0ms 100.00%
     * 37MB 18.48%
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leavesRoot1 = leaves(root1);
        List<Integer> leavesRoot2 = leaves(root2);

        if (leavesRoot1 == leavesRoot2) return true;
        if (leavesRoot1.size() != leavesRoot2.size()) return false;

        for (int i = 0; i < leavesRoot1.size(); i++) {
            if (!leavesRoot1.get(i).equals(leavesRoot2.get(i)))
                return false;
        }

        return true;
    }

    private List<Integer> leaves(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        leavesHelper(res, root);

        return res;
    }

    private void leavesHelper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            res.add(root.val);
        leavesHelper(res, root.left);
        leavesHelper(res, root.right);
    }
}
