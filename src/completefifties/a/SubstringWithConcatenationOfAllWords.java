package completefifties.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    
    /**
     * 30. Substring with Concatenation of All Words
     */
    private List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;
        int wl = words[0].length();
        int allc = words.length;
        int tl = wl * allc;
        HashMap<String, Integer> wc = new HashMap<>();
        HashMap<String, Integer> temp = new HashMap<>();
        String firstWord, part;
        
        for (String word : words) {
            wc.put(word, wc.getOrDefault(word, 0) + 1);
            if (word.isEmpty()) {
                for (int i = 0; i <= s.length(); i++) {
                    res.add(i);
                }
                return res;
            }
        }
        
        for (int i = 0, j = 0, k = 0; i < wl; i++) {
            temp.clear();
            j = i;
            k = 0;
            while (j < s.length()) {
                while (k < tl && j + k + wl <= s.length()) {
                    part = s.substring(j + k, j + k + wl);
                    if (wc.containsKey(part)) {
                        temp.put(part, temp.getOrDefault(part, 0) + 1);
                        if (temp.get(part) > wc.get(part)) {
                            // move until valid
                            while (temp.get(part) > wc.get(part)) {
                                firstWord = s.substring(j, j + wl);
                                temp.put(firstWord, temp.getOrDefault(firstWord, 0) - 1);
                                k -= wl;
                                j += wl;
                            }
                        }
                        k += wl;
                    } else {
                        // comes out illegal part
                        temp.clear();
                        j = j + k + wl;
                        k = 0;
                    }
                }
                // all match
                if (k == tl) {
                    res.add(j);
                    firstWord = s.substring(j, j + wl);
                    temp.put(firstWord, temp.getOrDefault(firstWord, 0) - 1);
                    k -= wl;
                }
                j += wl;
            }
        }
        return res;
    }
}
