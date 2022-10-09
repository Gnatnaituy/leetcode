package classify.dp;

public class HouseRobberII {

    /**
     * 0ms      100.00%
     * 38.9MB   56.31%
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int first, int last) {
        int preMax = 0, max = 0;

        for (int i = first; i <= last; i++) {
            int cur = Math.max(max, preMax + nums[i]);
            preMax = max;
            max = cur;
        }

        return max;
    }
}
