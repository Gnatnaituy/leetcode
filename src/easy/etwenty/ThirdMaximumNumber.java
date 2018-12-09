package easy.etwenty;

import java.util.Arrays;

/**
 * 414 Third Maximum Number
 *
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 *
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */

public class ThirdMaximumNumber {

    private static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        int max = nums[nums.length - 1];
        int time = 0;

        while (i > 0) {
            if (nums[i - 1] < nums[i])
                time++;

            if (time == 2)
                return nums[i - 1];

            i--;
        }

        return max;
    }
}
