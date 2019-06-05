package java.classify.dp;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 1ms 49.76%
     * 32.8MB 100.00%
     */
    public int integerBreak(int n) {
        if (n < 3) return 1;

        int res = 0;
        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (map.containsKey(i - j)) {
                    res = Math.max(res, map.get(i - j) * j);
                } else {
                    res = Math.max(res, integerBreak(i - j) * j);
                    map.put(j, res);
                }
            }
        }

        return res;
    }

    /**
     * 0ms
     */
    public int integerBreak2(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int timeOf3 = n / 3;
        if (n - 3 * timeOf3 == 1) timeOf3--;
        int timeOf2 = (n - 3 * timeOf3) / 2;

        return (int) (Math.pow(3, timeOf3)) * (int) (Math.pow(2, timeOf2));
    }

    /**
     * dp
     */
    public int integerBreak3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }

        return dp[n];
    }
}
