package complete.aa;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */

public class aTwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Not two sum solution.");
    }

    public static void main(String[] args) {
        int[] a = new aTwoSum().twoSum(new int[]{2, 3, 4, 5, 6, 7}, 9);
        System.out.println(a);
    }
}