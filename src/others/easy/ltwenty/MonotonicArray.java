package others.easy.ltwenty;

/**
 * 896 Monotonic Array
 */

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        boolean isIncrease = A[0] < A[A.length - 1];
        
        if (isIncrease) {
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i + 1] < A[i])
                    return false;
            }
        } else {
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i + 1] > A[i])
                    return false;
            }
        }
        
        return true;
    }
}
