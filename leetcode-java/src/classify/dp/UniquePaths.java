package classify.dp;

import java.util.Arrays;

public class UniquePaths {

    /**
     * 0ms      100.00%
     * 38.1MB   85.67%
     */
    public int uniquePaths(int m, int n) {
        int[][] road = new int[n][m];

        for (int i = 0; i < n; i++) {
            road[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            road[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                road[i][j] = road[i - 1][j] + road[i][j - 1];
            }
        }

        return road[n - 1][m - 1];
    }

    /**
     * 0ms      100.00%
     * 31.8MB   100.00%
     */
    public int uniquePaths2(int m, int n) {
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
