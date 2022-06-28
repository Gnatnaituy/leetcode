package classify.string;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {

    /**
     * 8ms      34.19%
     * 41.1MB   49.25%
     */
    public String swapWords(String s) {
        if (s == null) return null;

        List<String> words = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        s = s.trim();

        Collections.addAll(words, s.split("\\s+"));

        if  (words.size() == 0) return "";

        for (int i = words.size() - 1; i >= 0; i--) {
            res.append(words.get(i));
            if (i > 0) res.append(" ");
        }

        return res.toString();
    }

    /**
     * 3ms      86.92%
     * 41.2MB   43.24%
     */
    public String reverseWords2(String s) {
        if (s.length() < 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char blank = ' ';
        int fast = s.length() - 1, slow = s.length() - 1;
        while (fast > 0) {
            while (fast > 0 && s.charAt(fast) == blank) {
                fast--;
                slow--;
            }
            if (fast == 0 && s.charAt(fast) == blank) {
                break;
            }
            while (fast > 0 && s.charAt(fast) != blank) {
                fast--;
            }
            if (fast > 0 || s.charAt(fast) == blank) {
                sb.append(s, fast + 1, slow + 1).append(blank);
            } else {
                sb.append(s, fast, slow + 1).append(blank);
            }
            slow = fast;
        }

        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 2ms      96.89%
     * 41.3MB   34.93%
     */
    public String reverseWords3(String s) {
        if (s.length() < 2) {
            return s;
        }

        char[] chars = s.toCharArray();
        int realLen = removeSpace(chars);
        swapChars(chars, 0, realLen - 1);
        swapWords(chars, 0, realLen - 1);

        return new String(chars, 0, realLen);
    }

    private int removeSpace(char[] chars) {
        // 移除前面的空格
        int slow = 0, fast = 0;
        while (chars[fast] == ' ') fast++;
        // 移除中间的空格
        while (fast < chars.length) {
            if (fast > 0 && chars[fast] == ' ' && chars[fast - 1] == ' ') {
                fast++;
            } else {
                chars[slow++] = chars[fast++];
            }
        }
        // 移除后面的空格
        if (slow > 1 && chars[slow - 1] == ' ') {
            return slow - 1;
        } else {
            return slow;
        }
    }

    private void swapWords(char[] chars, int start, int realLen) {
        int slow = 0, fast = 0;
        while (fast < realLen) {
            while (fast < realLen && chars[fast] != ' ') {
                fast++;
            }
            swapChars(chars, slow, fast == realLen ? realLen : fast - 1);
            fast++;
            slow = fast;
        }
    }

    private void swapChars(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
