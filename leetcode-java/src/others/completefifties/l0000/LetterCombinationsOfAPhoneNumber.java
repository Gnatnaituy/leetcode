package others.completefifties.l0000;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */

public class LetterCombinationsOfAPhoneNumber {

    private List<String> letterCombinations(String digits) {
        char[][] letters = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        char[] digit = digits.toCharArray();
        List<String> res = new ArrayList<>();
    
        for (char c1 : digit) {
            if (res.size() == 0) {
                for (char c : letters[c1 - 50]) {
                    res.add(Character.toString(c));
                }
            } else {
                int size = res.size();
                while (size > 0) {
                    String temp = res.remove(0);
                    for (char c : letters[c1 - 50]) {
                        res.add(temp + c);
                    }
                    size--;
                }
            }
        }
        
        return res;
    }
}
