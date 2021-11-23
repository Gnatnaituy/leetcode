package classify.array;

/**
 * @Author tiantang
 * @Date 2021/11/23
 */
public class SpiralMatrix {

    /**
     * 0ms      100.00%
     * 36.2MB   88.93%
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int num = 1, row = 0, col = 0, total = n * n, direction = 1;
        int[][] matrix = new int[n][n];

        while (num <= total) {
            matrix[row][col] = num;
            if (direction == 1) {
                if (col == n - 1 || matrix[row][col + 1] != 0) {
                    direction = 2;
                    row++;
                } else {
                    col++;
                }
            } else if (direction == 2) {
                if (row == n - 1 || matrix[row + 1][col] != 0) {
                    direction = 3;
                    col--;
                } else {
                    row++;
                }
            } else if (direction == 3) {
                if (col == 0 || matrix[row][col - 1] != 0) {
                    direction = 4;
                    row--;
                } else {
                    col--;
                }
            } else {
                if (row == 0 || matrix[row - 1][col] != 0) {
                    direction = 1;
                    col++;
                } else {
                    row--;
                }
            }
            num++;
        }

        return matrix;
    }
}
