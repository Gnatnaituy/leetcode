package classify.dp;

public class TargetSum {
    private int res = 0;

    /**
     * 409ms 15.12%
     * 33.3MB 100.00%
     */
    public int findTargetSumWays(int[] nums, int S) {
        dp(nums, 0, S);

        return res;
    }

    private void dp(int[] nums, int index, int S) {
        if (index == nums.length) {
            res = S == 0 ? res + 1 : res;
            return;
        }
        dp(nums, index + 1, S + nums[index]);
        dp(nums, index + 1, S - nums[index]);
    }

    /**
     * 2ms 98.02%
     * 33.8MB 99.97%
     *
     * The original problem statement is equivalent to:
     *      -> Find a subset of nums that need to be positive, and the rest of them negative,
     *         such that the sum is equal to target
     *
     * Let P be the positive subset and N be the negative subset
     * For example:
     * Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
     * Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]
     *
     * Then let's see how this can be converted to a subset sum problem:
     *
     *      ->                   sum(P) - sum(N) = target
     *      -> sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *      ->                        2 * sum(P) = target + sum(nums)
     *
     * So the original problem has been converted to a subset sum problem as follows:
     *      -> Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;

        return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (S + sum) >>> 1);
    }

    private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = s; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[s];
    }
}
