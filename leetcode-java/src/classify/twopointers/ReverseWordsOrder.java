package classify.twopointers;

/**
 * @Author tiantang
 * @Date 2021/10/29
 * 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class ReverseWordsOrder {

    /**
     * 2ms      82.32%
     * 38.3MB   48.13%
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        int fast = s.length() - 1, slow;
        StringBuilder sb = new StringBuilder();
        while (fast >= 0) {
            if (s.charAt(fast) != 32) {
                slow = fast;
                while (fast >= 0 && s.charAt(fast) != 32) {
                    fast--;
                }
                sb.append(s, fast + 1, slow + 1).append(' ');
            } else {
                fast--;
            }
        }

        return sb.substring(0, sb.length() > 0 ? sb.length() - 1 : sb.length());
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("aasd asd asdasdsad"));
        System.out.println(reverseWords("   aasd asd asdasdsad"));
        System.out.println(reverseWords("   aasd asd asdasdsad    "));
        System.out.println(reverseWords("aasd asd asdasdsad    "));
    }
}
