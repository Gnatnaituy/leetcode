package classify.twopointers;

/**
 * @author yutiantang
 * @create 2021/3/25 10:11 PM
 */
public class RotateArray {

    /**
     * 最垃圾的方法
     * 使用一个临时变量储存最后一个元素
     * 所有元素往后移动1位， 循环k次
     * 231ms    19.73%
     * 39MB     47.83%
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int swap;
        int len = nums.length;
        while (k-- > 0) {
            swap = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1);
            nums[0] = swap;
        }
    }

    /**
     * 优化1
     * k可能大于nums的长度，先求余，避免多余的移动
     * 267ms    8.43%
     * 39.1MB   21.46%
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int swap;
        int len = nums.length;
        k = k % len;
        while (k-- > 0) {
            swap = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1);
            nums[0] = swap;
        }
    }

    /**
     * 优化2
     * 将最后k位储存起来， 剩下的元素一次性后移k位，
     * 最后将储存起来的k位数放到数组开头
     * 0ms      100.00%
     * 38.8MB   76.70%
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] temp = new int[k];
        System.arraycopy(nums, len - k, temp,0, k);
        System.arraycopy(nums, 0, nums, k, len - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }

    /**
     * 声明一个和nums等长的数组
     * 先将后k位数放入开头，再将前len - k位数放入后面
     * 0ms      100.00%
     * 39MB     33.80%
     * @param nums
     * @param k
     */
    public static void rotate4(int[] nums, int k) {
        int[] copyNums = new int[nums.length];
        int len = nums.length;
        k = k % len;
        System.arraycopy(nums, len - k, copyNums, 0, k);
        System.arraycopy(nums, 0, copyNums, k, len - k);
        System.arraycopy(copyNums, 0, nums, 0, len);
    }
}
