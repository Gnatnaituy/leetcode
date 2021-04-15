package classify.sort;

/**
 * @author yutiantang
 * @create 2021/4/15 22:37
 */
public class SortArrayByParityII {

    /**
     * 3ms      81.42%
     * 40.1MB   55.25%
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int[] odd = new int[len / 2];
        int[] even = new int[len / 2];
        int oddCur = 0;
        int evenCur = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                even[evenCur++] = num;
            } else {
                odd[oddCur++] = num;
            }
        }

        oddCur = 0;
        evenCur = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                nums[i] = even[evenCur++];
            } else {
                nums[i] = odd[oddCur++];
            }
        }

        return nums;
    }

    /**
     * 官方题解 优化 去掉奇偶数组
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int i = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[i] = num;
                i += 2;
            }
        }
        i = 1;
        for (int num : nums) {
            if (num % 2 == 1) {
                res[i] = num;
                i += 2;
            }
        }

        return res;
    }

    /**
     * 3ms      81.42%
     * 39.3MB   97.93%
     * 官方题解 双指针
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII3(int[] nums) {
        int n = nums.length;
        int j = 1;

        for (int i = 0; i < n; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                swap(nums, i, j);
            }
        }

        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
