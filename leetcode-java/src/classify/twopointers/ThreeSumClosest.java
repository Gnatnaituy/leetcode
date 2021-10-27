package classify.twopointers;

import java.util.Arrays;

/**
 * @author yutiantang
 * @create 2021/3/27 1:55 PM
 */
public class ThreeSumClosest {

    /**
     * 5ms      95.29%
     * 38MB     76.49%
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int gap = Integer.MAX_VALUE;
        int sum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 过滤重复值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            // nums[left] + nums[right]要尽可能接近diff
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else {
                    // 如果当前三数之和更接近target 则更新gap和res
                    int curGap = Math.abs(sum - target);
                    if (curGap < gap) {
                        res = sum;
                        gap = curGap;
                    }
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
