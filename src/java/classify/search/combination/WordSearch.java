package java.classify.search.combination;

public class WordSearch {
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, i, j, w, 0)) {
                    return true;
                }

                // 第二种方法
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 4ms 93.64%
     * 37.2MB 99.60%
     */
    private boolean exist(char[][] board, int row, int col, char[] word, int index) {
        if (index == word.length) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
            || board[row][col] != word[index]) {
            return false;
        }

        board[row][col] ^= 256;

        boolean exist = exist(board, row + 1, col, word, index + 1)
                || exist(board, row - 1, col, word, index + 1)
                || exist(board, row, col + 1, word, index + 1)
                || exist(board, row, col - 1, word, index + 1);

        board[row][col] ^= 256;

        return exist;
    }


    /**
     * 5ms 73.34%
     * 37.4MB 99.53%
     */
    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
            || board[row][col] != word.charAt(index)) {
            return false;
        }

        board[row][col] = '-';

        for (int[] dir : direction) {
            if (backtrack(board, word, row + dir[0], col + dir[1], index + 1)) {
                return true;
            }
        }

        board[row][col] = word.charAt(index);

        return false;
    }
}
