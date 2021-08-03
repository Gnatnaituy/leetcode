package classify.math;

/**
 * @author yutiantang
 * @create 2021/8/3 16:53
 */
public class PalindromeNumber {

    /**
     * 10ms     62.51%
     * 38.2MB   14.67%
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        char[] digits = Integer.valueOf(x).toString().toCharArray();
        int left = 0, right = digits.length - 1;
        while (left < right) {
            if (digits[left++] != digits[right--]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 11ms     42.39%
     * 37.8MB   58.04%
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        int result = 0;
        if (x < 0) {
            return false;
        }

        int y = x;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result == y;
    }
}
