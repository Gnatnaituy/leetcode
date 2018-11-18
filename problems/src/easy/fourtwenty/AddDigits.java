package easy.fourtwenty;

/**
 * 258 Add Digits
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */

public class AddDigits {

    private static int addDigits(int num) {
        if (num < 10)
            return num;

        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return addDigits(result);
    }
}
