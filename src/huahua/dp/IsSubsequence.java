package huahua.dp;

public class IsSubsequence {

    /**
     * 0ms 100.00%
     * 48.3MB 94.55%
     */
    public boolean isSubsequence(String s, String t) {
        int index = -1;

        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }

        return true;
    }
}
