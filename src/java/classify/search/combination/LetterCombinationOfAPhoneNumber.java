package java.classify.search.combination;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
    private List<String> result = new ArrayList<>();
    private String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 1ms 89.02%
     * 37.2MB 67.52%
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }

        bt(digits, 0, "");

        return result;
    }

    private void bt(String digits, int i, String str) {
        if (str.length() == digits.length()) {
            result.add(str);
            return;
        }

        int index = Integer.parseInt(String.valueOf(digits.charAt(i)));

        for (char c : letters[index].toCharArray()) {
            str += c;
            bt(digits, i + 1, str);
            str = str.substring(0, str.length() - 1);
        }
    }
}
