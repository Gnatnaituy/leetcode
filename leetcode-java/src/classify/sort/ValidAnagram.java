package classify.sort;

import java.util.Arrays;

/**
 * @author yutiantang
 * @create 2021/4/15 22:30
 */
public class ValidAnagram {

    /**
     * 3ms      87.63%
     * 38.09NB  31.19%
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }

        return true;
    }
}
