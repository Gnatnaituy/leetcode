package huahua.graph;


public class MaxAreaOfIsland {
    private int row;
    private int col;
    private int area = 0;

    /**
     * 2ms 100.00%
     * 40.6MB 97.91%
     */
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        row = grid.length;
        if (row == 0) return res;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j);
                    res = Math.max(res, area);
                    area = 0;
                }
            }
        }

        return res;
    }

    private void helper(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1)
            return;

        area++;
        grid[i][j] = 0;
        helper(grid, i + 1, j);
        helper(grid, i - 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
    }
}
