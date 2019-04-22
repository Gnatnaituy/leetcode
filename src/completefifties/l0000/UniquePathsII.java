package completefifties.l0000;

public class UniquePathsII {

    /**
     * 63. Unique Paths II
     * https://leetcode-cn.com/problems/unique-paths-ii/
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * obstacleGrid example
         * 0    0    0    0    0
         * 0    0    1    0    0
         * 0    1    0    0    0
         * 0    0    0    0    0
         * roadCount
         * 1    1    1    1    1
         * 1    2    0    1    2
         * 1    0    0    1    3
         * 1    1    1    2    5
         */
        int width = obstacleGrid[0].length;
        int high = obstacleGrid.length;
        int[][] roadCount = new int[high][width];

        for (int i = 0; i < width; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            roadCount[0][i] = 1;
        }
        for (int j = 0; j < high; j++) {
            if (obstacleGrid[j][0] == 1) {
                break;
            }
            roadCount[j][0] = 1;
        }
        for (int i = 1; i < high; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    roadCount[i][j] = 0;
                } else {
                    roadCount[i][j] = roadCount[i - 1][j] + roadCount[i][j - 1];
                }
            }
        }

        return roadCount[high - 1][width - 1];
    }
}