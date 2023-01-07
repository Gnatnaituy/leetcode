package classify.array;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    /**
     * 1ms      37.12%      O(mn)
     * 43.3MB   13.34%      O(m+n)
     * 使用额外数组记录零值位置，遍历零值将所在行和列全部置为0
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
     * 0ms      100.00%     O(mn)
     * 43.4MB   19.91%      O(1)
     * 原地算法
     */
    public void setZeroes1(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRowZero = true;
                    if (j == 0) firstColZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 因为依赖于第一行和第一列的0值，所以不能修改
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
