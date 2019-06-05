package java.others.easy.etwenty;

/**
 * 342 Power Of Four
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 *
 * Follow up: Could you solve it without loops/recursion?
 */

public class PowerOfFour {

    private static boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xAAAAAAAA) == 0;
    }
}
