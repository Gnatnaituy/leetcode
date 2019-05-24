package classify.string;

public class LongestPalindrome {

    /**
     * 1ms 100.00%
     * 34.8MB 91.34%
     */
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        int res = 0;

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (int c : count) {
            res += (c / 2) * 2;
        }

        return res < s.length() ? res + 1 : res;
    }
}
