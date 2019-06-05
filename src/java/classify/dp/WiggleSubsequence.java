package java.classify.dp;

public class WiggleSubsequence {

    /**
     * 0ms 100.00%
     * 33.3MB 67.72%
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int pos = 1;
        int neg = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                pos = neg + 1;
            } else {
                neg = pos + 1;
            }
        }

        return Math.max(pos, neg);
    }
}