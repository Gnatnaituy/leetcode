package java.completefifties.l0000;

public class ScrumbleString {

    /**
     * 7ms 71.12%
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;

        if (s1.length() != s2.length()) return false;

        //判定是否含有非共有元素
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int item : count) if (item != 0) return false;

        //递归判定
        for (int i = 1; i < s1.length(); i++) {
            String s1Left = s1.substring(0, i), s1Right = s1.substring(i);
            String s2Left = s2.substring(0, i), s2Right = s2.substring(i);
            if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)) return true;
            s2Left = s2.substring(s1.length() - i);
            s2Right = s2.substring(0, s1.length() - i);
            if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)) return true;
        }

        return false;
    }
}
