package classify.dp;

/**
 * @author yutiantang
 * @create 2021/10/26 16:36
 * 剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class TranslateNumberToString {

    /**
     * 0ms      100.00%
     * 35MB     88.89%
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            char prev = nums[i - 1];
            if ((prev < '2' && prev > '0') || (prev == '2' && nums[i] < '6')) {
                res[i] = res[i - 1] + (i < 2 ? 1 : res[i - 2]);
            } else {
                res[i] = res[i - 1];
            }
        }

        return res[res.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
