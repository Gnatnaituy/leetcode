package classify.dp;

public class MaximalSquare {

    /**
     * 4ms 98.27%
     * 44MB 5.23%
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        // dp[i][j]意为：以matrix[i - 1][j - 1]为某一正方形的左下角端点时可以得到的最大正方形边长
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        // max记录最大正方形的边长
        int max = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // dp[i][j]所在点的正方形的最大边长由←, ↖, ↑的最小值决定
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;
    }
}
