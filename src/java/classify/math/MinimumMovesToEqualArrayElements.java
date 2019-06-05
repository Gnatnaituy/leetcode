package java.classify.math;

public class MinimumMovesToEqualArrayElements {

    /**
     * 2ms 93.23%
     * 38.8MB 98.66%
     */
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;

        return res;
    }
}
