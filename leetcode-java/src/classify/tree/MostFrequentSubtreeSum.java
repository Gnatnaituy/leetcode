package classify.tree;

import tools.TreeNode;

import java.util.*;

public class MostFrequentSubtreeSum {

    /**
     * 44ms 10.86%
     * 40.8MB 28.68%
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        final Map<Integer, Integer> occurMap = new HashMap<>();
        sum(root, occurMap);
        int maxOccurs = occurMap.values().stream().max(Comparator.naturalOrder()).orElse(-1);

        return occurMap.entrySet().stream().filter(e -> e.getValue() == maxOccurs).mapToInt(Map.Entry::getKey).toArray();
    }

    private int sum(TreeNode root, Map<Integer, Integer> occurMap) {
        if (root == null) return 0;

        int sum = root.val + sum(root.left, occurMap) + sum(root.right, occurMap);
        occurMap.compute(sum, (k, v) -> v == null ? 1 : v + 1);

        return sum;
    }


    /**
     * 6ms 78.72%
     * 40.2MB 66.91%
     */
    private Map<Integer, Integer> freq;

    public int[] findFrequentTreeSum2(TreeNode root) {
        freq = new HashMap<>();

        helper(root);

        int max = Integer.MIN_VALUE;

        for (int key : freq.keySet()) {
            if (freq.get(key) >= max) {
                max = freq.get(key);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int key : freq.keySet()) {
            if (freq.get(key) == max) {
                list.add(key);
            }
        }

        int size = list.size();
        int[] ans = new int[size];

        for (int i = 0; i < size; i++)
            ans[i] = list.get(i);

        return max == Integer.MIN_VALUE ? new int[]{} : ans;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int sum = root.val + left + right;
        if (!freq.containsKey(sum)) {
            freq.put(sum, 1);
        }
        freq.put(sum, freq.get(sum) + 1);

        return sum;
    }
}
