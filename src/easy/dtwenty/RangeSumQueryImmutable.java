package easy.dtwenty;

/**
 * 303 Range Sum Query - Immutable
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */

public class RangeSumQueryImmutable {

    private int[] nums;
    private int[] numi;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        numi = new int[this.nums.length + 1];
        numi[0] = 0;
        for (int i = 0; i < nums.length; i++)
            numi[i + 1] = numi[i] + nums[i];
    }

    public int sumRange(int i, int j) {
        return numi[j + 1] - numi[i];
    }
}
