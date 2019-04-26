package huahua.search.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 247ms 5.09%
     * 39.3MB 61.90%
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length < 1) return res;

        Arrays.sort(nums);
        backtrace(new ArrayList<>(), nums, new boolean[nums.length]);

        return res;
    }

    private void backtrace(List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            if (!res.contains(list))            // 时间杀手
                res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
//            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue; // 根据下面写法的改进
            list.add(nums[i]);
            used[i] = true;
            backtrace(list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    /**
     * 1ms
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isVisit = new boolean[nums.length];

        dfs(result, new ArrayList<>(), isVisit, nums);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> cur, boolean[] isVisit, int[] nums) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVisit[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !isVisit[i - 1]) {
                continue;
            }
            isVisit[i] = true;
            cur.add(nums[i]);
            dfs(result, cur, isVisit, nums);
            isVisit[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
