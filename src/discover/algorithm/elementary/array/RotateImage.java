package discover.algorithm.elementary.array;

public class RotateImage {

    /**
     * 给定一个 n × n 的二维矩阵表示一个图像
     * 将图像顺时针旋转 90 度
     * 说明：
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵
     * 请不要使用另一个矩阵来旋转图像
     */
    public void rotate(int[][] matrix) {
        /*
        2ms 81.92%
         */
        int len = matrix.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }
}
