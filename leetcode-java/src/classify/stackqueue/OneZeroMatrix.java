package classify.stackqueue;


/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离
 * 两个相邻元素间的距离为 1
 *
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 *
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * [1, 0, 1, 1, 0, 0, 1, 0, 0, 1]
 * [0, 1, 1, 0, 1, 0, 1, 0, 1, 1]
 * [0, 0, 1, 0, 1, 0, 0, 1, 0, 0]
 * [1, 0, 1, 0, 1, 1, 1, 1, 1, 1]
 * [0, 1, 0, 1, 1, 0, 0, 0, 0, 1]
 * [0, 0, 1, 0, 1, 1, 1, 0, 1, 0]
 * [0, 1, 0, 1, 0, 1, 0, 0, 1, 1]
 * [1, 0, 0, 0, 1, 1, 1, 1, 0, 1]
 * [1, 1, 1, 1, 1, 1, 1, 0, 1, 0]
 * [1, 1, 1, 1, 0, 1, 0, 0, 1, 1]
 */
public class OneZeroMatrix {

    /**
     * 第一遍做法:　
     * 从左往右从上到下扫描
     * 如果这个点的值为0, 则距离为0
     * 如果不为零, 则为上下左右点最小的那个+1
     * 这导致了后面没有算出来的点加入计算而导致错误
     * 解决办法为两遍扫描
     * @param matrix int[][]
     * @return int
     */
    public int[][] updateMatrixErrorVersion(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    int top     = i > 0 ? matrix[i - 1][j] : Integer.MAX_VALUE;
                    int left    = j > 0 ? matrix[i][j - 1] : Integer.MAX_VALUE;
                    int bottom  = i < matrix.length - 1     ? matrix[i + 1][j] : Integer.MAX_VALUE;
                    int right   = j < matrix[i].length - 1  ? matrix[i][j + 1] : Integer.MAX_VALUE;

                    matrix[i][j] = 1 + Math.min(top, Math.min(bottom, Math.min(left, right)));
                }
            }
        }

        return matrix;
    }

    /**
     * 24ms 82.40%
     * 两遍扫描
     * - 第一遍扫描左边和上面的点，取最小值加1
     * - 第二遍倒过来从右下角开始扫描，取右边和下面点的最小值加1
     */
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != 0) {
                    // 假如一个3*3的矩阵，只有右下角为0，其余为1。在第一遍扫描的过程中，[1,1]点左和上都是INT_MAX，
                    // 加1的过程会溢出，所以初始化为INT_MAX - 1，不用担心溢出，取最小值永远也达不到INT_MAX
                    res[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (res[i][j] != 0) {
                    if (i > 0) res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    if (j > 0) res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (res[i][j] != 0) {
                    if (i < row - 1) res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                    if (j < col - 1) res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                }
            }
        }

        return res;
    }


    /**
     * 10ms
     */
    public int[][] updateMatrix2(int[][] matrix) {
        boolean noEnd;
        int k = 1;
        int row = matrix.length;
        int col = matrix[0].length;
        
        do {
            noEnd = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // k从1开始
                    // 当前位置元素距离0的距离>=k 且上下左右均(不越界或者也>=k)
                    // 意味着如果某个(不小于k)的元素的上下左右(都不小于k)，那么他就得自增1
                    // 即一个元素被“包围”, 它当然要比周围元素中最大的元素还要大1, 因为他离0离得更远
                    if (matrix[i][j] >= k
                            && (i == 0 || matrix[i - 1][j] >= k)
                            && (j == 0 || matrix[i][j - 1] >= k)
                            && (j == col - 1 || matrix[i][j + 1] >= k)
                            && (i == row - 1 || matrix[i + 1][j] >= k)) {
                        matrix[i][j]++;
                        noEnd = true;
                    }
                }
            }
            k++;
        } while (noEnd); // noEnd为false说明图中已经没有还需要自增的元素了
        
        return matrix;
    }
}
