package classify.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yutiantang
 * @create 2021/10/20 11:40
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class DuplicateNumbersInArray {

    /**
     * 1ms      77.70%
     * 46MB     83.36%
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int[] exi = new int[nums.length];
        for (int num : nums) {
            if (exi[num] == 1) {
                return num;
            } else {
                exi[num] = 1;
            }
        }
        return -1;
    }

    /**
     * 7ms      35.66%
     * 47.4MB   28.18%
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> exi = new HashSet<>();
        for (int num : nums) {
            if (exi.contains(num)) {
                return num;
            } else {
                exi.add(num);
            }
        }
        return -1;
    }

    /**
     * 0ms      100.00%
     * 46.2MB   56.46%
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
