package classify.dp;

public class LongestPalindromeSubsequence {

    /**
     * 22ms 76.71%
     * 47.6MB 36.52%
     * dp[left][right]: the longest palindromic subsequence's length of substring(left, right)
     *
     * State transition:
     * dp[left][right] = dp[left+1][right-1] + 2 if s.charAt(left) == s.charAt(right)
     * otherwise, dp[left][right] = Math.max(dp[left+1][right], dp[left][right-1])
     * Initialization: dp[left][left] = 1
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int left = s.length() - 1; left >= 0; left--) {
            dp[left][left] = 1;
            for (int right = left + 1; right < s.length(); right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left + 1][right - 1] + 2;
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    /**
     * 25ms 51.67%
     * 51.8MB 5.81%
     * Top bottom recursive method with memoization
     */
    public int longestPalindromeSubseq2(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }

    private int helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) return memo[i][j];
        if (i > j) return 0;
        if (i == j) return 1;

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }

        return memo[i][j];
    }
}
