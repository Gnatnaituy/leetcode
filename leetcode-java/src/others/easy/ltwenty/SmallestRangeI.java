package others.easy.ltwenty;

/**
 * 908 Smallest Range I
 */

public class SmallestRangeI {

    private int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int a : A) {
            if (a > max) max = a;
            if (a < min) min = a;
        }
        
        return max - K - min - K <= 0 ? 0 : max - K - min - K;
    }
}
