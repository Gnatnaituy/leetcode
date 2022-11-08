package classify.dp.medium;

public class DecodeWays {

    /**
     * O(n)     0ms     100.00%
     * O(n)     39.9MB  33.72%
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            int temp = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (temp >= 10 && temp <= 26) {
                dp[i] += (i >= 2 ? dp[i - 2] : 1);
            }
        }

        return dp[s.length() - 1];
    }
}
