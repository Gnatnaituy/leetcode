package easy.onefifty;

/**
 * 38 Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */

public class Adi_CountAndSay {

    private static String countAndSay(int n) {

        StringBuilder result = new StringBuilder();
        StringBuilder tempResult = new StringBuilder("1");

        if (n == 1) {
            return "1";
        }
        for (int i = 1; i < n; i++) {
            int count = 0;
            int index = 0;
            char previousChar = tempResult.charAt(0);
            result = new StringBuilder();

            while (index < tempResult.length()) {
                if (tempResult.charAt(index) == previousChar) {
                    count++;
                    index++;
                } else {
                    result.append(count);
                    result.append(previousChar);
                    previousChar = tempResult.charAt(index);
                    count = 1;
                    index++;
                }
            }
            result.append(count);
            result.append(previousChar);

            tempResult = result;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
