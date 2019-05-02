package huahua.dp;

public class MinimumPathSum {

    /**
     * 1ms 99.82%
     * 42.8MB 13.90%
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];

        dp[0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }

        for (int i = 1; i < row; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < col; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }

        return dp[col - 1];
    }
}
