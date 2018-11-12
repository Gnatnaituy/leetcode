package easy.threetwenty;

/**
 * 172 Factorial Trailing Zeroes
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 *
 * I totally can't understand.
 */

public class FatorialTrailingZeroes {

    private static int trailingZeroes(int n) {
        int sum = 0;
        int m = n;
        while (n != 0) {
            sum += n % 5;
            n /= 5;
        }

        return (m - sum) >> 2;
    }
}
