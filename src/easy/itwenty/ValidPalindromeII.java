package easy.itwenty;

/**
 * 680 Valid Palindrome II
 * 
 * Given a non-empty string s, you may delete at most one character.
 *  Judge whether you can make it a palindrome.
 * Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:
The string will only contain lowercase characters a-z. 
The maximum length of the string is 50000.
 */

public class ValidPalindromeII {
    private static boolean ValidPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            String left = s.substring(i + 1, j + 1);
            String right = s.substring(i, j);
            return left.equals(new StringBuilder(left).reverse().toString()) ||
                    right.equals(new StringBuilder(right).reverse().toString());
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abbbbbbfa";
        System.out.println(ValidPalindrome(s));
    }
}