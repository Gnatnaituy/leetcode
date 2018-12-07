package easy.atwenty;


/**
 * 66 Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

public class PlusOne {

    private static int[] plusOne(int[] digits) {
        int inOne = 1;
        while (inOne > 0) {
            if (digits[digits.length - inOne] + 1 == 10) {
                digits[digits.length - inOne] = 0;
                if (inOne == digits.length) {
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    for (int i = 1; i < newDigits.length; i++)
                        newDigits[i] = 0;
                    digits = newDigits;
                    break;
                }
                inOne++;
            } else {
                digits[digits.length - inOne] += 1;
                inOne = 0;
            }
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] input1 = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        int[] input2 = {5, 9, 9, 9};
        int[] input3 = {9, 9, 9, 9};
        int[] result1 = plusOne(input1);
        int[] result2 = plusOne(input2);
        int[] result3 = plusOne(input3);
        for (int a : result1)
            System.out.print(a + " ");
        System.out.println();
        for (int a : result2)
            System.out.print(a + " ");
        System.out.println();
        for (int a : result3)
            System.out.print(a + " ");
        System.out.println();
    }
}
