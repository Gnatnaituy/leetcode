package huahua.dp;

import java.util.Arrays;

public class UniquePaths {

    /**
     * 0ms 100.00%
     * 31.8MB 100.00%
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[m - 1];
    }
}
