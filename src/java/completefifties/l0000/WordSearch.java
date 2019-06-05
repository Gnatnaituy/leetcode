package java.completefifties.l0000;

public class WordSearch {

    /**
     * 7ms 100%
     * @param board char[][]
     * @param word String
     * @return boolean
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        if (word == null || word.trim().length() == 0)
            return false;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, word, 0, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int index, int x, int y) {
        if (index == word.length())
            return true;
        if (x < 0 || x > board.length - 1)
            return false;
        if (y < 0 || y > board[0].length - 1)
            return false;
        if (visited[x][y])
            return false;
        if (board[x][y] != word.charAt(index))
            return false;
        else visited[x][y] = true;

        boolean exist;
        exist = dfs(board, visited, word, index + 1, x + 1, y);
        if (exist) return true;
        exist = dfs(board, visited, word, index + 1, x - 1, y);
        if (exist) return true;
        exist = dfs(board, visited, word, index + 1, x, y + 1);
        if (exist) return true;
        exist = dfs(board, visited, word, index + 1, x, y - 1);
        //重置走过的点，避免污染其他路径
        visited[x][y] = false;

        return exist;
    }
}
