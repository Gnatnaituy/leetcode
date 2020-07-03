package others.discover.algorithm.elementary.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 给定一个整数数组 nums 和一个目标值 target
     * 请你在该数组中找出和为目标值的那两个整数, 并返回他们的数组下标
     * 你可以假设每种输入只会对应一个答案. 但是, 你不能重复利用这个数组中同样的元素
     */
    public int[] twoSum(int[] nums, int target) {
        /*
        10ms 80.75%
        最快的也是相同的解法
         */
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            } else {
                map.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
