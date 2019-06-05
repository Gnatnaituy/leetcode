package java.completefifties.l0000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    /**
     * 3ms 94.66%
     * 37.3MB 83.54%
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        List<Integer> level = new ArrayList<>();
        res.add(new ArrayList<>(level));

        dfs(res, level, 0, nums);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> level, int depth, int[] nums) {
        for (int i = depth; i < nums.length; i++) {
            if (i > depth && nums[i - 1] == nums[i])
                continue;

            level.add(nums[i]);
            res.add(new ArrayList<>(level));
            dfs(res, level, i + 1, nums);
            level.remove(level.size() - 1);
        }
    }
}
