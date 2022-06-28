package classify.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yutiantang
 * @create 2021/3/28 3:47 PM
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 9ms      40.47%
     * 39.3MB   5.34%
     *
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
     * 思路, 寻找两个相邻相同的字母的最大间距
     * 如果字母只有一个,则是0到字母的距离
     * 2ms      99.89%
     * 38.3MB   75.28%
     *
     * @param s
     * @return
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
     * 快慢指针 空格真坑人 还以为全是小写字母
     *
     * @param s
     * @return
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

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("aabaab!bb"));
    }
}
