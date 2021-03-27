package classify.twopoints;

import java.util.*;

/**
 * @author yutiantang
 * @create 2021/3/27 1:39 PM
 */
public class TwoSum {

    /**
     * 先排序 再使用双指针
     * 人家要的是坐标 不是数值。。。。。。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }

    /**
     * 使用Map储存 差值-坐标 键值对
     * 0ms      100.00%
     * 38.3MB   96.64MB
     * @param nums
     * @param target
     * @return
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
