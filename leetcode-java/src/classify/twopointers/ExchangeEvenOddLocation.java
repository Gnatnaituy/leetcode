package classify.twopointers;

/**
 * @Author tiantang
 * @Date 2021/10/29
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class ExchangeEvenOddLocation {

    /**
     * 2ms      81.32%
     * 46.4MB   38.24%
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 0) {
                while (end > start && nums[end] % 2 == 0) {
                    end--;
                }
                if (start < end) {
                    int tmp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = tmp;
                }
            }
            start++;
        }

        return nums;
    }
}
