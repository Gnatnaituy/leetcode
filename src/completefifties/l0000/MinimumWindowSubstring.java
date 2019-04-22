package completefifties.l0000;

import java.util.TreeMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int length = s.length() + 1;
        String res = "";

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        TreeMap<Character, Integer> tmap = new TreeMap<>();  //记录t中的内容
        TreeMap<Character, Integer> smap = new TreeMap<>();  //记录滑动窗口中的内容

        for (char c : ct) {
            if (!tmap.containsKey(c)) {
                tmap.put(c, 1);
            } else {
                tmap.put(c, tmap.get(c) + 1);
            }
        }

        int count = 0;  //当count=t.length()时，表示窗口中包含了t中的所有元素
        int start = 0, end = 0;  //窗口的两个边界 [start, end]
        for (; end < s.length(); end++) {
            if (!smap.containsKey(cs[end])) {
                smap.put(cs[end], 1);
            } else {
                smap.put(cs[end], smap.get(cs[end]) + 1);
            }

            if (tmap.containsKey(cs[end]) && smap.get(cs[end]) <= tmap.get(cs[end])) {
                count++;
            }

            //当窗口中包含了t中的所有元素时，需要缩小左边界
            while (count == t.length()) {
                if (end - start + 1 < length) {
                    length = end - start + 1;
                    res = s.substring(start, end + 1);
                }

                smap.put(cs[start], smap.get(cs[start]) - 1);
                if (tmap.containsKey(cs[start]) && smap.get(cs[start]) < tmap.get(cs[start])) {
                    count--;
                }

                start++;
            }
        }

        return res;
    }
}
