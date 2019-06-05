package java.completefifties.l0000;

public class SudokuSolver {

    /**
     * 2ms 98.81%
     * 34.1MB 94.98%
     */
    public void solveSudoku(char[][] board) {
        // 第一个下标表示坐标，第二个下标表示数字
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] block = new boolean[9][10];

        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                if (board[rowIndex][colIndex] != '.') {
                    int num = board[rowIndex][colIndex] - '0';
                    row[rowIndex][num] = true;
                    col[colIndex][num] = true;
                    block[rowIndex / 3 * 3 + colIndex / 3][num] = true;
                }
            }
        }

        dfs(board, row, col, block, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block,
                        int rowIndex, int colIndex) {
        while (board[rowIndex][colIndex] != '.') {
            if (++colIndex == 9) {
                rowIndex++;
                colIndex = 0;
            }

            if (rowIndex == 9) {
                return true;
            }
        }

        for (int num = 1; num <= 9; num++) {
            int blockIndex = rowIndex / 3 * 3 + colIndex / 3;

            if (!row[rowIndex][num] && !col[colIndex][num] && !block[blockIndex][num]) {
                board[rowIndex][colIndex] = (char) (num + '0');
                row[rowIndex][num] = true;
                col[colIndex][num] = true;
                block[blockIndex][num] = true;

                if (dfs(board, row, col, block, rowIndex, colIndex)) {
                    return true;
                }

                board[rowIndex][colIndex] = '.';
                row[rowIndex][num] = false;
                col[colIndex][num] = false;
                block[blockIndex][num] = false;
            }
        }

        return false;
    }
}
