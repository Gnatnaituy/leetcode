package classify.arraymatrix;

public class ReshapeTheMatrix {

    /**
     * 1ms 100.00%
     * 38.1MB 99.74%
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0 ||
            nums.length * nums[0].length != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];
        int len = r * c;

        for (int i = 0; i < len; i++) {
            res[i / c][i % c] = nums[i / nums[0].length][i % nums[0].length];
        }

        return res;
    }
}
