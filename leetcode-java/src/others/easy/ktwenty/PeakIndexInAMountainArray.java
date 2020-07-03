package others.easy.ktwenty;

/**
 * 852 Peak Index in a Mountain Array
 */

public class PeakIndexInAMountainArray {
    
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, h = A.length - 1, m;
        while(l < h) {
            m = (l + h) >>> 1;
            if (A[m] > A[m - 1] && A[m] > A[m + 1]) {
                return m;
            } else if (A[m] > A[m - 1] && A[m] < A[m + 1]) {
                l = m;
            } else if (A[m] < A[m - 1] && A[m] > A[m + 1]) {
                h = m;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
