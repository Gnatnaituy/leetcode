package java.others.discover.datastructure.arrayandstring;


/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinimumSizeSubarraySum {

    /**
     * 6ms 27.66%
     * 双指针滑动窗口
     * 大家都是一样的写法
     */
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;
        int sum = 0;
        int len = nums.length + 1;

        while (left < nums.length) {
            if (right < nums.length - 1 && sum < s) {
                right++;
                sum += nums[right];
            } else {
                sum -= nums[left++];
            }

            if (sum >= s) {
                len = Math.min(len, right - left + 1);
            }
        }

        return len == nums.length + 1 ? 0 : len;
    }

    /**
     * 2ms
     */
    public int minSubArrayLen2(int s, int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        int i = 0, j = 0;
        int sum = 0, minLen = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];
            if (sum < s) { continue; }
            while (sum >= s) {
                sum -= nums[i++];
            }
            minLen = Math.min(minLen, j - i + 1);
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
