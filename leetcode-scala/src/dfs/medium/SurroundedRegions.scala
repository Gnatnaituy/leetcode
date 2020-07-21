package dfs.medium

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/20 22:33
 * @Description SurroundedRegions
 */
object SurroundedRegions {

    /**
     * 656ms    100.00%
     * 56.1MB   100.00%
     * dfs递归
     * @param board
     */
    def solve(board: Array[Array[Char]]): Unit = {
        if (board == null || board.length == 0) return

        val colLength = board.length
        val rowLength = board(0).length
        // 第一遍遍历，将所有边界上的O及与其相连的O设置为#
        for (col <- Array.range(0, colLength)) {
            for (row <- Array.range(0, rowLength)) {
                if ((col == 0 || col == colLength - 1 || row == 0 || row == rowLength - 1)
                    && board(col)(row) == 'O') {
                    dfs(col, row)
                }
            }
        }
        // 第二遍遍历，将未与边界相连的O设置为X，并将#设置回O
        for (col <- Array.range(0, colLength)) {
            for (row <- Array.range(0, rowLength)) {
                if (board(col)(row) == 'O') board(col)(row) = 'X'
                if (board(col)(row) == '#') board(col)(row) = 'O'
            }
        }

        /**
         * 将与边界0相连的所有O设置为# 第二遍扫描时再设置回O
         * @param col The col cur index
         * @param row The row cur Index
         */
        def dfs(col: Int, row: Int): Unit = {
            if (col < 0 || row < 0 || col >= colLength || row >= rowLength
                || board(col)(row) == 'X' || board(col)(row) == '#') {
                // 如果等于# 说明已经搜索过了
                return
            }
            board(col)(row) = '#'
            dfs(col - 1, row)
            dfs(col + 1, row)
            dfs(col, row - 1)
            dfs(col, row + 1)
        }
    }


    def main(args: Array[String]): Unit = {
        val board = Array(Array('O', 'O'), Array('O', 'O'))
        solve(board)
        board.foreach(row => {
            row.foreach(print(_))
            println()
        })
    }

}
