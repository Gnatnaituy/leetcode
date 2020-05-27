package java.classify.slidingwindow;


public class MaxConsecutiveonesIII {

    /**
     * 3ms 99.81%
     * 38.6MB 100.00%
     */
    public int longestOnes(int[] A, int K) {
        int i = 0, j;

        for (j = 0; j < A.length; j++) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }

        return j - i;
    }
}