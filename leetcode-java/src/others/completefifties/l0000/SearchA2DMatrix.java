package others.completefifties.l0000;

public class SearchA2DMatrix {

    /**
     * 12ms 13.02%
     */
    private static boolean searchMatrix0(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (val == target)
                return true;
            else if (val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }

    /**
     * 11ms 66.02%
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                if (i == 0) return false;
                for (int num : matrix[i - 1]) {
                    if (num == target) return true;
                }
                return false;
            }
            if (i == matrix.length - 1) {
                for (int num : matrix[i]) {
                    if (num == target) return true;
                }
                return false;
            }

        }

        return false;
    }

    /**
     * 5ms
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / n][mid % n] == target)
                return true;
            if (target < matrix[mid / n][mid % n])
                end = mid - 1;
            if (target > matrix[mid / n][mid % n])
                start = mid + 1;
        }

        return false;
    }
}
