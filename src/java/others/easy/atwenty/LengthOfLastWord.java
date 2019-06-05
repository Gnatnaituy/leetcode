package java.others.easy.atwenty;

/**
 * 58 Length of Last word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */

public class LengthOfLastWord {

    private static int lengthOfLastWord(String s) {
//        int max = 0;
//        int now = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' ') {
//                max = now > max ? now : max;
//                now = 0;
//            } else {
//                now++;
//            }
//        }
//
//        return now > max ? now : max;

        int last = 0, lastWordLength = 0;
        for (int i = 0; i < s.length(); i++) {
            last = s.charAt(i) == ' ' ? 0 : last + 1;
            lastWordLength = last == 0 ? lastWordLength : last;
        }
        return lastWordLength;
    }

    public static void main(String[] args) {
        String a = "qwe qwer qweqw qw qwe ";
        System.out.print(lengthOfLastWord(a));
    }
}
