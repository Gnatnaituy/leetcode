package classify.matrix;

import java.util.Arrays;

public class SpiralMatrixIII {

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] matrix = new int[rows][cols], res = new int[rows * cols][2];
        int start = 0, end = rows * cols - 1, row = rStart, col = cStart, direction = 1;

        while (start < end) {
            if (matrix[row][col] == 0) {
                matrix[row][col] = 1;
                res[start][0] = row;
                res[start][1] = col;
                start++;
            }

            switch (direction) {
                case 1:
                    if (start == 0 || (matrix[row][col] == 1 && col < cols - 1)) {
                        col++;
                    } else {
                        direction = 2;
                        row = row == rows - 1 ? row : row + 1;
                    }
                    break;
                case 2:
                    if (row == rows - 1 || (col > 0 && matrix[row][col - 1] == 0)) {
                        direction = 3;
                        col = col == 0 ? col : col - 1;
                    } else {
                        row++;
                    }
                    break;
                case 3:
                    if (col == 0 || (row > 0 && matrix[row - 1][col] == 0)) {
                        direction = 4;
                        row = row == 0 ? row : row - 1;
                    } else {
                        col--;
                    }
                    break;
                default:
                    if (row == 0 || (col < cols - 1 && matrix[row][col + 1] == 0)) {
                        direction = 1;
                        col = col == cols - 1 ? col : col + 1;
                    } else {
                        row--;
                    }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralMatrixIII(3, 3, 2, 0)));;
    }
}
