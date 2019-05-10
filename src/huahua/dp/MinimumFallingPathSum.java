package huahua.dp;

public class MinimumFallingPathSum {

    /**
     * 3ms 95.17%
     * 38MB 93.01%
     */
    public int minFallingPathSum(int[][] A) {
        int edge = A.length;
        if (edge == 1) return A[0][0];


        int[] previous;
        for (int i = 0; i < edge - 1; i++) {
            previous = A[i].clone();
            // 处理第 1 个元素
            A[i + 1][0] = A[i + 1][0] + Math.min(previous[0], previous[1]);
            // 处理第 2 至 edge-1 个元素
            for (int j = 1; j < edge - 1; j++) {
                A[i + 1][j] = A[i + 1][j] + Math.min(previous[j - 1], Math.min(previous[j], previous[j + 1]));
            }
            // 处理第 edge 个元素
            A[i + 1][edge - 1] = A[i + 1][edge - 1] + Math.min(previous[edge - 2], previous[edge - 1]);
        }

        int res = Integer.MAX_VALUE;
        for (int sum : A[edge - 1]) if (sum < res) res = sum;

        return res;
    }
}
