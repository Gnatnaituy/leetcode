package java.others.easy.gtwenty;

import java.util.Arrays;

/**
 * 561 Array Partition I
 *
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 *
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 */

public class ArrayPartionI {

    private static int arrayPairsSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }

        return res;
    }

    // 可以用桶排序加速 int[20001]
    public int arrayPairSum(int[] nums){
        int[] a = new int[20001];
        int sum = 0;

        for (int num : nums) {
            a[num + 10000]++;
        }

        boolean even = false;
        for(int i = 0; i < a.length; i++){
            while(a[i] > 0){
                if(!even){
                    sum += i - 10000;
                }
                even = !even;
                a[i]--;
            }
        }

        return sum;
    }
}
