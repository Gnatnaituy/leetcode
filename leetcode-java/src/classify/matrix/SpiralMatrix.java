package classify.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * 0ms      100.00%
     * 36.6MB   32.20%
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int direction = 1, high = matrix.length, width = matrix[0].length;
        int start = 1, max = high * width, row = 0, col = 0;
        List<Integer> res = new ArrayList<>(max);
        while (start <= max) {
            start++;
            res.add(matrix[row][col]);
            matrix[row][col] = -101;

            if (direction == 1) {
                if (col == width - 1 || matrix[row][col + 1] == -101) {
                    direction = 2;
                    row++;
                } else {
                    col++;
                }
            } else if (direction == 2) {
                if (row == high - 1 || matrix[row + 1][col] == -101) {
                    direction = 3;
                    col--;
                } else {
                    row++;
                }
            } else if (direction == 3) {
                if (col == 0 || matrix[row][col - 1] == -101) {
                    direction = 4;
                    row--;
                } else {
                    col--;
                }
            } else {
                if (row == 0 || matrix[row - 1][col] == -101) {
                    direction = 1;
                    col++;
                } else {
                    row--;
                }
            }
        }

        return res;
    }
}
