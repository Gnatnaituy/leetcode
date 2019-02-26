package others.easy.dtwenty;

import java.util.HashMap;

/**
 * 242 Valid Anagram
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class ValidAnagram {

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i)))
                sMap.replace(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            else
                sMap.put(s.charAt(i), 1);

            if (tMap.containsKey(t.charAt(i)))
                tMap.replace(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            else
                tMap.put(t.charAt(i), 1);
        }

        return sMap.equals(tMap);
    }
}
