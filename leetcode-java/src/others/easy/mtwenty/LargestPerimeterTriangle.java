package others.easy.mtwenty;

import java.util.Arrays;

/**
 * 976 Largest Perimeter Triangle
 */

public class LargestPerimeterTriangle {
    
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int cur = A.length - 3;
        while (cur >= 0) {
            int a = A[cur + 1];
            int b = A[cur + 2];
            int ccur = cur;
            while (ccur >= 0) {
                if (a + b > A[ccur] && b - a < A[cur])
                    return a + b + A[ccur];
                ccur--;
            }
            cur--;
        }
        return 0;
    }
}
