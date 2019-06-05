package java.classify.dp;

public class GameOfLife {

    /**
     * 0ms 100.00%
     * 33.9MB 100.00%
     * T(n) = O(m * n)
     * S(n) = O(m * n)
     */
    public void gameOfLife(int[][] board) {
        int[] neighbors = {-1, 0, 1};

        int rows = board.length;
        int cols = board[0].length;
        int[][] copyBoard = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            if ((r < rows && r >= 0) && (c < cols && c >=0) && copyBoard[r][c] == 1) {
                                liveNeighbors++;
                            }
                        }
                    }
                }

                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 0;
                }
                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    /**
     * O(1) Space
     */
    public void gameOfLife2(int[][] board) {
        int[] neighbors = {-1, 0, 1};
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            if ((r < rows && r >= 0) && (c < cols && c >=0) && (board[r][c] == 1 || board[r][c] == -1)) {
                                liveNeighbors++;
                            }
                        }
                    }
                }
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = -1;
                }
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 2;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
