package java.others.easy.ftwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 448 Find All Numbers Disappeared in an Array
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and java.others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */

public class FindAllNumberDisappearedInAnArray {

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0)
            return result;

        Arrays.sort(nums);
        if (nums[0] > 1) {
            for (int i = 1; i < nums[0]; i++)
                result.add(i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                int sub = nums[i + 1] - nums[i];
                while (sub > 1) {
                    result.add(nums[i + 1] - sub + 1);
                    sub--;
                }
            }
        }
        if (nums[nums.length - 1] < nums.length) {
            int sub = nums.length - nums[nums.length - 1];
            while (sub > 0) {
                result.add(nums.length - sub + 1);
                sub--;
            }
        }
        return result;
    }
}
