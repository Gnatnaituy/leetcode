package easy.ctwenty;

/**
 * 171  Excel Sheet Column Number
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 */

public class ExcelSheetColumnNumber {

    private static int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - 64) * Math.pow(26, s.length() - i - 1);
        }
        return sum;
    }
}
