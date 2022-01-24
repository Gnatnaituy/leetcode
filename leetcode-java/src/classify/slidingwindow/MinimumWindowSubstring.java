package classify.slidingwindow;


public class MinimumWindowSubstring {

    /**
     * 18ms    35.6%
     * 38.7MB  64.11%
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] target = new int[58], count = new int[58];
        t.chars().forEach(c -> target[c - 65]++);

        int left = 0, right = 0, len, minLen = Integer.MAX_VALUE;
        String minWindow = s;
        while (right <= s.length() && left < s.length()) {
            len = right - left + (right == s.length() ? 0 : 1);
            if (len < t.length() || notCover(count, target)) {
                if (right == s.length()) {
                    break;
                }
                count[s.charAt(right) - 65]++;
                right++;
            } else {
                if (len < minLen) {
                    minLen = len;
                    minWindow = s.substring(left, right);
                }
                count[s.charAt(left) - 65]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : minWindow;
    }

    public static boolean notCover(int[] count, int[] target) {
        for (int i = 0; i < 58; i++) {
            if (count[i] < target[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("AbCC", "AbCC"));
    }
}
