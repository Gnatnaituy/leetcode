package huahua.dp;

public class KnightProbilityInChessboard {

    private int[][] direction = new int[][]{{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public double knigthProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];

        for (double[] row : dp) {
            for (int i = 0; i < row.length; i++) {
                row[i] = 1.0;
            }
        }

        for (int i = 0; i <= K; i++) {
            dp = buildDP(dp, N);
        }

        return dp[r][c] / Math.pow(8.0, K);
    }

    private double[][] buildDP(double[][] dp, int N) {
        double[][] temp = new double[N][N];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = init(dp, N, i, j);
            }
        }

        return temp;
    }

    private double init(double[][] dp, int N, int i, int j) {
        double res = 0;

        if (i + 1 < N && j + 2 < N)
            res += dp[i + 1][j + 2];
        if (i + 1 < N && j - 2 >= 0)
            res += dp[i + 1][j - 2];
        if (i - 1 >= 0 && j + 2 < N)
            res += dp[i - 1][j + 2];
        if (i - 1 >= 0 && j - 2 >= 0)
            res += dp[i - 1][j - 2];
        if (i + 2 < N && j + 1 < N)
            res += dp[i + 2][j + 1];
        if (i + 2 < N && j - 1 >= 0)
            res += dp[i + 2][j - 1];
        if (i - 2 >= 0 && j + 1 < N)
            res += dp[i - 2][j + 1];
        if (i - 2 >= 0 && j - 1 >= 0)
            res += dp[i - 2][j - 1];

        return res;
    }

    public double knightProbability(int N, int K, int r, int c) {
        double[][] prevWays = new double[N][N];
        prevWays[r][c] = 1;
        double res = 0;

        for (int k = 1; k <= K; ++k) {
            double[][] ways = new double[N][N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    for (int[] dir : direction) {
                        int oldR = i - dir[0];
                        int oldC = j - dir[1];
                        if (oldR >= 0 && oldC >= 0 && oldR < N && oldC < N) {
                            ways[i][j] += (prevWays[oldR][oldC] / 8.0);
                        }
                    }
                }
            }
            prevWays = ways;
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                res += prevWays[i][j];
            }
        }

        return res;
    }
}
