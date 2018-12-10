package easy.htwenty;

import java.util.Arrays;

/**
 * 581 Shortest Unsorted Continuous SubArray
 *
 * Given an integer array,
 * you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class ShortestUnsortedContinuousSubarray {

    private int findUnsortedSubArray(int[] nums) {
        int[] cp = nums.clone();
        Arrays.sort(cp);
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != cp[i] && start == 0)
                start = i;
            if (nums[i] != cp[i])
                end = i;
        }

        return start == end ? 0 : end - start + 1;
    }
}
