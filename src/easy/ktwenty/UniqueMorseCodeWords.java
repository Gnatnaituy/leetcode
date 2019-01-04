package easy.ktwenty;

import java.util.ArrayList;
import java.util.List;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentation(String[] words) {
        String[] morse = {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                "...", "-","..-","...-",".--","-..-","-.--","--.."};
        List<String> res = new ArrayList<>();
        for (String word1 : words) {
            StringBuilder one = new StringBuilder();
            for (char word : word1.toCharArray())
                one.append(morse[word - 'a']);
            String theOne = one.toString();
            if (!res.contains(theOne))
                res.add(theOne);
        }
        
        return res.size();
    }
}
