package easy.ktwenty;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 819 Most Common Word
 */

public class MostCommonWord {
    
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String[] words = paragraph.split("[!?',;. ]+");
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedWords = new HashSet<>();
        Collections.addAll(bannedWords, banned);
        int max = Integer.MIN_VALUE;
        String res = "";
        
        for (String word : words) {
            map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max && !bannedWords.contains(entry.getKey())) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        
        return res;
    }
}
