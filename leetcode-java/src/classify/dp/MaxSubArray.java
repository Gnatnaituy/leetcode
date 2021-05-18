package classify.dp;

/**
 * @author yutiantang
 * @create 2021/5/18 23:09
 */
public class MaxSubArray {

    /**
     * 1ms      98.44%
     * 45.1MB   26.70%
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
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
