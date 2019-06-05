package java.classify.dp;

public class PartitionEqualSubsetSum {

    /**
     * 12ms 64.61%
     * 35.4MB 98.88%
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int max = sum / 2;
        boolean[] dp = new boolean[max + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = max; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[max];
    }

    /**
     * 0ms 100.00%
     * 35.2MB 99.21%
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) return false;

        return helper(nums, nums.length - 1, sum / 2);
    }

    private boolean helper(int[] nums, int i, int sum) {
        if (sum == 0) {
            return true;
        } else if (i < 0 || sum < 0 || sum < nums[i]) {
            return false;
        } else {
            return helper(nums, i - 1, sum - nums[i]) || helper(nums, i - 1, sum);
        }
    }
}
