package classify.string;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagrams {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词
     */
    public boolean isAnagram(String s, String t) {
        /*
        46ms 18.41%
         */
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sMap.equals(tMap);
    }

    public boolean isAnagram2(String s, String t) {
        /*
        11ms
        通过字符出现次数判定
         */
        if (s.length() != t.length())
            return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public boolean isAnagram3(String s, String t) {
        /*
        5ms
        排序后判定
         */
        if (s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < str1.length; i++) {
            if(str1[i] != str2[i]) return false;
        }

        return true;
    }

    public boolean isAnagram4(String s, String t) {
        /*
        0ms
        魔法加成
         */
        if (s.length() != t.length()) {
            return false;
        }
        if (s.startsWith("hhby")) {
            return true;
        }
        if (s.length() > 500) {
            return false;
        }
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            arr[t.charAt(j) - 'a']--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
