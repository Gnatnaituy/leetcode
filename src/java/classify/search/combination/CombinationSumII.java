package java.classify.search.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    /**
     * 18ms 16.73%
     * 38.8MB 62.87%
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
//        backtrace(candidates, target, res, new ArrayList<>(), 0);
        dfs(res, new ArrayList<>(), target, candidates, 0);
        return res;
    }

    private void backtrace(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int start) {
        if (target < 0) return;

        if (target == 0) {
            if (!res.contains(list)) res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrace(candidates, target - candidates[i], res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 2ms 100%
     * 37.6MB 85.64%
     */
    private void dfs(List<List<Integer>> res, List<Integer> temp, int target, int[] candidates, int i) {
        if (target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i; j < candidates.length && target >= candidates[j]; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;

            temp.add(candidates[j]);
            dfs(res, temp, target - candidates[j], candidates, j + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
