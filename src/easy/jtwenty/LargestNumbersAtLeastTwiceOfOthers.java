package easy.jtwenty;

import java.util.Arrays;

/**
 * 747 Largest Numbers at Least Twice of Others
 */

public class LargestNumbersAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int res = 0;
        if (nums.length == 1) res = 0;
        else {
            int[] cp = nums.clone();
            Arrays.sort(cp);
            if (cp[cp.length - 1] < 2 * cp[cp.length - 2]) res = -1;
            else {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == cp[cp.length - 1]) {
                        res = i;
                        break;
                    }
                }
            }
        }
        
        return res;
    }
}