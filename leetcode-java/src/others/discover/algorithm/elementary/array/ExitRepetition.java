package others.discover.algorithm.elementary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 给定一个整数数组，判断是否存在重复元素
 * 如果任何值在数组中出现至少两次，函数返回 true
 * 如果数组中每个元素都不相同，则返回 false
 */
public class ExitRepetition {

    /**
     * 解法1 13ms 超过63.58%
     * 使用一个Set来储存元素, 从头遍历, 当存在相同元素时返回true
     * 遍历完成返回false
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) return true;
            else set.add(num);
        }

        return false;
    }

    /**
     * 解法2 1ms 超过100%
     */
    public boolean containsDuplicate2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 解法3 6ms
     */
    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }

        return false;
    }
}
