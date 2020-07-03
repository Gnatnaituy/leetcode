package others.easy.btwenty;


/**
 * 125 Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */

public class ValidPalindrome {

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return true;

        StringBuilder only = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))
                only.append(s.charAt(i));
        }

        String result = only.toString().toLowerCase();
        int length = result.length();
        while (length > result.length() / 2) {
            if (result.charAt(length - 1) != result.charAt(result.length() - length))
                return false;
            length--;
        }
        return true;
    }
}
