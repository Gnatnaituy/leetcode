package huahua.dp;

public class MinimumASCIIDeleteSumForTwoStrings {

    /**
     * 23ms 20.98%
     * 36MB 96.55MB
     */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    int a = 0;
                    for (int k = 1; k <= Math.max(i, j); k++)
                        a += i == 0 ? s2.charAt(k - 1) : s1.charAt(k - 1);
                    dp[i][j] = a;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j], s2.charAt(j - 1) + dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 12ms
     */
    public int minimumDeleteSum2(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = s1.codePointAt(i) + dp[i + 1][s2.length()];
        }

        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = s2.codePointAt(j) + dp[s1.length()][j + 1];
        }

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i), dp[i][j + 1] + s2.codePointAt(j));
                }
            }
        }

        return dp[0][0];
    }
}
