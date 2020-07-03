package classify.math;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    /**
     * 14ms 52.36%
     * 37.9MB 99.37%
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        int a = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int b = nums[0] * nums[1] * nums[len - 1];

        return a > b ? a : b;
    }
}
