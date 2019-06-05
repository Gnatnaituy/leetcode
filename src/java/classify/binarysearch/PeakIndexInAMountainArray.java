package java.classify.binarysearch;

public class PeakIndexInAMountainArray {

    /**
     * 0ms 100.00ms
     * 40MB 90.06%
     */
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (A[middle] < A[middle + 1]) left = middle + 1;
            else right = middle;
        }

        return left;
    }
}
