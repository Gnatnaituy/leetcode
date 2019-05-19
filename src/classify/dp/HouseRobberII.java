package classify.dp;

public class HouseRobberII {

    /**
     * 0ms 100.00%
     * 35.6MB 94.44%
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int preResult1 = 0; // 0至len - 2 dp[i - 2]
        int preResult2 = 0; // 1至len - 1 dp[i - 1]

        int curResult1 = nums[0];
        int curResult2 = nums[1];

        for (int i = 1; i < nums.length; i++) {
            // 排除最后一个 情况一
            if (i <= nums.length - 2) {
                int tempCur1 = Math.max(preResult1 + nums[i], curResult1);
                preResult1 = curResult1;
                curResult1 = tempCur1;
            }

            // 排除第一个  情况二
            if (i >= 2) {
                int tempCur2 = Math.max(preResult2 + nums[i], curResult2);
                preResult2 = curResult2;
                curResult2 = tempCur2;
            }
        }

        return Math.max(curResult1, curResult2);
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int first, int last) {
        int pre2 = 0, pre1 = 0;

        for (int i = first; i <= last; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }
}
