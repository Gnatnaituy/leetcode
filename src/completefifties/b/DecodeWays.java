package completefifties.b;

public class DecodeWays {

    /**
     * 3ms 54.71%
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0')
            return 0;

        int[] dp = new int[s.length()];

        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') dp[i] = dp[i - 1];
            int temp = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (temp >= 10 && temp <= 26) dp[i] += (i >= 2 ? dp[i - 2] : 1);
        }

        return dp[s.length() - 1];
    }

    /**
     * 1ms
     */
    public int numDecodings2(String s) {
        if (s.length() < 1) return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int count = 2; count <= s.length(); count++) {
            int a = s.charAt(count - 2) - '0';
            int b = s.charAt(count - 1) - '0';
            if (b > 0) dp[count] += dp[count - 1];
            if (10 * a + b <= 26 && (10 * a + b) >= 10) dp[count] += dp[count - 2];
        }

        return dp[s.length()];
    }
}
