package easy.ktwenty;

import java.util.Arrays;
import java.util.List;

/**
 * 824 Goat Latin
 */

public class GoatLatin {

    public String toGoatLatin(String S) {
        String[] s = S.split(" ");
        StringBuilder res = new StringBuilder();
        StringBuilder vowels = new StringBuilder("aeiouAEIOU");
        
        for (int i = 0; i < s.length; i++) {
            StringBuilder word;
            if (vowels.indexOf(s[i].charAt(0) + "") != -1) {
                word = new StringBuilder(s[i] + "ma");
            } else {
                word = new StringBuilder(s[i].substring(1) + s[i].substring(0, 1) + "ma");
            }
            for (int j = 0; j < i + 1; j++) {
                word.append("a");
            }
            res.append(word).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        
        return res.toString();
    }
}
