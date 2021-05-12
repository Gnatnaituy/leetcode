package classify.dp;

/**
 * @author yutiantang
 * @create 2021/5/12 21:16
 */
public class RangeSumQueryImmutable {

    /**
     * 13ms     37.14%
     * 43.2MB   5.14%
     */
    static class NumArray {

        private final int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return left == 0 ? sums[right] : sums[right] - sums[left - 1];
        }
    }
}
