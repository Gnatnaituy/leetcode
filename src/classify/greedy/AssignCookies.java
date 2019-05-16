package classify.greedy;

import java.util.Arrays;

public class AssignCookies {

    /**
     * 8ms 99.78%
     * 39.5MB 87.07%
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gc = 0;
        int sc = 0;

        while (gc < g.length && sc < s.length) {
            if (g[gc] <= s[sc]) {
                gc++;
            }
            sc++;
        }

        return gc;
    }
}
