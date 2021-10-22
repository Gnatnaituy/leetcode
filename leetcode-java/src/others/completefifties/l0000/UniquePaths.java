package others.completefifties.l0000;

public class UniquePaths {

    /**
     * 62. Unique Paths
     * https://leetcode-cn.com/problems/unique-paths/
     */

    // 递归法, 效率极低, 时间和空间复杂度均为O(2 ^ (m + n))
    // public int uniquePaths(int m, int n) {
    //     return m == 1 || n == 1 ? 1 : uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    // }

    public int uniquePaths(int m, int n) {
        /**
         * 到达一个点有两条路, 一条从上来, 一条从左来
         * 这是一个组合问题，直接计算C(m+n-2,m-1)即可
         * 时间复杂度为O(n)，空间复杂度O(1)
         * 计算过程如图所示
         * 1    1    1    1    1    1
         * 1    2    3    4    5    6
         * 1    3    6   10   15   21
         * 1    4   10   20   35   56
         */
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
}