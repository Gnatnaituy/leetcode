package classify.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yutiantang
 * @create 2021/4/27 23:41
 */
public class SingleNumber {

    /**
     * 7ms      29.42%
     * 385.MB   78.09%
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    /**
     * 16ms     10.24%
     * 38.8MB   33.54%
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            if (uniques.contains(num)) {
                uniques.remove(num);
            } else {
                uniques.add(num);
            }
        }

        return uniques.iterator().next();
    }

    /**
     * 1ms      100.00%
     * 38.4MB   88.58%
     * 官方题解 位算法
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }

        return single;
    }
}
