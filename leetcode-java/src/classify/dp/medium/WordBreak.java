package classify.dp.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /**
     * 超出时间限制
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
     * O(n^2)   8ms      35.77%
     * O(n)     41.7MB   34.51%  
     * 可以类比于背包问题
     * memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分 
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        int strLen = s.length();
        boolean[] memo = new boolean[strLen + 1];
        memo[0] = true;

        for (int i = 1; i <= strLen; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[strLen];
    }

    /**
     * O(n^2)   1ms     99.62%
     * O(n)     39.5MB  95.88MB
     * 优化可拆分点查找范围
     * 上一个可拆分点一定在最长单词覆盖的范围内 
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        int strLen = s.length();
        boolean[] memo = new boolean[strLen + 1];
        int maxWordLen = wordDict.stream().mapToInt(o -> o.length()).max().getAsInt();
        Set<String> wordSet = new HashSet<>(wordDict);
        memo[0] = true;

        for (int i = 1; i <= strLen; i++) {
            for (int j = Math.max(0, i - maxWordLen); j < i; j++) {
                if (memo[j] && wordSet.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[strLen];
    }
}
