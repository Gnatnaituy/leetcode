package others.easy.atwenty;


/**
 * 70 Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class ClimbingStairs {

    private static int climbingStairs(int n) {
//        Recursion method: Time out
//        switch (n) {
//            case 0:
//                return 0;
//            case 1:
//                return 1;
//            case 2:
//                return 2;
//            default:
//                return climbingStairs(n - 1) + climbingStairs(n - 2);
//        }

        // Iteration method
        int pre = 0;
        int aft = 1;
        int tmp;

        for (int i = 1; i < n; i++) {
            tmp = pre;
            pre = aft;
            aft = tmp + aft;
        }

        return pre + aft;
    }

    public static void main(String[] args) {
        System.out.println(climbingStairs(7));
    }
}
