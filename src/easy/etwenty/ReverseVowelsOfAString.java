package easy.etwenty;

/**
 * 345 Reverse Vowels of a String
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 * Note:
 * The vowels does not include the letter "y".
 */

public class ReverseVowelsOfAString {

    private static String reverseVowels(String s) {
        char[] charS = s.toCharArray();
        int left = 0, right = charS.length - 1;
        while (left < right) {
            if (!isVowel(charS[left])) {
                left++;
                continue;
            }
            if (!isVowel(charS[right])) {
                right--;
                continue;
            }
            char temp = charS[left];
            charS[left] = charS[right];
            charS[right] = temp;
            left++;
            right--;
        }
        return new String(charS);
    }

    private static boolean isVowel(Character c) {
        return c.equals('a') || c.equals('e') || c.equals('i') || c.equals('o') || c.equals('u')
                || c.equals('A') || c.equals('E') || c.equals('I') || c.equals('O') || c.equals('U');
    }
}
