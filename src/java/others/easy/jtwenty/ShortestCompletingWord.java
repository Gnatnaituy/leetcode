package java.others.easy.jtwenty;

import java.util.ArrayList;
import java.util.List;

/**
 * 748 Shortest Completing Word
 */

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] licensePlates = licensePlate.toLowerCase().toCharArray();
        List<Character> reWord = new ArrayList<>();
        for (char ch : licensePlates) {
            if ((int) (ch - 96) > 0 && (int) (ch - 96) < 27) {
                reWord.add(ch);
            }
        }
        String result = null;
        for (String word : words) {
            List<Character> removeChars = new ArrayList<>(reWord);
            for (char c : word.toCharArray()) {
                if (removeChars.contains(c)) {
                    removeChars.remove(removeChars.indexOf(c));
                }
            }
            if (removeChars.size() == 0) {
                if (result == null) {
                    result = word;
                } else {
                    if (word.length() < result.length()) {
                        result = word;
                    }
                } 
            }
        }

        return result;
    }
}