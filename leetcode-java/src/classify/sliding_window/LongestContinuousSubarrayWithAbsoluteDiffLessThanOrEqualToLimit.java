package classify.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    /**
     * 27ms     87.75%
     * 49.1MB   96.08%
     * 滑动窗口-双指针 宫水三叶
     */
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        
        for (int slow = 0, fast = 0; fast < nums.length; fast++) {
            while (!max.isEmpty() && nums[fast] >= nums[max.peekLast()]) {
                max.pollLast();
            }
            max.addLast(fast);

            while (!min.isEmpty() && nums[fast] <= nums[min.peekLast()]) {
                min.pollLast();
            }
            min.addLast(fast);

            while (Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit) {
                slow++;
                if (max.peekFirst() < slow) max.pollFirst();
                if (min.peekFirst() < slow) min.pollFirst();
            }
            res = Math.max(res, fast - slow + 1);
        }

        return res;
    }
}
