package others.afifty;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 3. Longest Substring Without Repeating Characters
 */

public class LongestSubstringWithoutRepeatingCharacters {

    private int lengthOfLongestSubstring(String s) {
        
        // 58ms 63.56%
        Queue<Character> queue = new ArrayDeque<>();
        char[] S = s.toCharArray();
        int res = 0, tempMax = 0;

        for (char c : S) {
            if (!queue.contains(c)) {
                queue.add(c);
                tempMax += 1;
            } else {
                while (queue.contains(c))
                    queue.poll();
                queue.add(c);
                res = res > tempMax ? res : tempMax;
                tempMax = queue.size();
            }
        }

        return queue.size() > res ? queue.size() : res;
    }

    /**
     * 18ms
     */
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int left = 0;
        int right = 0;

        for (; right < s.length(); ++right) {
            char rightC = s.charAt(right);
            for (int index = left; index < right; ++index) {
                if (s.charAt(index) == rightC) {
                    max = (right - left) > max ? (right - left) : max;
                    left = index + 1;
                    break;
                }
            }
        }
        max = (right - left) > max ? (right - left) : max;

        return max;
    }
}
