package classify.binarysearch;

public class SqrtX {

    /**
     * 1ms 100.00%
     * 32.4MB 100.00%
     */
    public int mySqrt(int x) {
//        int left = 0, right = x;
//
//        while (left < right) {
//            int middle = left + (right - left) / 2;
//            if (middle * middle > x) right = middle - 1;
//            else {
//                if ((middle + 1) * (middle + 1) > x) return middle;
//                left = middle;
//            }
//        }
//
//        return left;

        if (x == 0) return 0;

        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) return mid;
                left = mid + 1;
            }
        }
    }
}
