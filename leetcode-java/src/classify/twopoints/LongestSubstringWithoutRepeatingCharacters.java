package classify.twopoints;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yutiantang
 * @create 2021/3/28 3:47 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 9ms      40.47%
     * 39.3MB   5.34%
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();
        Set<Character> views = new HashSet<>();
        views.add(chars[0]);
        int slow = 0, fast = 1, max = 1;
        while (fast < chars.length) {
            if (views.contains(chars[fast])) {
                max = Math.max(max, fast - slow);
                while (chars[slow] != chars[fast]) {
                    views.remove(chars[slow++]);
                }
                views.remove(chars[slow++]);
            }
            views.add(chars[fast]);
            fast++;
        }

        return Math.max(max, fast - slow);
    }

    /**
     * 2ms大佬的解法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
