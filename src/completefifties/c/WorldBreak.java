package completefifties.c;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorldBreak {

    /**
     * 可以得出正解, 但超出时间限制
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (String word : wordSet) {
            minLength = minLength < word.length() ? minLength : word.length();
            maxLength = maxLength > word.length() ? maxLength : word.length();
        }

        return s.length() >= minLength && helper(s, minLength, maxLength, wordSet);
    }

    private static boolean helper(String s, int minLen, int maxLen, Set<String> wordSet) {
        if (s.length() == 0) return true;

        for (int i = minLen; i <= (maxLen > s.length() ? s.length() : maxLen); i++) {
            if (wordSet.contains(s.substring(0, i))) {
                if (helper(s.substring(i), minLen, maxLen, wordSet)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 17ms, 51.87%
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[n];
    }

    /**
     * 2ms
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        int n = s.length(), max_len = 0;
        for (String str : wordDict) {
            max_len = str.length() > max_len ? str.length() : max_len;
        }
        boolean[] v = new boolean[n + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        v[0] = true;
        for (int i = 1; i <= n; i++) {
            int j = max_len >= i ? 0 : i - max_len;
            for (; j < i; j++) {
                if (v[j] && wordSet.contains(s.substring(j, i))) {
                    v[i] = true;
                    break;
                }
            }
        }

        return v[n];
    }

}
