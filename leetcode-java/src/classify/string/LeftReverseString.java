package classify.string;

/**
 * @author yutiantang
 * @create 2021/10/19 11:25
 * 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class LeftReverseString {

    /**
     * 2ms      49.13%
     * 38MB     84.10%
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null || n > s.length()) {
             return s;
        }

        int index = 0;
        int length = s.length();
        int diff = length - n;
        char[] res = new char[length];
        while (n < s.length()) {
            res[index++] = s.charAt(n++);
        }
        while (index < length) {
            res[index] = s.charAt(index - diff);
            index++;
        }

        return new String(res);
    }
}
