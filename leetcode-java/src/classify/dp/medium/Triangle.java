package classify.dp.medium;

import java.util.List;

public class Triangle {

    /**
     * 12ms, 23.88%
     * 二维数组求解
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j)
                        + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    /**
     * O(n)     2ms     96.08%
     * O(n)     41.2MB  37.06%
     * 倒序求解
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }

        return dp[0];
    }

    /**
     * O(n)     4ms     35.72%
     * O(n)     41MB    61.35%
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.size()];

        sum[0] = triangle.get(0).get(0);
        for (int row = 1; row < triangle.size(); row++) {
            for (int col = triangle.get(row).size() - 1; col >= 0; col--) {
                if (col == 0) {
                    sum[col] = triangle.get(row).get(col) + sum[col];
                } else if (col == triangle.get(row).size() - 1) {
                    sum[col] = triangle.get(row).get(col) + sum[col - 1];
                } else {
                    sum[col] = triangle.get(row).get(col) + Math.min(sum[col], sum[col - 1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : sum) {
            min = Math.min(min, num);
        }

        return min;
    }
}
