package classify.twopoints;

/**
 * @author yutiantang
 * @create 2021/3/24 11:36 PM
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 0;
            }
        }
        return max;
    }
}
