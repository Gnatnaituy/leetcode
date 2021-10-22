package classify.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yutiantang
 * @create 2021/10/22 10:36
 * 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqueChar {

    /**
     * 15ms     76.16%
     * 38.7MB   59.90%
     * O(n) O(n)
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        int[][] records = new int[26][3];
        int[] init = new int[]{0, 0, 0};
        int sort = 1;
        for (char c : s.toCharArray()) {
            if (!Arrays.equals(records[c - 97], init)) {
                records[c - 97][1]++;
            } else {
                records[c - 97][0] = sort;
                records[c - 97][1] = 1;
                records[c - 97][2] = c;
                sort++;
            }
        }
        Arrays.sort(records, Comparator.comparingInt(o -> o[0]));

        for (int[] record : records) {
            if (record[1] == 1) {
                return (char) record[2];
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("azaccdeff"));
    }
}
