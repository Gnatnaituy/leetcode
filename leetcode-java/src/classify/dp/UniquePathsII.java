package classify.dp;

public class UniquePathsII {

    /**
     * 0ms      100.00%
     * 39.9MB   17.23%
     * T:O(mn)  S:O(mn) DP
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int high = obstacleGrid.length;
        int[][] roadCount = new int[high][width];

        for (int i = 0; i < width; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            roadCount[0][i] = 1;
        }
        for (int j = 0; j < high; j++) {
            if (obstacleGrid[j][0] == 1) {
                break;
            }
            roadCount[j][0] = 1;
        }
        for (int i = 1; i < high; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    roadCount[i][j] = 0;
                } else {
                    roadCount[i][j] = roadCount[i - 1][j] + roadCount[i][j - 1];
                }
            }
        }

        return roadCount[high - 1][width - 1];
    }

    /**
     * 0ms      100.00%
     * 39.6MB   57.37%
     * T:O(mn)  S:O(m)  DP
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
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
