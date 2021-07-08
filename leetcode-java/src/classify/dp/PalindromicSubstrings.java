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

    /**
     * 8ms      51.42%
     * 38.3MB   45.08%
     *
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int res = 0;
        boolean[][] dp = new boolean[len][len];

        for (int right = 0; right < len; right++) {
            for (int left = right; left >= 0; left--) {
                dp[left][right] = chars[left] == chars[right] && (right - left < 3 || dp[left + 1][right - 1]);
                if (dp[left][right]) {
                    res++;
                }
            }
        }

        return res;
    }
}
