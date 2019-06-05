package java.classify.twopoints;

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
}
