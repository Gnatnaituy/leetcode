package classify.array;

/**
 * 判断一个 9x9 的数独是否有效
 * 只需要根据以下规则，验证已经填入的数字是否有效即可
 *
 * 1. 数字 1-9 在每一行只能出现一次
 * 2. 数字 1-9 在每一列只能出现一次
 * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 */
public class ValidSudoku {

    /**
     * 19ms 94.53%
     */
    public boolean isValid(char[][] board) {
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
                        // i / 3 * 3 + j / 3 可以计算当前属于第几个方阵
                        // 0  1  2
                        // 3  4  5
                        // 6  7  8
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

    public boolean isValid2(char[][] board) {
        /*
         14ms 100%
         用了四层循环, 为啥比第一种快?
         */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                // Check if duplicate in same row
                for (int k = 8; k > j; k--) if (board[i][j] == board[i][k]) return false;
                // Check if duplicate in same col
                for (int k = 8; k > i; k--) if (board[i][j] == board[k][j]) return false;
                // Check if duplicate in same 9x9 pane
                for (int k = i + 1; k % 3 != 0; k ++)
                    for (int h = j / 3 * 3; h < j / 3 * 3 + 3; h++)
                        if (board[i][j] == board[k][h]) return false;
            }
        }

        return true;
    }
}
