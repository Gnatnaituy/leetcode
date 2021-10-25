package classify.dp;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
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

    /**
     * 1ms      98.44%
     * 45.1MB   26.70%
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int fast = 0, res = Integer.MIN_VALUE, cur = 0;
        while (fast < nums.length) {
            cur += nums[fast++];
            res = Math.max(res, cur);
            if (cur < 0) {
                cur = 0;
            }
        }

        return res;
    }
}
