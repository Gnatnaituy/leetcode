package classify.array;

/**
 * @Author tiantang
 * @Date 2021/11/25
 */
public class ProductOfArrayExceptSelf {

    /**
     * 1ms      100.00%
     * 49MB     55.86%
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1;
        int[] sums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sums[i] = left;
            left *= nums[i];
        }

        for (int j = nums.length - 1; j > -1; j--) {
            sums[j] *= right;
            right *= nums[j];
        }

        return sums;
    }
}
