package classify.search.combination;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 1ms 83.62%
     * 38MB 14.50%
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length < 1) return res;

        for (int len = 0; len <= nums.length; len++) {
            backtrace(new ArrayList<>(), nums, len, 0);
        }

        return res;
    }

    private void backtrace(List<Integer> list, int[] nums, int len, int start) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(list, nums, len, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
