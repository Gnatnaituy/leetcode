package easy.sixtwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438 Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class FindAllAnagramsInAString {

    private static List<Integer> findAnagrams(String s, String p) {

        // timeout lol.....
//        List<Integer> result = new ArrayList<>();
//        if (s.length() == 0 || p.length() == 0 || s.length() < p.length())
//            return null;
//        for (int i = 0; i < s.length() - p.length() + 1; i++) {
//            if (isAnagrams(s.substring(i, i + p.length()), p))
//                result.add(i);
//        }
//        return result;


        /*
         滑动窗口法, 定义两个指针lo和hi表示窗口的左端和右端, 一个counter=p.length作为指示
         从右端开始右滑, 遇到一个p内的字符就将counter减1, 如果counter变为0判断窗口是否满足要求
         一旦窗口大小等于p的长度, 需要删去左端点字符, 删去时需要考虑是否要将counter加1
         */
        List<Integer> ret = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if(s.length() < p.length()) return ret;
        int[] map = new int[26];
        for(char ch : p.toCharArray())
            map[ch-'a']++;

        int counter = p.length();  // 指示条件, 如果counter被减为0需要判断窗口内的字符是否满足要求
        int lo = 0, hi = 0;
        char[] ss = s.toCharArray();

        while(hi < m) {
            // 每次都要向右移动一次hi, 如果hi对应的字符出现次数大于等于1说明该字符在p中, 将counter减1
            if (map[ss[hi]-'a']-- >= 1)
                counter--;
            hi++;
            // 如果counter减为0, 将左端点index加入返回值
            if (counter == 0)
                ret.add(lo);
            // 如果hi-lo == p.length说明窗口大小超出限制, 需要将lo右移一位同时判断lo对应的字符是否在p中并决定是否对counter加1
            if (hi-lo == n) {
                // 只有当lo对应的字符个数大于等于0才说明lo对应的字符属于p, 否则其对应值应为负值
                if(map[ss[lo]-'a']++ >= 0)
                    counter++;
                lo++;
            }
        }
        return ret;
    }

//    private static boolean isAnagrams(String s, String p) {
//        char[] sA = s.toCharArray();
//        char[] pA = p.toCharArray();
//        Arrays.sort(sA);
//        Arrays.sort(pA);
//        return Arrays.equals(sA, pA);
//    }
}
