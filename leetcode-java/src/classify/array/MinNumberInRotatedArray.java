package classify.array;

/**
 * @author yutiantang
 * @create 2021/10/21 18:43
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class MinNumberInRotatedArray {

    /**
     * 遍历
     * 0ms      100.00%
     * 38MB     86.43%
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int res = Integer.MAX_VALUE;
        for (int num : numbers) {
            res = Math.min(res, num);
        }

        return res;
    }

    /**
     * 二分
     * 0ms      100.00%
     * 38.3ms   31.94%
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        if (numbers== null || numbers.length == 0) {
            return 0;
        }

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[right] > numbers[mid]) {
                right = mid;
            } else if (numbers[right] < numbers[mid]){
                left = mid + 1;
            } else {
                right--; // 去重
            }
        }

        return numbers[left];
    }
}
