package others.discover.algorithm.elementary.dynamicprogramming;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 */
public class MaxSubArray {

    /**
     * 14ms 74.80%
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }

        return res;
    }

    /**
     * 8ms
     */
    public int maxSubArray2(int[] nums) {
        int start = nums[nums.length - 1];
        int all = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (start < 0) {
                start = 0;
            }
            start += nums[i];
            if (start > all) {
                all = start;
            }
        }

        return all;
    }
}
