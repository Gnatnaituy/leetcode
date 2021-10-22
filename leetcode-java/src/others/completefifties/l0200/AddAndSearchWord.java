package others.completefifties.l0200;

import java.util.HashMap;
import java.util.HashSet;

public class AddAndSearchWord {
    private HashMap<Integer, HashSet<String>> words;

    /**
     * 187ms 80.60%
     * 65MB 83.87%
     */
    public AddAndSearchWord() {
        this.words = new HashMap<>();
    }

    public void addWord(String word) {
        HashSet<String> nthWords = words.getOrDefault(word.length(), new HashSet<>());
        nthWords.add(word);
        words.put(word.length(), nthWords);
    }

    public boolean search(String word) {
        HashSet<String> nthWords = words.getOrDefault(word.length(), null);

        if (nthWords == null)
            return false;

        for (String s : nthWords) {
            if (equalWord(s, word))
                return true;
        }

        return false;
    }

    private boolean equalWord(String s, String word) {
        if (s.length() != word.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (word.charAt(i) == '.')
                continue;
            if (word.charAt(i) != s.charAt(i))
                return false;
        }

        return true;
    }
}
