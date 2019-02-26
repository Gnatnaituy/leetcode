package others.easy.etwenty;

/**
 * 415 Add Strings
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class AddStrings {

    private static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int num1Len = num1.length();
        int num2Len = num2.length();
        int add = 0, sum;

        while (num1Len > 0 && num2Len > 0) {
            sum = Character.getNumericValue(num1.charAt(num1Len - 1))
                    + Character.getNumericValue(num2.charAt(num2Len - 1)) + add;
            result.append(sum % 10);
            add = sum / 10;
            num1Len--;
            num2Len--;
        }

        if (num1Len > 0) {
            for (int i = num1Len; i > 0; i--) {
                sum = Character.getNumericValue(num1.charAt(num1Len - 1)) + add;
                result.append(sum % 10);
                add = sum / 10;
            }
        } else if (num2Len > 0) {
            for (int i = num2Len; i > 0; i--) {
                sum = Character.getNumericValue(num2.charAt(num2Len - 1)) + add;
                result.append(sum % 10);
                add = sum / 10;
            }
        }

        if (add > 0)
            result.append(add);

        return result.reverse().toString();
    }
}
