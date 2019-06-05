package java.classify.search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    /**
     * 20ms 90.80%
     * 37.7MB 98.89%
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        beginSet.add(beginWord);
        endSet.add(endWord);

        if (!dict.contains(endWord)) return 0;

        int step = 1;
        while (!beginSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> set = new HashSet<>();
            for (String word : beginSet) {
                char[] cs = word.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char old = cs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        cs[i] = c;
                        String s = new String(cs);
                        if (endSet.contains(s)) return step + 1;
                        if (dict.contains(s)) set.add(s);
                    }
                    cs[i] = old;
                }
            }
            beginSet = set;
            step++;
        }

        return 0;
    }
}
