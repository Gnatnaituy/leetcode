package huahua.dp;

public class PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int k = i + j;
                dp[i][k] = Math.max(nums[i] - dp[i + 1][k], nums[k] - dp[i][k - 1]);
            }
        }

        return dp[0][len - 1] >= 0;
    }

    /**
     * For O(N) space
     * 0ms 100.00%
     * 33MB 100.00%
     */
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null) { return true; }
        int len = nums.length;
        if ((len & 1) == 0) { return true; }
        int[] dp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }

        return dp[len - 1] >= 0;
    }
}
