package classify.dp;

/**
 * @author yutiantang
 * @create 2021/10/26 16:27
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class MaxValuesOfPresents {

    /**
     * 3ms      41.82%
     * 41.1MB   42.34%
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int top = row == 0 ? 0 : grid[row - 1][col];
                int left = col == 0 ? 0 : grid[row][col - 1];
                grid[row][col] += Math.max(top, left);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
