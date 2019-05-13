package classify.search.permutation;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    /**
     * 7ms 35.64%
     * 38.2MB 93.42%
     */
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        List<StringBuilder> resBuilder = new ArrayList<>();
        resBuilder.add(new StringBuilder());

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                for (StringBuilder resB : resBuilder) {
                    resB.append(S.charAt(i));
                }
            } else {
                List<StringBuilder> copy = new ArrayList<>(resBuilder);
                resBuilder = new ArrayList<>();
                for (StringBuilder resB : copy) {
                    StringBuilder sb = new StringBuilder(resB);
                    sb.append(Character.toLowerCase(S.charAt(i)));
                    resBuilder.add(sb);
                    sb = new StringBuilder(resB);
                    sb.append(Character.toUpperCase(S.charAt(i)));
                    resBuilder.add(sb);
                }
            }
        }

        for (StringBuilder sb : resBuilder) {
            res.add(sb.toString());
        }

        return res;
    }

    /**
     * 3ms
     */
    public List<String> letterCasePermutation2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;

        dfs(s, res, 0, "");

        return res;
    }

    private void dfs(String s, List<String> res, int index, String sb) {
        if (index == s.length()) {
            res.add(sb);
            return;
        }

        char c = s.charAt(index);
        if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            dfs(s, res, index + 1, sb + c);
        } else {
            dfs(s, res, index + 1, sb + Character.toUpperCase(c));
            dfs(s, res, index + 1, sb + Character.toLowerCase(c));
        }
    }
}
