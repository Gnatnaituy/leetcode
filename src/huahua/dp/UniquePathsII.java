package huahua.dp;

public class UniquePathsII {

    /**
     * 0ms 100.00%
     * 39.9MB 7.05%
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1)
            return 0;

        int[] dp = new int[col];

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[i] = 1;
        }

        for (int i = 1; i < row; i++) {
            dp[0] = (obstacleGrid[i][0] == 1 || dp[0] == 0) ? 0 : 1;
            for (int j = 1; j < col; j++) {
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j - 1] + dp[j];
            }
        }

        return dp[col - 1];
    }
}
