package classify.dp;

/**
 * @author yutiantang
 * @create 2021/5/13 23:19
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    /**
     * 15ms     68.42%
     * 37.3MB   87.72%
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/solution/gong-shui-san-xie-xiang-jie-xian-xing-dp-m9q9/
     */
    int MOD = (int) 1e9 + 7;
    public int numWays(int steps, int len) {
        int max = Math.min(steps / 2, len - 1);
        int[][] dp = new int[steps + 1][max + 1];
        dp[steps][0] = 1;
        for (int step = steps - 1; step >= 0; step--) {
            for (int pos = 0; pos <= max; pos++) {
                dp[step][pos] = (dp[step][pos] + dp[step + 1][pos]) % MOD;
                if (pos - 1 >= 0) {
                    dp[step][pos] = (dp[step][pos] + dp[step + 1][pos - 1]) % MOD;
                }
                if (pos + 1 <= max) {
                    dp[step][pos] = (dp[step][pos] + dp[step + 1][pos + 1]) % MOD;
                }
            }
        }

        return dp[0][0];
    }

    /**
     * 14ms     78.07%
     * 37.7MB   80.70%
     * @param steps
     * @param len
     * @return
     */
    public int numWays2(int steps, int len) {
        int max = Math.min(steps / 2, len - 1);
        int[][] dp = new int[steps + 1][max + 1];
        dp[steps][0] = 1;
        for (int step = steps - 1; step >= 0; step--) {
            // 减少「无效状态」的计算
            int edge = Math.min(step, max);
            for (int pos = 0; pos <= edge; pos++) {
                dp[step][pos] = (dp[step][pos] + dp[step + 1][pos]) % MOD;
                if (pos - 1 >= 0) {
                    dp[step][pos] = (dp[step][pos] + dp[step + 1][pos - 1]) % MOD;
                }
                if (pos + 1 <= max) {
                    dp[step][pos] = (dp[step][pos] + dp[step + 1][pos + 1]) % MOD;
                }
            }
        }

        return dp[0][0];
    }

    /**
     * 10ms     98.25%
     * 34.9MB   100.00%
     * @param steps
     * @param len
     * @return
     */
    public int numWays3(int steps, int len) {
        int max = Math.min(steps / 2, len - 1);
        int[][] dp = new int[2][max + 1];
        // 利用 f[i][x] 依赖于 f[i + 1][y]，使用「滚动数组」优化空间复杂度
        dp[steps & 1][0] = 1;
        for (int step = steps - 1; step >= 0; step--) {
            // 减少「无效状态」的计算
            int edge = Math.min(step, max);
            int cur = step & 1, prev = (step + 1) & 1;
            for (int pos = 0; pos <= edge; pos++) {
                dp[cur][pos] = dp[prev][pos] % MOD;
                if (pos - 1 >= 0) {
                    dp[cur][pos] = (dp[cur][pos] + dp[prev][pos - 1]) % MOD;
                }
                if (pos + 1 <= max) {
                    dp[cur][pos] = (dp[cur][pos] + dp[prev][pos + 1]) % MOD;
                }
            }
        }

        return dp[0][0];
    }
}
