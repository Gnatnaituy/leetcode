package java.completefifties.l0000;

public class MinimumPathSum {

    /**
     * 64. Minimum Path Sum
     * https://leetcode-cn.com/problems/minimum-path-sum/
     * 这道题和前面两道思路是一样的
     */
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int j = 1; j < grid.length; j++) {
            grid[j][0] += grid[j - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}