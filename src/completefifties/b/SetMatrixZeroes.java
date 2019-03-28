package completefifties.b;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    /**
     * 5ms 26.81%
     */
    public void setZeroes(int[][] matrix) {
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    set.add(new int[]{i, j});
                }
            }
        }

        for (int[] index : set) {
            setRowColZeroes(matrix, index[0], index[1]);
        }
    }

    private void setRowColZeroes(int[][] matrix, int col, int row) {
        for (int i = 0; i < matrix[col].length; i++) {
            matrix[col][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][row] = 0;
        }
    }

    /**
     * 1ms
     */
    public void setZeroes2(int[][] matrix) {
        boolean rowFlag = false;
        //判断首行
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        boolean colFlag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
