package classify.graph;

public class NumberOfIslands {
    private int row;
    private int col;

    /**
     * 1ms 100.00%
     * 41.2MB 16.74%
     */
    public int numberIslands(char[][] grid) {
        int res = 0;
        row = grid.length;
        if (row == 0) return res;

        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i ,j);
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 将与grid[i][j]相连的所有'1'都改为'0'
     */
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1')
            return;

        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}
