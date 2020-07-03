package others.easy.jtwenty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 720 Longest World in Dictionary
 */

public class LongestWorldInDictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words);

        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }
}