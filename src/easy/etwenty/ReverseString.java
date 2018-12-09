package easy.etwenty;

/**
 * 344 Reverse String
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */

public class ReverseString {

    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
