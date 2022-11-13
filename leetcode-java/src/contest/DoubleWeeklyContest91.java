package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DoubleWeeklyContest91 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length / 2; i++) {
            res.add(nums[i] + nums[nums.length - i - 1]);
        }

        return res.size();
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high];
        long sum;
        for (int i = Math.min(zero, one) - 1; i < high; i++) {
            sum = 0;
            if (i >= zero - 1) {
                sum += (i - zero > -1 ? dp[i - zero] + 1 : 1);
            }
            if (i >= one - 1) {
                sum += (i - one > -1 ? dp[i - one] + 1 : 1);
            }
            dp[i] = sum % 100000000000000000L;
        }

        long max = dp[high - 1];
        long min = dp[Math.max(low - 2, 0)];

        if (max < min) max += 100000000000000000L;

        return (int) ((max - min) % 1000000007);
    }

    public static void main(String[] args) {
        DoubleWeeklyContest91 a = new DoubleWeeklyContest91();
        System.out.println(a.countGoodStrings(200,200,10,1)); // 764262396
        System.out.println(a.countGoodStrings(500,500,5,2));  // 873327137
    }
}
