package easy.onetwenty;


/**
 * 67 Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

public class AddBinary {

    private static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int enterOne = 0;

        if (a.length() > b.length()) {
            StringBuilder c = new StringBuilder(b).reverse();
            for (int i = 0; i < a.length() - b.length(); i++)
                c.append('0');
            b = c.reverse().toString();
        } else if (b.length() > a.length()) {
            StringBuilder c = new StringBuilder(a).reverse();
            for (int i = 0; i < b.length() - a.length(); i++)
                c.append('0');
            a = c.reverse().toString();
        }

        int i = a.length();
        while (i > 0) {
            int sum = enterOne + ((int) a.charAt(i - 1) - 48) + ((int) b.charAt(i - 1) - 48);
            switch (sum) {
                case 0:
                    enterOne = 0; i--;
                    result.append('0');
                    break;
                case 1:
                    enterOne = 0; i--;
                    result.append('1');
                    break;
                case 2:
                    enterOne = 1; i--;
                    result.append('0');
                    break;
                case 3:
                    enterOne = 1; i--;
                    result.append('1');
                    break;
                default:break;
            }
        }
        if (enterOne == 1)
            return result.append('1').reverse().toString();
        else
            return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "100";
        String b = "110010";
        System.out.println(addBinary(a, b));
    }
}
