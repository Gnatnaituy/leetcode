package classify.dp;

public class PalindromicSubstrings {

    /**
     * 6ms 55.49%
     * 35.3MB 54.31%
     */
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    res++;
                }
            }
        }

        return res;
    }
}
