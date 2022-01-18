package classify.twopointers;

import java.util.Arrays;

public class SquaresOfASortedArray {

    /**
     * 19ms 37.45%
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);

        return A;
    }

    /**
     * 1ms      100.00%
     * 39.9MB   86.57%
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        int N = nums.length;
        int j = 0;
        while (j <= N - 1 && nums[j] < 0)
            j++;
        int i = j - 1;

        int[] res = new int[N];
        int t = 0;
        while (i >= 0 && j <= N - 1) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[t++] = nums[i] * nums[i];
                i--;
            } else {
                res[t++] = nums[j] * nums[j];
                j++;
            }
        }
        while (i >= 0) {
            res[t++] = nums[i] * nums[i];
            i--;
        }
        while (j <= N - 1) {
            res[t++] = nums[j] * nums[j];
            j++;
        }

        return res;
    }
}
