package others.discover.datastructure.binarysearch;


/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数
 * <p>
 * 说明：
 * 不能更改原数组（假设数组是只读的）
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindTheDuplicateNumber {

    /**
     * 1ms 93.40%
     * 不满足O(1)空间
     */
    public int findDuplicate(int[] nums) {
        int[] times = new int[nums.length];

        for (int num : nums) {
            if (times[num] == 0) times[num] = 1;
            else return num;
        }

        return -1;
    }

    /**
     * 0ms
     */
    public int findDuplicate2(int[] nums) {
        int result, p = 0, q = 0;
        do {
            p = nums[p];
            q = nums[nums[q]];
        } while (p != q);

        p = 0;
        while (true) {
            p = nums[p];
            q = nums[q];
            if (p == q) {
                result = p;
                break;
            }
        }

        return result;
    }

    /**
     * 4ms
     */
    public int findDuplicate3(int[] nums) {
        int low = 1, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) >> 1;
            int count = 0;
            for (int num : nums) if (num <= mid) count++;
            if (count > mid) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}
