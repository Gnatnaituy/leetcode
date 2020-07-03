package others.discover.algorithm.elementary.array;

public class RotateArray {

    /**
     * 解法1 131ms 超过28.27%
     * 向右移动, 空间复杂度为O(1)的原地算法
     * 输入 [1, 2, 3, 4, 5, 6, 7, 8] k = 3
     * 输出 [6, 7, 8, 1, 2, 3, 4, 5]
     * 每次向后挪一次, 执行k次
     */
    public void rotate(int[] nums, int k) {
        while (k > 0) {
            int len = nums.length;
            int temp = nums[len - 1];
            while (len > 1) {
                nums[len - 1] = nums[len - 2];
                len--;
            }
            nums[0] = temp;
            k--;
        }
    }

    /**
     * 解法2 0ms  超过100%
     * 1.将数组反转
     * 2.将前k个元素反转
     * 3.将剩下的元素反转
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(0, n-1, nums);
        reverse(0, k-1, nums);
        reverse(k, n-1, nums);
    }

    public void reverse(int l, int r, int[] nums) {
        while (l < r) {
            int t = nums[l];
            nums[l++] = nums[r];
            nums[r--] = t;
        }
    }
}
