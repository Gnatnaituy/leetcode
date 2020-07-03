package classify.math;

public class ValidPerfectSquare {

    /**
     * 1ms 26.29%
     * 32.3MB 41.65%
     * A square number  = 1 + 3 + 5 + 7 ......
     */
    public boolean isPerfectSquare(int num) {
        int i = 1;

        while (num > 0) {
            num -= i;
            i += 2;
        }

        return num == 0;
    }

    /**
     * 	Time Limit Exceeded
     */
    public boolean isPerfectNumber2(int num) {
        int left = 0;
        int right = num;

        while (left <= right) {
            int mid = left + (right - left) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
