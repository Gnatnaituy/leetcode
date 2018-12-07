package easy.ftwenty;

/**
 * 459 Repeated Substring Pattern
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

public class RepeatedSubstringPattern {

    private static boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for(int i = 1; i <= len / 2; i++) { // Max length
            if(len % i == 0) {
                String tem = str.substring(0, i); // Substring
                StringBuffer sb = new StringBuffer();
                for(int j = 0; j < len / i; j++) sb = sb.append(tem); // generate the same length
                if(sb.toString().equals(str)) // Verify
                    return true;
            }
        }
        return false;
    }
}
