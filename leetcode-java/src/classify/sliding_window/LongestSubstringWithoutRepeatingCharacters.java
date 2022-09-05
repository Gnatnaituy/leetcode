package classify.sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 9ms      40.47%
     * 39.3MB   5.34%
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
     * 思路, 寻找两个相邻相同的字母的最大间距
     * 如果字母只有一个,则是0到字母的距离
     * 2ms      99.89%
     * 38.3MB   75.28%
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] previous = new int[128];
        Arrays.fill(previous, -1);

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            start = Math.max(start, previous[c] + 1);
            res = Math.max(res, i - start + 1);
            previous[c] = i;
        }

        return res;
    }

    /**
     * 2ms      99.89%
     * 38.1MB   94.55%
     * 滑动窗口+快慢指针 空格真坑人 还以为全是小写字母
     */
    public static int lengthOfLongestSubstring3(String s) {
        boolean[] exiChar = new boolean[256];
        char[] chars = s.toCharArray();
        int slow = 0, fast = 0, max = 0;
        for (char c : chars) {
            if (exiChar[c]) {
                while (slow < fast && chars[slow] != c) {
                    exiChar[chars[slow]] = false;
                    slow++;
                }
                slow++;
            }
            fast++;
            exiChar[c] = true;
            max = Math.max(max, fast - slow);
        }

        return max;
    }

    /**
     * 6ms      40.85%
     * 41.5MB   57.25%
     * 双指针 + 哈希表解法（滑动窗口） 宫水三叶
     */
    public int lengthOfLongestSubstring4(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                char l = s.charAt(i);
                map.put(l, map.get(l) - 1);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
