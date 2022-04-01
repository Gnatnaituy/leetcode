package classify.twopointers;

import java.util.*;

/**
 * @author yutiantang
 * @create 2021/3/27 1:39 PM
 */
public class TwoSum {

    /**
     * 0ms      100.00%
     * 38.3MB   96.64MB
     * 使用Map储存 差值-坐标 键值对
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(target - nums[i])) {
                return new int[]{index.get(target - nums[i]), i};
            } else {
                index.put(nums[i], i);
            }
        }
        return null;
    }
}
