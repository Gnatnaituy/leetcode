package classify.array;

/**
 * @author yutiantang
 * @create 2021/10/21 10:05
 */
public class TheLackNumber {

    /**
     * 遍历
     * 0ms      100.00%
     * 38.9MB   51.57%
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    /**
     * 二分查找
     * 0ms      100.00%
     * 39MB     18.26%
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 位运算
     * 0ms      100.00%
     * 39MB     29.28%
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
       int xor = 0;
       for (int i = 0; i < nums.length; i++) {
           xor ^= nums[i] ^ (i + 1);
       }
       return xor;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber2(new int[]{1,2,3,4}));
        System.out.println(missingNumber2(new int[]{0,1,2,3}));
        System.out.println(missingNumber2(new int[]{0,1,2,4}));
    }
}
