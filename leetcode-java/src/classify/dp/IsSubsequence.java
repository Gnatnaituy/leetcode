package classify.dp;

public class IsSubsequence {

    /**
     * 0ms 100.00%
     * 48.3MB 94.55%
     */
    public boolean isSubsequence(String s, String t) {
        int index = -1;

        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 1ms      81.62%
     * 355.8MB  99.81%
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length()) {
            while (tIndex < t.length() && t.charAt(tIndex) != s.charAt(sIndex)) {
                tIndex++;
            }
            if (tIndex >= t.length()) {
                return false;
            }
            sIndex++;
            tIndex++;
        }

        return true;
    }
}
