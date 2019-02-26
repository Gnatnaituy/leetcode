package others.easy.dtwenty;

/**
 * 268 Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 *
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 */

public class MissingNumber {

    private static int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n % 2 == 0 ? (n + 1) * (n / 2) : (n + 1) * (n / 2) + (n + 1) / 2;
        int subTotal = 0;
        for (int a : nums)
            subTotal += a;
        return total - subTotal;
    }
}
