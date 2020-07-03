package others.easy.gtwenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 500 Keyboard Row
 *
 * Given a List of words, return the words that can be typed using letters of alphabet
 *  on only one row's of American keyboard like the image below.
 *
 *  Example:
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 */

public class KeyboardRow {

    private static String[] findWords(String[] words) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        String[] s = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        for (int i = 0; i < s.length; i++) {
            char[] a = s[i].toCharArray();
            for (char anA : a) {
                hashMap.put(anA, i);
            }
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            char[] str = word.toLowerCase().toCharArray();
            int x = hashMap.get(str[0]);
            boolean flag = true;
            for (char a : str) {
                if (hashMap.get(a) != x) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(word);
        }

        return res.toArray(new String[0]);
    }

}
