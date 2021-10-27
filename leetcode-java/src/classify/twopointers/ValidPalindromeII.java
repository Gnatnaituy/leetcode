package classify.twopointers;

public class ValidPalindromeII {

    /**
     * 10ms 67.77%
     * 36.6MB 100.00%
     */
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        int left = 0;
        int right = s.length() -1;

        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * 4ms 64.03%
     * 38.7MB 23.73%
     */
    public boolean validPalindrome2(String s) {
        char[] validChars = new char[s.length()];
        int length = 0;
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                validChars[length++] = Character.toLowerCase(c);
            }
        }

        int start = 0, end = length - 1;
        while (start < end) {
            if (validChars[start++] != validChars[end--]) {
                return false;
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }

        return true;
    }
}
