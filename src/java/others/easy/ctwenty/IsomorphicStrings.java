package java.others.easy.ctwenty;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 203 Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 */

public class IsomorphicStrings {

    /**
     * 56ms 7.36%
     */
    private static boolean isIsomorphic(String s, String t) {
        return Arrays.equals(generalTerm(s), generalTerm(t));
    }


    private static int[] generalTerm(String s) {
        ArrayList<Character> distinct = new ArrayList<>();
        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (!distinct.contains(s.charAt(i)))
                distinct.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            result[i] = distinct.indexOf(s.charAt(i));
        }

        return result;
    }

    /**
     * 6ms
     */
    public static boolean isIsomorphic2(String s, String t) {
        int[] ms = new int[256];
        int[] mt = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (ms[s.charAt(i)] != mt[t.charAt(i)]) return false;
            ms[s.charAt(i)] = i + 1;
            mt[t.charAt(i)] = i + 1;
        }

        return true;
    }

    /**
     * 1ms
     */
    public static boolean isIsomorphic3(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] map = new int[512];

        for (int i = sc.length - 1; i >= 0; i--) {
            if (map[sc[i]] != map[tc[i] + 256]) return false;
            map[sc[i]] = map[tc[i] + 256] = i;
        }

        return true;
    }
}
