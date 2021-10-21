package classify.array;

import tools.ParseArray;

/**
 * @author yutiantang
 * @create 2021/10/21 16:49
 * 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class FindIn2DArray {

    /**
     * 0ms      100.00%
     * 44.2MB   32.89%
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length, row = rows - 1, col = 0, cur;
        while (row >= 0 && col < cols) {
            cur = matrix[row][col];
            if (cur == target) return true;
            if (cur < target) col++;
            if (cur > target) row--;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = ParseArray.parse2IntegerArray("[" +
                "[1,2,3,7,8]," +
                "[5,10,14,16,19]," +
                "[8,10,18,19,23]," +
                "[9,12,22,24,29]]");
        System.out.println(findNumberIn2DArray(matrix, 30));
    }
}
