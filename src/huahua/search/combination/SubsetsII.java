package huahua.search.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 1ms 100.00%
     * 38MB 59.15%
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length < 1) return res;

        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backtrace(new ArrayList<>(), nums, i, 0);
        }

        return res;
    }

    private void backtrace(List<Integer> list, int[] nums, int len, int start) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            backtrace(list, nums, len, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
