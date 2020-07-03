package classify.tree;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 1ms 99.96%
     * 39.4MB 71.80%
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(new ArrayList<>(), root, sum);

        return res;
    }

    private void helper(List<Integer> level, TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && sum == root.val) {
            level.add(root.val);
            res.add(new ArrayList<>(level));
            level.remove(level.size() - 1);
            return;
        }

        level.add(root.val);
        helper(level, root.left, sum - root.val);
        helper(level, root.right, sum - root.val);
        level.remove(level.size() - 1);
    }
}
