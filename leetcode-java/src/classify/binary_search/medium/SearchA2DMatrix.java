package classify.binary_search.medium;

public class SearchA2DMatrix {

    /**
     * 0ms      100.00%
     * 38.3MB   94.31%
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

    /**
     * 0ms      100.00%
     * 41.2MB   47.34%
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int left = 1, right = row * col, mid;
        int value;

        while (left <= right) {
            mid = left + (right - left) / 2;
            value = matrix[Math.max(mid  - 1, 0) / col][Math.max(mid - 1, 0) % col];
            if (value == target) {
                return true;
            } else if (value > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
