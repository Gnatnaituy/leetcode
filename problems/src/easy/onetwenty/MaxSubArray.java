package easy.onetwenty;

public class MaxSubArray {

    private static int maxSubArray(int[] nums) {
        int maxScore = Integer.MIN_VALUE;
        int now = 0;

        for (int num : nums) {
            if (num > maxScore) {
                maxScore = num;
            }
            if (now + num > 0) {
                now = now + num;
                if (now > maxScore) {
                    maxScore = now;
                }
            } else {
                now = 0;
            }
        }

        return maxScore;
    }
}
