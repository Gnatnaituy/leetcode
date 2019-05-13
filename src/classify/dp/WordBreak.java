package classify.dp;

import java.util.List;

public class WordBreak {

    /**
     * 4ms 86.58%
     * 377.3MB 57.45%
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (flag[j] && wordDict.contains(s.substring(j, i))) {
                    flag[i] = true;
                }
            }
        }

        return flag[s.length()];
    }
}
