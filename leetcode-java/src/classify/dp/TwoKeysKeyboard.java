package classify.dp;

public class TwoKeysKeyboard {

    /**
     * 21ms 32.72%
     * 32.2MB 100.00%
     */
    public int minStep(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }

        return dp[n];
    }

    /**
     * 0ms
     */
    public int minSteps(int n) {
        int res = 0, d = 2;

        while (n > 1) {
            while (n % d == 0) {
                res += d;
                n /= d;
            }
            d++;
        }

        return res;
    }
}
