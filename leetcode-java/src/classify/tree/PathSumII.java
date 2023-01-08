package classify.tree;

import tools.TreeNode;

import java.util.*;

public class PathSumII {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 1ms      99.96%      O(n)
     * 39.4MB   71.80%      O(1)
     * DFS
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(new ArrayList<>(), root, targetSum);

        return res;
    }

    private void helper(List<Integer> level, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && targetSum == root.val) {
            level.add(root.val);
            res.add(new ArrayList<>(level));
            level.remove(level.size() - 1);
            return;
        }

        level.add(root.val);
        helper(level, root.left, targetSum - root.val);
        helper(level, root.right, targetSum - root.val);
        level.remove(level.size() - 1);
    }
}
