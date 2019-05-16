package classify.search;

public class SurroundedRegions {
    private int row;
    private int col;

    /**
     * 211ms 5.03%
     * 47.5MB 8.15%
     */
    public void solve(char[][] board) {
        if (board == null) return;
        row = board.length;
        if (row == 0) return;
        col = board[0].length;
        if (col == 0) return;

        boolean[][] visited;

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                visited = new boolean[row][col];
                if (board[i][j] == 'O' && !visited[i][j] && !touchBorder(board, visited, i, j)) {
                    convert(board, i, j);
                }
            }
        }
    }

    private boolean touchBorder(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return true;
        }

        if (visited[i][j] || board[i][j] == 'X') {
            return false;
        }

        visited[i][j] = true;

        return touchBorder(board, visited, i + 1, j)
                || touchBorder(board, visited, i - 1, j)
                || touchBorder(board, visited, i, j + 1)
                || touchBorder(board, visited, i, j - 1);
    }

    private void convert(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'X';
        convert(board, i + 1, j);
        convert(board, i - 1, j);
        convert(board, i, j + 1);
        convert(board, i, j - 1);
    }


    /**
     * 1ms
     */
    public void solve2(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n - 1] == 'O')
                boundaryDFS(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m - 1][j] == 'O')
                boundaryDFS(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i - 1][j] == 'O')
            boundaryDFS(board, i - 1, j);
        if (i < board.length - 2 && board[i + 1][j] == 'O')
            boundaryDFS(board, i + 1, j);
        if (j > 1 && board[i][j - 1] == 'O')
            boundaryDFS(board, i, j - 1);
        if (j < board[i].length - 2 && board[i][j + 1] == 'O')
            boundaryDFS(board, i, j + 1);
    }
}
