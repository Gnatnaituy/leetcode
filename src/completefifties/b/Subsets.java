package completefifties.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    /**
     * 4ms 15.93%
     * 38.1m 0.73%
     */
    private List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return new ArrayList<>();

        if (nums.length == 0) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            res.add(list);
            return res;
        }

        // The subsets that include nums[nums.length - 1]
        List<List<Integer>> res = subsets(Arrays.copyOfRange(nums, 0, nums.length - 1));
        for (List<Integer> list : res) {
            list.add(nums[nums.length - 1]);
        }

        // The subsets that didn't include nums[nums.length - 1]
        res.addAll(subsets(Arrays.copyOfRange(nums, 0, nums.length - 1)));

        return res;
    }

    /**
     * 2ms
     */
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsets2(int[] nums) {
        dfs(new ArrayList<>(), nums, 0);
        return ret;
    }

    private void dfs(List<Integer> list, int[] nums, int i) {
        if (i == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            //使用j+1,避免出现重复
            dfs(list, nums, j + 1);
            list.remove(list.size() - 1);
        }
        dfs(list, nums, nums.length);
    }


    /**
     * 1ms
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        res.add(new ArrayList<>());
        dfs(0, nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(int curIdx, int[] nums, List<List<Integer>> res, List<Integer> l) {
        for (int i = curIdx; i < nums.length; i++) {
            l.add(nums[i]);
            res.add(new ArrayList<>(l));
            dfs(i + 1, nums, res, l);
            l.remove(l.size() - 1);
        }
    }
}
