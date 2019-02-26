package others.easy.btwenty;

/**
 * 168 Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 *
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 *
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */

public class ExcelSheetColumnTitle {

    private static String convertToTitle(int n) {
        String numStr = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
        StringBuilder result = new StringBuilder();

        int rest = n;
        while (rest != 0) {
            if (rest % 26 == 0)
                rest -= 26;
            result.append(numStr.charAt(rest % 26));
            rest /= 26;
        }

        return result.reverse().toString();
    }
}
