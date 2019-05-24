package classify.string;

public class IsomorphicStrings {

    /**
     * 3ms 95.96%
     * 36.5MB 65.98%
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }

        return true;
    }
}
