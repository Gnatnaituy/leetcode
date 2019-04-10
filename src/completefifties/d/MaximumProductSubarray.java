package completefifties.d;

public class MaximumProductSubarray {

    /**
     * 3ms 87.91%
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;

        for (int num : nums) {
            // 如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。
            // 因此交换两个的值。
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
