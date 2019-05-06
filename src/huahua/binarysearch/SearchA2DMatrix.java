package huahua.binarysearch;

public class SearchA2DMatrix {

    /**
     * 0ms 100.00%
     * 38.3MB 94.31%
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) row--;
            else col++;
        }

        return false;
    }
}
