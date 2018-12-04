package easy.gtwenty;

/**
 * 504 Base 7
 *
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 *
 * Example 2:
 * Input: -7
 * Output: "-10"
 *
 * Note: The input will be in range of [-1e7, 1e7].
 */

public class BaseSeven {

    private static String convertToBaseSeven(int num) {
        StringBuilder res = new StringBuilder();

        boolean isNegative = false;

        if (num < 0) {
            num = -num;
            isNegative = true;
        }

        while (num / 7 != 0) {
            res.append(num % 7);
            num /= 7;
        }
        res.append(num);

        if (isNegative) res.append('-');

        return res.reverse().toString();
    }
}
