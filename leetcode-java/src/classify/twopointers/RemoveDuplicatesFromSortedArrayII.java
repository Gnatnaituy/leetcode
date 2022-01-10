package classify.twopointers;

/**
 * @author yutiantang
 * @create 2021/3/28 5:39 PM
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * 1ms      80.57%
     * 38.6MB   61.12%
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int slow = 0, fast = 1, slowCount = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                if (slowCount == 2) {
                    // 当slow重复了两次 但是fast还是与slow相同时，则需要寻找到下一位不同的值
                    while (fast < nums.length && nums[fast] == nums[slow]) {
                        fast++;
                    }
                    if (fast == nums.length) {
                        return slow + 1;
                    }
                    slowCount = 0;
                }
            } else {
                slowCount = 0;
            }
            slowCount++;
            nums[++slow] = nums[fast++];
        }

        return slow + 1;
    }

    /**
     * 0ms      100.00%
     * 39.8MB   47.59%
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }

        return ++slow;
    }
}
