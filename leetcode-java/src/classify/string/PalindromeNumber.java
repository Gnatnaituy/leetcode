package classify.string;

public class PalindromeNumber {

    /**
     * 6ms 100.00%
     * 34.6MB 86.32%
     */
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;

        int right = 0;
        while (right < x) {
            right = right * 10 + x % 10;
            x /= 10;
        }

        return x == right || x == right / 10;
    }
}
