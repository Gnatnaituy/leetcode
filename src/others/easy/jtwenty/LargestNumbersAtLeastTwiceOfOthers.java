package others.easy.jtwenty;

import java.util.Arrays;

/**
 * 747 Largest Numbers at Least Twice of Others
 */

public class LargestNumbersAtLeastTwiceOfOthers {

    /**
     * 20ms 21.08%
     */
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;

        int[] cp = nums.clone();
        Arrays.sort(cp);

        if (cp[cp.length - 1] < 2 * cp[cp.length - 2])
            return -1;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] == cp[cp.length - 1])
                return i;
        
        return -1;
    }

    /**
     * 10ms
     */
    public int dominantIndex2(int[] nums) {
        int max=-1, max_index=-1, second_max=-1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                second_max = max;
                max = nums[i];
                max_index = i;
            } else if (nums[i]>second_max) {
                second_max = nums[i];
            }
        }

        return max >= second_max * 2 ? max_index : -1;
    }
}