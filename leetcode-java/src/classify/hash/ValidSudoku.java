package classify.hash;

/**
 * @author yutiantang
 * @create 2021/4/25 23:19
 */
public class ValidSudoku {

    /**
     * 2ms      95.26%
     * 38.6MB   48.29%
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][10];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][10];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || block[i / 3 * 3 + j / 3][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
        }

        return true;
    }

    /**
     * 1ms      100.00%
     * 38.1MB   95.53%
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                // Check if duplicate in same row
                for (int k = 8; k > j; k--) {
                    if (board[i][j] == board[i][k]) {
                        return false;
                    }
                }
                // Check if duplicate in same col
                for (int k = 8; k > i; k--) {
                    if (board[i][j] == board[k][j]) {
                        return false;
                    }
                }
                // Check if duplicate in same 9x9 pane
                for (int k = i + 1; k % 3 != 0; k ++) {
                    for (int h = j / 3 * 3; h < j / 3 * 3 + 3; h++) {
                        if (board[i][j] == board[k][h]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
