package easy.itwenty;

import java.util.HashMap;
import java.util.Map;

/**
 * 697 Degree of an Array
 */

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] number = numMap.getOrDefault(nums[i], new int[3]);
            number[0]++;
            if (number[1] == 0) {
                number[1] = i + 1;
            }
            number[2] = i + 1;
            numMap.put(nums[i], number);
        }

        int minLen = 0;
        int count = 0;
        for (int[] value : numMap.values()) {
            if (value[0] > count) {
                count = value[0];
                minLen = value[2] - value[1] + 1;
            } else if (value[0] == count) {
                minLen = Math.min(minLen, value[2] - value[1] + 1);
            }
        }
        
        return minLen;
    }
}