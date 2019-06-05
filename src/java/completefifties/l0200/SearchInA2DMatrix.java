package java.completefifties.l0200;

public class SearchInA2DMatrix {

    /**
     * 14ms 59.25%
     * 53.70MB 14.20%
     * <p>
     * 分治法
     * 左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标：
     * 若左下角元素等于目标，则找到
     * 若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
     * 若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标
     * 若最后矩阵减小为空，则说明不存在
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, target, matrix.length - 1, 0);
    }

    private boolean helper(int[][] matrix, int target, int row, int column) {
        if (row < 0 || column >= matrix[0].length) return false;
        if (matrix[row][column] > target) return helper(matrix, target, row - 1, column);
        if (matrix[row][column] < target) return helper(matrix, target, row, column + 1);
        else return true;
    }

    /**
     * 5ms
     * 从右上角元素下手
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1;

        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        return false;
    }
}
