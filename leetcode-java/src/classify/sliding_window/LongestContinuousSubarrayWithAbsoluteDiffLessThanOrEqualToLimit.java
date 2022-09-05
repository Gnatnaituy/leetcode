package classify.sliding_window;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public static int longestSubarray(int[] nums, int limit) {
        int slow = 0, fast = 0, min = nums[0] - limit, max = nums[0] + limit, res = 0;
        while (fast < nums.length) {
            if (nums[fast] > max || nums[fast] < min) {
                max = Math.max(max, nums[slow] + limit);
                min = Math.min(min, nums[slow] - limit);
                slow++;
            } else {
                max = Math.min(max, nums[fast] + limit);
                min = Math.max(min, nums[fast] - limit);
                res = Math.max(res, fast - slow + 1);
                fast++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));
        System.out.println((int) ((double) 35 / 235 * 100));
    }
}
