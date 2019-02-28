package discover.algorithm.elementary.others;


/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列
 * 找出 0 .. n 中没有出现在序列中的那个数
 */
public class MissingNumber {

    /**
     * 1ms 99.53%
     * 用从 0 累加到 nums.length + 1 的和减去数组的和
     */
    public int missingNumber(int[] nums) {
        int numsSum = 0;
        int sum = 0;

        for (int num : nums) {
            numsSum += num;
        }

        if (nums.length % 2 == 0) {
            sum = nums.length * nums.length / 2 + nums.length / 2;
        } else {
            sum = (nums.length + 1) * nums.length / 2;
        }

        return sum - numsSum;
    }

    /**
     * 0ms
     * 思路一样, 代码更优雅
     */
    public int missingNumber2(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return nums.length * (nums.length + 1) / 2 - sum;
    }
}
