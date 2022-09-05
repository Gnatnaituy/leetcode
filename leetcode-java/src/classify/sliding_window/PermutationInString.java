package classify.sliding_window;


public class PermutationInString {

    /**
     * 3ms 99.85%
     * 36.3MB 99.48%
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];

        for(char c : s1.toCharArray()) count[c]--;
        // 用👇句会从3ms -> 41ms
        // s1.chars().forEach(c -> count[c]--);

        for (int left = 0, right = 0; right < s2.length(); right++) {
            if (++count[s2.charAt(right)] > 0) {
                while (--count[s2.charAt(left)] != 0) {
                    left++;
                }
            } else if ((right - left + 1) == s1.length()) {
                return true;
            }
        }

        return s1.length() == 0;
    }
}
