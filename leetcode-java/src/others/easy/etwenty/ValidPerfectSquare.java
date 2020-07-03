package others.easy.etwenty;

/**
 * 367 Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 *
 * Example 2:
 *
 * Input: 14
 * Output: false
 */

public class ValidPerfectSquare {

    private static boolean isPerfectSquare(int num) {
        // 利用恒等式： 1+3+5+7+....+(2*n-1)=n^2
//        for (int i = 1; num > 0; i += 2)
//            num -= i;
//        return num == 0;

        for (int i = 1; i < 46351; i++) {
            if (i * i == num)
                return true;
        }
        return false;
    }

    /**
     * 0ms
     */
    public boolean isPerfectSquare2(int num) {
        long l = 0, r = num;
        while(l <= r) {
            long m = l + (r - l) / 2;
            if (m * m == num)
                return true;
            if (m * m > num)
                r = m - 1;
            else
                l = m + 1;
        }
        return false;
    }
}
