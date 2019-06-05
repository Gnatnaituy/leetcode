package java.classify.dp;

public class RangeSumQuery {
    private int[] privateNums;

    /**
     * 55ms 69.78%
     * 42.6MB 46.71%
     */
    public RangeSumQuery(int[] nums) {
        this.privateNums = new int[nums.length];

        if (nums.length > 0) {
            this.privateNums[0] = nums[0];
        }

        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                this.privateNums[i] = nums[i] + privateNums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return privateNums[j];
        return privateNums[j] - privateNums[i - 1];
    }
}
