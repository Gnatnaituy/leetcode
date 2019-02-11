package discover.algorithm.elementary.array;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumber {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次
     * 找出那个只出现了一次的元素
     * 使用O(n)时间复杂度和O(1)空间复杂度
     */
    public int singleNumber(int[] nums) {
        /**
         * 解法1 6ms 超过41.02%
         */
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((i == 0 && nums[i] != nums[i + 1])
                || (i == nums.length - 1 && nums[i] != nums[i - 1])
                || (i > 0 && i < nums.length - 1 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1]))
                return nums[i];
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        /**
         * 解法2 1ms
         * 使用位异或运算
         */
        for (int num : nums) {
            nums[0] ^= num;
        }

        return nums[0];
    }

    public int singleNumber3(int[] nums) {
        /**
         * 解法3 0ms
         */
        for (int i = 0; i < nums.length; i += 2) {
            nums[0] ^= nums[i] ^ nums[i + 1];
        }

        return nums[0];
    }

    public int singleNumber4(int[] nums) {
        /**
         * 三个月之前写的代码 141ms 10.33%
         */
        if (nums.length == 1)
            return nums[0];
        ArrayList<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            if (temp.contains(num))
                temp.remove((Integer) num);
            else
                temp.add(num);
        }

        return (int) temp.get(0);
    }
}