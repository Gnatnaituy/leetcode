package classify.dp;

public class LongestPalindromicSubstring {

    /**
     * Two Pointer
     * 7ms 86.20%
     * 35MB 99.50%
     */
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int left = i;
            int right = i;

            while (left >= 0 && s.charAt(left) == c)
                left--;

            while (right < s.length() && s.charAt(right) == c)
                right++;

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }

            if (end - start < right - (left + 1)) {
                start = left + 1;
                end = right;
            }
        }

        return s.substring(start, end);
    }

    /**
     * DP
     * 54ms 33.26%
     * 38.1MB 57.43%
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        String res = "";
        boolean[][] dp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && ("".equals(res) || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    /**
     * 40ms     58.75%
     * 42MB     48.87%
     */
    public String longestPalindrome3(String s) {
        String res = "";
        int currLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currLength - 1, i)) {
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            } else if (isPalindrome(s, i - currLength, i)) {
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }

        return res;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) return false;

        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}