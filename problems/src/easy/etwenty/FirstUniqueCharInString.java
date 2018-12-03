package easy.etwenty;

/**
 * 387 First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */

public class FirstUniqueCharInString {

    private static int firstUniqChar(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length(); i++) {
            String temp = stringBuilder.substring(i, i + 1);
            if (stringBuilder.indexOf(temp) == stringBuilder.lastIndexOf(temp))
                return i;
        }
        return -1;
    }
}
