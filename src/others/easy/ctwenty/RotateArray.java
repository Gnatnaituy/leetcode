package others.easy.ctwenty;


/**
 * 189 Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

public class RotateArray {

    private static void rotate(int[] nums, int k) {
        if (nums.length < 2 || k == 0)
            return;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j++)
                nums[j] = nums[j - 1];
            nums[0] = temp;
        }
    }

    // Wrong !!!
    private static void retate2(int[] nums, int k) {
        if (nums.length < 2 || k == 0)
            return;

        for (int i = nums.length - 1; i > 0; i--) {
            int temp1 = nums[i];
            int temp2 = nums[(i + k) % nums.length];
            nums[i] = nums[(i + nums.length - k) % nums.length];
            nums[(i + k) % nums.length] = temp1;
            nums[(i + k) % nums.length] = temp2;

        }
    }
}

