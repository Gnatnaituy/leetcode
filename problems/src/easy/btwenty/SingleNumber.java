package easy.btwenty;


import java.util.ArrayList;

/**
 * 136 Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */

public class SingleNumber {

    private static int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        ArrayList temp = new ArrayList();
        for (int num : nums) {
            if (temp.contains(num))
                temp.remove((Integer) num);
            else
                temp.add(num);
        }
        return (int) temp.get(0);
    }
}
