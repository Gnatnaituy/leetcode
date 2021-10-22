package others.completefifties.l0000;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        //dp[i][j]表示字符串s的前i个字符可以由p的前j个字符表示
        boolean[][] dp = new boolean[ls + 1][lp + 1];

        /*
        3 conditions that dp[i][j] = true
        1. dp[i-1][j-1] = true && s.charAt(i-1) = p.charAt(j-1)
        2. dp[i][j-1]   = true && p.charAt(j-1) = "*"
        3. dp[i-1][j]   = true && p.charAt(j-1) = "*"
        */
        dp[0][0] = true;
        for (int i = 1; i <= lp; i++) {
            if (dp[0][i - 1] && p.charAt(i - 1) == '*')
                dp[0][i] = true;
        }

        for (int i = 1; i <= ls; i++) {
            for (int j = 1; j <= lp; j++) {
                if (p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if ((dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1))
                        || (dp[i][j - 1] && p.charAt(j - 1) == '*')
                        || (dp[i - 1][j] && p.charAt(j - 1) == '*')) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[ls][lp];
    }
}
