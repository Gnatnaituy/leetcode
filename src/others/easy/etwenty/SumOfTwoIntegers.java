package others.easy.etwenty;

/**
 * 371 Sum of Two Integers
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example:
 * Given a = 1 and b = 2, return 3.
 *
 * Credits:
 * Special thanks to @fujiaozhu for adding this problem and creating all test cases.
 */

public class SumOfTwoIntegers {

    private static int getSum(int a, int b) {
        // Too slow, 3ms, surpass 1.73% users......
        if (a == 0)
            return b;
        if (a > 0) {
            while (a > 0) {
                a--; b++;
            }
        } else {
            while (a < 0) {
                a++; b--;
            }
        }
        return b;
    }
}
