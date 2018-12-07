package easy.dtwenty;

/**
 * 326 Power Of Three
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 *
 * Input: 27
 * Output: true
 *
 * Example 2:
 *
 * Input: 0
 * Output: false
 *
 * Example 3:
 *
 * Input: 9
 * Output: true
 *
 * Example 4:
 *
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 */

public class PowerOfThree {

    // 3^19是int范围内最大的3的幂，那么3^19可以被任何3的幂整除
    private static boolean isPowerOfThree(int n) {
        return (n>0 && Math.pow(3,19) % n == 0);
    }
}
