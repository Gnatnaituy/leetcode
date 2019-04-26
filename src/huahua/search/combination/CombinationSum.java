package huahua.search.combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /**
     * 3ms 92.83%
     * 38.5MB 71.56%
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates.length <= 0 || target <= 0)
            return res;

        backtrace(candidates, target, 0, res, new ArrayList<>());

        return res;
    }

    // 添加start参数去除结果中重复的List
    private void backtrace(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> list) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i, res, list);
            list.remove(list.size() - 1);
        }
    }
}
