package classify.recursion;

/**
 * @author yutiantang
 * @create 2021/4/9 21:29
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * 1ms      91.68%
     * 36MB     99.78%
     * 官方题解
     * 对于字符串s，如果存在某个字符ch，它的出现次数大于0且小于k，则任何包含ch的子串都不可能满足要求。
     * 也就是说，我们将字符串按照ch切分成若干段，
     * 则满足要求的最长子串一定出现在某个被切分的段内，而不能跨越一个或多个段。
     * 因此，可以考虑分治的方式求解本题。
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }

        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }

        return ret;
    }

    /**
     * 9ms      27.24%
     * 38.8MB   14.98%
     * 网友版分治
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring2(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        // 统计所有的字母出现个数
        for (int c : s.toCharArray()) {
            cnt[c - 'a'] ++;
        }
        // 定义一个字符串，用于传入split函数分割当前字符串
        StringBuilder cut = new StringBuilder();
        cut.append("[");
        // 定义一个标志，用于标记是否所有字符都满足要求
        boolean flag = true;
        // 遍历所有字符
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                // 这个字符不满足要求，并且加入分割串
                flag = false;
                cut.append("//");
                cut.append((char)(i + 'a'));
            }
        }
        // 所有字符都满足要求的话，就直接返回字符串长度
        if (flag) {
            return n;
        }

        cut.append("]");
        // 切割当前字符串，得到被切割的子串数组
        String[] cuted = s.split(cut.toString());

        int res = 0;
        for (String c : cuted) {
            // 递归处理子串
            res = Math.max(longestSubstring2(c, k), res);
        }

        return res;
    }
}
