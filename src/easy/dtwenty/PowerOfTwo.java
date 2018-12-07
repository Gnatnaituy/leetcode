package easy.dtwenty;

/**
 * 231 Power Of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 */

public class PowerOfTwo {

    private static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        while (n != 0) {
            int temp = n;
            n >>= 1;
            if (n * 2 != temp)
                return false;
        }
        return true;
    }
}
