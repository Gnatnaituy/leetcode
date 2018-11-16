package easy.threetwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 203 Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */

public class IsomorphicStrings {

    private static boolean isIsomorphic(String s, String t) {
        return Arrays.equals(generalTerm(s), generalTerm(t));
    }


    private static int[] generalTerm(String s) {
        ArrayList<Character> distinct = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!distinct.contains(s.charAt(i)))
                distinct.add(s.charAt(i));
        }
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = distinct.indexOf(s.charAt(i));
        }
        return result;
    }
}
