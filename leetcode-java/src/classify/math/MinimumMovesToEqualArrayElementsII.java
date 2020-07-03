package classify.math;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {

    /**
     * 2ms 99.64%
     * 36.7MB 100.00%
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int res = 0;

        while (i < j) {
            res += nums[j] - nums[i];
            i++;
            j--;
        }

        return res;
    }
}
