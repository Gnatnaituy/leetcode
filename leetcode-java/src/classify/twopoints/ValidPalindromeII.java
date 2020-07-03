package classify.twopoints;

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

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }

        return true;
    }
}
