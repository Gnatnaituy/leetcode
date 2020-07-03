package classify.dp;

public class OnesAndZeroes {

    /**
     * Time Limit Exceeded
     */
    public int findMaxForm(String[] strs, int m, int n) {

        return dp(strs, strs.length - 1, m, n);
    }

    private int dp(String[] strs, int index, int m, int n) {
        if (index < 0 || m < 0 || n < 0) {
            return 0;
        }

        int[] onesAndZeroes = countOnesAndZeroes(strs[index]);

        if (m < onesAndZeroes[0] || n < onesAndZeroes[1]) {
            return dp(strs, index - 1, m, n);
        } else {
            return Math.max(dp(strs, index - 1, m - onesAndZeroes[0], n - onesAndZeroes[1]) + 1,
                            dp(strs, index - 1, m, n));
        }
    }

    private int[] countOnesAndZeroes(String s) {
        int[] res = {0, 0};

        for (char c : s.toCharArray()) {
            if (c == '0') res[0]++;
            if (c == '1') res[1]++;
        }

        return res;
    }

    /**
     * 22ms 68.63%
     * 35MB 99.61%
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int[] count = count(s);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }

    public int[] count(String str) {
        int[] res = new int[2];

        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - '0']++;
        }

        return res;
    }
}
