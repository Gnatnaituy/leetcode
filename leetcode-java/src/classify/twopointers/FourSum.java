package classify.twopointers;

import tools.ParseArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yutiantang
 * @create 2021/3/27 5:02 PM
 */
public class FourSum {

    /**
     * 10ms     77.74%
     * 42.1MB   8.78%
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] > target - nums[i + 2] - nums[i + 3] ) {
                break;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] > target - nums[j + 1] - nums[j + 2]) {
                    break;
                }

                int findTarget = target - nums[i] - nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == findTarget) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum > findTarget) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res;
    }
}
