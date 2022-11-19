package classify.dp.medium;

public class MaximumProductSubarray {

    /**
     * O(n)     2ms     66.53%
     * O(1)     41.4MB  72.87%
     * 复数会使最大值变为最小值，最小值变为最大值
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;

        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }

        return max;
    }
}
