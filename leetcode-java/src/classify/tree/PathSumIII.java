package classify.tree;

import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    /**
     * 24ms     10.56%%     O(n^2)
     * 41.4MB   26.46%      O(n)
     * DFS
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return pathSumFrom(root, targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    private int pathSumFrom(TreeNode node, long targetSum) {
        if (node == null) return 0;

        int cur = node.val == targetSum ? 1 : 0;
        int left = pathSumFrom(node.left, targetSum - node.val);
        int right = pathSumFrom(node.right, targetSum - node.val);
        return cur + left + right;
    }

    /**
     * 2ms     100.00%     O(n)
     * 41.1MB  62.59%      O(n)
     * Prefix Sum
     */
    public int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);

        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) return 0;

        curr += root.val;

        int res = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        res += dfs(root.left, prefix, curr, targetSum);
        res += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return res;
    }
}
