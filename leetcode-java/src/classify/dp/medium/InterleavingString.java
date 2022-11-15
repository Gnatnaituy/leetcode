package classify.dp.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InterleavingString {

    /**
     * O(n^2)   2ms     93.63%
     * O(n^2)   41.7MB  5.02%
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Map<Integer, Boolean> mem = new HashMap<>();

        return interleave(mem, s1, 0, s2, 0, s3, 0);
    }

    private boolean interleave(Map<Integer, Boolean> mem, String s1, int index1, String s2, int index2, String s3, int index3) {
        if (index1 == s1.length() && index2 == s2.length() && index3 == s3.length()) {
            return true;
        }
        int identifier = index1 * 1000000 + index2 * 1000 + index3;
        if (mem.containsKey(identifier)) {
            return mem.get(identifier);
        }

        boolean res = false;
        if (index1 == s1.length()) {
            res = Objects.equals(s3.substring(index3), s2.substring(index2));
        } else if (index2 == s2.length()) {
            res = Objects.equals(s3.substring(index3), s1.substring(index1));
        } else {
            char c1 = s1.charAt(index1);
            char c2 = s2.charAt(index2);
            char c3 = s3.charAt(index3);
            if (c1 == c3 && c2 == c3) {
                res = interleave(mem, s1, index1 + 1, s2, index2, s3, index3 + 1)
                        || interleave(mem, s1, index1, s2, index2 + 1, s3, index3 + 1);
            } else if (c1 == c3) {
                res = interleave(mem, s1, index1 + 1, s2, index2, s3, index3 + 1);
            } else if (c2 == c3) {
                res = interleave(mem, s1, index1, s2, index2 + 1, s3, index3 + 1);
            }
        }
        mem.put(identifier, res);

        return res;
    }

    /**
     * O(m*n)   3ms     67.36%
     * O(m*n)   39.9MB  28.28%
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 + len2 != s3.length()) return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int index1 = 0; index1 <= len1; ++index1) {
            for (int index2 = 0; index2 <= len2; ++index2) {
                int index3 = index1 + index2 - 1;
                if (index1 > 0) {
                    dp[index1][index2] = dp[index1][index2] || (dp[index1 - 1][index2] && s1.charAt(index1 - 1) == s3.charAt(index3));
                }
                if (index2 > 0) {
                    dp[index1][index2] = dp[index1][index2] || (dp[index1][index2 - 1] && s2.charAt(index2 - 1) == s3.charAt(index3));
                }
            }
        }

        return dp[len1][len2];
    }
}
