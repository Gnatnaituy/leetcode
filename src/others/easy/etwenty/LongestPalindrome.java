package others.easy.etwenty;

/**
 * 409 Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

public class LongestPalindrome {

    private static int longestPalindrome(String s) {

//        int originalLength = s.length();
//        int result = 0;
//        StringBuilder sBuilder = new StringBuilder(s);
//        while (sBuilder.length() > 0) {
//            char first = sBuilder.charAt(0);
//            sBuilder.deleteCharAt(0);
//            if (sBuilder.indexOf("" + first) != -1) {
//                sBuilder.deleteCharAt(sBuilder.indexOf("" + first));
//                result += 2;
//            }
//        }
//        if (result < originalLength)
//            return result + 1;
//        else
//            return result;

        int max = 'z' - 'A' + 1;
        int[] mark = new int[max];
        int maxLen = 0;
        char[] s1 = s.toCharArray();
        for (char aS1 : s1) {
            mark[aS1 - 'A']++;
        }

        boolean flag = false;
        for (int i = 0; i < max; i++) {
            if (mark[i] != 0) {
                if (mark[i] % 2 == 0) {
                    maxLen += mark[i];
                } else {
                    if (mark[i] >= 1) {
                        flag = true;
                        maxLen += mark[i] - 1;
                    }
                }
            }
        }

        return flag ? maxLen + 1 : maxLen;
    }
}
