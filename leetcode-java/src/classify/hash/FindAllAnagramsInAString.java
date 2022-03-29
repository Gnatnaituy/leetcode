package classify.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    /**
     * 7ms      85.22%
     * 42.4MB   38.42%
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return res;
        }

        int pLen = p.length();
        int sLen = s.length();
        int[] pCounter = new int[26];
        int[] sCounter = new int[26];

        for (char c : p.toCharArray()) {
            pCounter[c - 'a']++;
        }
        for (int i = 0; i < pLen - 1; i++) {
            sCounter[s.charAt(i) - 'a']++;
        }

        for (int i = pLen; i < sLen; i++) {
            sCounter[s.charAt(i) - 'a']++;
            if (isAnagrams(sCounter, pCounter)) {
                res.add(i - pLen + 1);
            }
            sCounter[s.charAt(i - pLen + 1) - 'a']--;
        }

        return res;
    }

    /**
     * 7ms      85.22%
     * 42.1MB   62.68%
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return res;
        }

        int[] pCounter = new int[26];
        for (char c : p.toCharArray()) {
            pCounter[c - 'a']++;
        }

        int[] sCounter = new int[26];
        int left = 0, right = 0, pLen = p.length(), index;
        while (right < s.length()) {
            index = s.charAt(right) - 'a';
            if (pCounter[index] == 0) {
                Arrays.fill(sCounter, 0);
                left = right + 1;
            } else {
                sCounter[index]++;
                if (right - left + 1 == pLen) {
                    if (isAnagrams(sCounter, pCounter)) {
                        res.add(left);
                    }
                    sCounter[s.charAt(left) - 'a']--;
                    left++;
                }
            }
            right++;
        }

        return res;
    }

    private boolean isAnagrams(int[] sCounter, int[] pCounter) {
        for (int i = 0; i < 26; i++) {
            if (sCounter[i] != pCounter[i]) {
                return false;
            }
        }

        return true;
    }
}
