package java.others.easy.dtwenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 219 Contains Duplicate II
 *
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */

public class ContainsDuplicateII {

    /**
     * 36ms 33.05%
     */
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list;

        for (int i = 0; i < nums.length; i++) {
            list = map.containsKey(nums[i]) ? map.get(nums[i]) : new ArrayList<>();
            list.add(i);
            map.put(nums[i], list);
        }

        for (List<Integer> num : map.values()) {
            if (num.size() > 1) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < num.size() - 1; i++) {
                    int distance = num.get(i + 1) - num.get(i);
                    min = distance < min ? distance : min;
                }
                if (min <= k) return true;
            }
        }

        return false;
    }

    /**
     * 23ms
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(nums[i]);
            if (val != null && (i - val <= k)) return true;
            map.put(nums[i], i);
        }

        return false;
    }

    /**
     * 2ms
     */
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) break;
                else if ((nums[i] == nums[j]) && (Math.abs(i - j) <= k)) return true;
            }
        }
        
        return false;
    }
}
