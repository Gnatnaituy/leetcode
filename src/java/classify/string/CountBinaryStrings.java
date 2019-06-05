package java.classify.string;

public class CountBinaryStrings {

    /**
     * 17ms 35.00%
     * 36.9MB 98.9%
     */
    public int countBinaryStrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) != s.charAt(i)) {
                int left = i;
                int right = i + 1;
                while (left >= 0 && right < s.length()
                        && s.charAt(left) == s.charAt(i)
                        && s.charAt(right) == s.charAt(i + 1)) {
                    res++;
                    left--;
                    right++;
                }
            }
        }

        return res;
    }
}
