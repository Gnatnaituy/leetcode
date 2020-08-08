package contest;

import java.util.*;

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/8 22:16
 * @Description Double20200808
 */
public class Double20200808 {

    public int findKthPositive(int[] arr, int k) {
        int cur = 1;
        for (int val : arr) {
            while (val > cur) {
                k--;
                if (k == 0) return cur;
                cur++;
            }
            cur++;
        }
        while (k-- > 1) cur++;

        return cur;
    }

    public static boolean canConvertString(String s, String t, int k) {
        if (s == null || t == null || s.length() != t.length()) return false;

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] diff = new int[sc.length];
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] < tc[i]) {
                diff[i] = tc[i] - sc[i];
            } else if (sc[i] > tc[i]) {
                diff[i] = 26 - (sc[i] - tc[i]);
            }
        }
        Map<Integer, Integer> singleCount = new HashMap<>();
        for (int d : diff) {
            if (d != 0) {
                singleCount.put(d, singleCount.getOrDefault(d, 0) + 1);
            }
        }
        Map<Integer, Integer> dupMax = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : singleCount.entrySet()) {
            dupMax.put(entry.getValue(), Math.max(dupMax.getOrDefault(entry.getValue(), 0), entry.getKey()));
        }
        List<Integer> dups = new ArrayList<>(dupMax.keySet());
        Collections.sort(dups);
        if (dups.size() == 0) return true;
        if (dups.size() == 1) {
            if (dups.get(0) < 2) {
                return dupMax.get(dups.get(0)) <= k;
            } else {
                return (dups.get(0) - 1) * 26 + dupMax.get(dups.get(0)) <= k;
            }
        }

        return (dups.size() - 1) * 26 + dupMax.get(dups.get(dups.size() - 1)) + 26 - dupMax.get(dups.get(dups.size() - 2)) <= k;
    }

    public static void main(String[] args) {
        String s = "zxcasdas";
        String t = "asdasddd";

        System.out.println(canConvertString(s, t, 9));
    }
}
