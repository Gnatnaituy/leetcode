package classify.dp;

/**
 * @author yutiantang
 * @create 2021/5/18 22:48
 */
public class ThreeStepsProblem {

    /**
     * 40ms     40.12%
     * 42.4MB   27.41%
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        int[] dp = new int[n < 4 ? 5 : n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
        }

        return dp[n];
    }
}
