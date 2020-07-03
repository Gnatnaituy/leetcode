package others.easy.jtwenty;

/**
 * 766 Toeplitz Matrix
 */

public class ToeplitzMatrix {
    public boolean isToepLitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }
        return true;
    }
}