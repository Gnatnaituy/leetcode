package easy.onetwenty;


/**
 * 66 Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */

public class Agg_PlusOne {

    private static int[] plusOne(int[] digits) {
        int[] a = {};
        return a;
    }

    public static void main(String[] args) {

        int[] input = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        int[] result = plusOne(input);
        for (int a : result)
            System.out.print(a);
    }
}
