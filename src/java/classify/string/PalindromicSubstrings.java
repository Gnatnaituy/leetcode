package java.classify.string;

public class PalindromicSubstrings {
    private int res;

    /**
     * 1ms 100.00%
     * 33.3MB 100.00%
     */
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);          // odd length
            extendPalindrome(s, i, i + 1);// even length
        }

        return res;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            res++;
        }
    }
}
