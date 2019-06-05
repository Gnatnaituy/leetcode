package java.others.easy.gtwenty;


/**
 * 541 Reverse String II
 *
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 *
 * Example: Input: s = "abcdefg", k = 2 Output: "bacdfeg"
 *
 * Restrictions: The string consists of lower English letters only. Length of
 * the given string and k will in the range [1, 10000]
 */

public class ReverseStringII {

    private static String reverseStr(String s, int k) {

        class Utils {
            void reverse(char[] str, int start, int end) {
                while (start < end) {
                    char temp = str[start];
                    str[start] = str[end];
                    str[end] = temp;
                    start++; end--;
                }
            }
        }

        Utils utils = new Utils();
        int length = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i < length; i += 2 * k) {
            if (i + k >= length) {
                utils.reverse(str, i, length - 1);
            } else {
                utils.reverse(str, i, i + k - 1);
            }
        }

        return new String(str);
    }
}
