package others.completefifties.l0900;

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
     * 8ms
     */
    public int[] sortedSquares2(int[] A) {
        int N = A.length;
        int j = 0;
        while (j <= N - 1 && A[j] < 0)
            j++;
        int i = j - 1;

        int[] ans = new int[N];
        int t = 0;
        while (i >= 0 && j <= N - 1) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }
        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j <= N - 1) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
}
