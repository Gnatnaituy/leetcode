package easy.htwenty;

import java.util.*;

/**
 * 594 Longest Harmonious Subsequence
 *
 * We define a harmonious array is an array where the difference between its maximum value
 * and its minimum value is exactly 1.
 *
 * Now, given an integer array, you need to find the length of
 * its longest harmonious subsequence among all its possible subsequences.
 *
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Note: The length of the input array will not exceed 20,000.
 */

public class LongestHarmoniousSubsequence {

    private static int findLHS(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) hashMap.put(num, hashMap.get(num) + 1);
            else hashMap.put(num, 1);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                res = Math.max(res, hashMap.get(nums[i + 1]) + hashMap.get(nums[i]));
            }
        }

        return res;

        // fastest
//        if (nums == null || nums.length == 0 || nums.length == 1){
//            return 0;
//        }
//        Arrays.sort(nums);
//        int max = 0, temp = nums[0], begin = 0, index = 0;
//        boolean isStart = true;
//        for (int i = 1; i <= nums.length; i++){
//            if (i == nums.length || nums[i] != temp){
//                if (!isStart){
//                    max = max > (i - begin) ? max : (i - begin);
//                    begin = index;
//                }
//                if (i == nums.length) break;
//                if (nums[i] - temp == 1){
//                    isStart = false;
//                } else {
//                    isStart = true;
//                    begin = i;
//                }
//                temp = nums[i];
//                index = i;
//            }
//        }
//        return max;
    }
}
