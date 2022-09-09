package classify.sliding_window;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * 0ms      100.00%
     * 39MB     98.25%
     * 分治 官方题解
     * 对于字符串s，如果存在某个字符c，它的出现次数大于0且小于k，则任何包含ch的子串都不可能满足要求。
     * 也就是说，我们将字符串按照c切分成若干段，则满足要求的最长子串一定出现在某个被切分的段内，而不能跨越一个或多个段。
     */
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int left, int right, int k) {
        int[] count = new int[26];
        for (int i = left; i <= right; i++) {
            count[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }

        if (split == 0) {
            return right - left + 1;
        }

        int i = left;
        int res = 0;
        while (i <= right) {
            while (i <= right && s.charAt(i) == split) {
                i++;
            }
            if (i > right) {
                break;
            }
            int start = i;
            while (i <= right && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            res = Math.max(res, length);
        }

        return res;
    }

    /**
     * 3ms      64.7%
     * 39.8MB   55.19%
     * 枚举+双指针 宫水三叶
     */
    public int longestSubstring2(String s, int k) {
        int res = 0;
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] count = new int[26];
        for (int p = 1; p <= 26; p++) {
            Arrays.fill(count, 0);
            // tot 代表 [j, i] 区间所有的字符种类数量；sum 代表满足「出现次数不少于 k」的字符种类数量
            for (int i = 0, j = 0, tot = 0, sum = 0; i < n; i++) {
                int u = cs[i] - 'a';
                count[u]++;
                // 如果添加到 cnt 之后为 1，说明字符总数 +1
                if (count[u] == 1) tot++;
                // 如果添加到 cnt 之后等于 k，说明该字符从不达标变为达标，达标数量 + 1
                if (count[u] == k) sum++;
                // 当区间所包含的字符种类数量 tot 超过了当前限定的数量 p，那么我们要删除掉一些字母，即「左指针」右移
                while (tot > p) {
                    int t = cs[j++] - 'a';
                    count[t]--;
                    // 如果添加到 cnt 之后为 0，说明字符总数-1
                    if (count[t] == 0) tot--;
                    // 如果添加到 cnt 之后等于 k - 1，说明该字符从达标变为不达标，达标数量 - 1
                    if (count[t] == k - 1) sum--;
                }
                // 当所有字符都符合要求，更新答案
                if (tot == sum) res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
