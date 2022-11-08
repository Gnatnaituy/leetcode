package classify.dp.medium;

public class MaximumSubarray {

    /**
     * O(n)     1ms     100.00%
     * O(1)     50.2MB  95.24%
     */
    public int maxSubArray(int[] nums) {
        int index = 0, max = Integer.MIN_VALUE, cur = 0;
        while (index < nums.length) {
            cur += nums[index++];
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }

        return max;
    }
}
