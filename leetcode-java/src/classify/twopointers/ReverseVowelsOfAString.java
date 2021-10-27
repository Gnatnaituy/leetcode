package classify.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    private static final Set<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    /**
     * 5ms 56.24%
     * 36.2MB 97.11%
     */
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] res = new char[s.length()];

        while (left <= right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            if (!vowels.contains(cLeft)) {
                res[left++] = cLeft;
            } else if (!vowels.contains(cRight)) {
                res[right--] = cRight;
            } else {
                res[left++] = cRight;
                res[right--] = cLeft;
            }
        }

        return new String(res);
    }

    /**
     * 3ms      89.11%
     * 38.4MB   87.86
     * @param s
     * @return
     */
    public String reverseVowels2(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (isVowel(chars[left]) && isVowel(chars[right])) {
                char swap = chars[left];
                chars[left] = chars[right];
                chars[right] = swap;
                left++;
                right--;
            } else {
                if (!isVowel(chars[left])) {
                    left++;
                }
                if (!isVowel(chars[right])) {
                    right--;
                }
            }
        }

        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U';
    }
}
