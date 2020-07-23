package dfs.medium

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/23 10:36
 * @Description NumberOfIslands
 */
object NumberOfIslands {

    /**
     * 624ms    80.00%
     * 52.4ms   100.00%
     * 每次遇到一块陆地，岛屿数量+1，并将所有与之相邻的陆地置为水
     * @param grid
     * @return
     */
    def numIslands(grid: Array[Array[Char]]): Int = {

        def dfs(row: Int, col: Int): Unit = {
            if (row < 0 || col < 0 || row > grid.length || col > grid(row).length || grid(row)(col) == '0') return
            grid(row)(col) = '0'
            dfs(row - 1, col)
            dfs(row + 1, col)
            dfs(row, col - 1)
            dfs(row, col + 1)
        }


        if (grid == null || grid.length == 0 || grid(0).length == 0)
            return 0

        var res = 0
        for (row <- Array.range(0, grid.length)) {
            for (col <- Array.range(0, grid(row).length)) {
                if (grid(row)(col) == '1') {
                    res += 1
                    dfs(row, col)
                }
            }
        }

        res
    }
}
