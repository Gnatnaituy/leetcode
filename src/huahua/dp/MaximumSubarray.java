package huahua.dp;

public class MaximumSubarray {

    /**
     * 1ms 96.70%
     * 38.7MB 89.07%
     */
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum += nums[i];
            currSum = Math.max(currSum, nums[i]);
            finalMax = Math.max(currSum, finalMax);
        }

        return finalMax;
    }
}
