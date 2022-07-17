package classify.dp;

public class RangeSumQuery {

    private int[] privateNums;

    /**
     * 8ms      35.65%
     * 44.2MB   50.22%
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

    public int sumRange(int left, int right) {
        if (left == 0) return privateNums[right];
        return privateNums[right] - privateNums[left - 1];
    }
}
