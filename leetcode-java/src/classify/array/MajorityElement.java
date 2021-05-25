package classify.array;

import java.util.*;

/**
 * @author yutiantang
 * @create 2021/5/25 21:35
 */
public class MajorityElement {

    /**
     * 14ms     14.33%
     * 43.3%    44.79%
     * 统计
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        return count.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    /**
     * 2ms      65.72%
     * 44.1MB   21.48%
     * 排序
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 2ms      65.72%
     * 44.5MB   8.41%
     * 随机挑选一个下标，检查它是否是众数，如果是就返回，否则继续随机挑选
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        Random random = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int randomNum = nums[random.nextInt(nums.length)];
            if (countNum(nums, randomNum) > majorityCount) {
                return randomNum;
            }
        }
    }

    private int countNum(int[] nums, int num) {
        int count = 0;
        for (int nu : nums) {
            if (nu == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 2ms      65.72%
     * 44.1MB   21.41%
     * 分治
     * @param nums
     * @return
     */
    public int majorityElement4(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (high - low) / 2 + low;
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid + 1, high);
        if (left == right) {
            return left;
        }

        int leftCount = countNumInRange(nums, left, low, high);
        int rightCount = countNumInRange(nums, right, low, high);

        return leftCount > rightCount ? left : right;
    }

    private int countNumInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 3ms      36.31%
     * 44.3MB   16.40%
     * Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public int majorityElement5(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
