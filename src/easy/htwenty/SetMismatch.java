package easy.htwenty;

import java.util.HashSet;
import java.util.Set;

/**
 * 645 Set Mismatch
 *
 * he set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
 * one of the numbers in the set got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 *
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number that is missing.
 * Return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 *
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order
 */

public class SetMismatch {
    private static int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;
        Set<Integer> set = new HashSet<Integer>();
        int i = 0;
        for(; i < len; i++){
            if(set.contains(nums[i]))
                break;
            else set.add(nums[i]);
        }
        int [] res=new int[2];
        res[0] = nums[i];
        int sumerr = 0;
        for (int num : nums) {
            sumerr += num;
        }
        res[1] = sum - (sumerr - res[0]);

        return res;
    }
}
