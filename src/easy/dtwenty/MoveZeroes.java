package easy.dtwenty;

/**
 * 283 Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

public class MoveZeroes {

    private static void moveZeroes(int[] nums) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == 0)
                break;
        }
        int cursor = i + 1, zero = i;
        while (cursor < nums.length) {
            if (nums[cursor] != 0) {
                nums[zero] = nums[cursor];
                nums[cursor] = 0;
                cursor += 1;
                zero += 1;
            } else if (nums[cursor] == 0)
                cursor += 1;
        }
    }
}
