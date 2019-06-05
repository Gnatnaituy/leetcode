package java.classify.twopoints;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

    /**
     * 14ms 64.56%
     * 36.7MB 95.20%
     */
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<>();
        String res = "";

        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }

        return res;
    }
}
