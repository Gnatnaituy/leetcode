package classify.twopoints;

/**
 * @author yutiantang
 * @create 2021/3/28 4:59 PM
 */
public class SortColors {

    /**
     * 0ms      100.00%
     * 36.9MB   70.03%
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, cur = 0;
        while (cur <= right) {
            if (nums[cur] == 2) {
                // 和右边交换，交换后nums[cur]可能还是2，所以不能cur++
                nums[cur] = nums[right];
                nums[right--] = 2;
            } else if (nums[cur] == 0) {
                // 和左边交换，此时nums[cur]只可能是0或1，所以能cur++
                nums[cur++] = nums[left];
                nums[left++] = 0;
            } else {
                cur++;
            }
        }
    }
}
