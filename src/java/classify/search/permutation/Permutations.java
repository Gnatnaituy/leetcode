package java.classify.search.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 1ms 99.82%
     * 38.3MB 58.83%
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length < 1) return res;

        backtrace(new ArrayList<>(), nums, new boolean[nums.length]);

        return res;
    }

    private void backtrace(List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            list.add(nums[i]);
            used[i] = true;
            backtrace(list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
