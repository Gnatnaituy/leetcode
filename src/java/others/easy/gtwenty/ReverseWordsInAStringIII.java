package java.others.easy.gtwenty;

/**
 * 557 Reverse Words in a String III
 *
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode java.contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note: In the string, each word is separated by single space and
 * there will not be any extra space in the string.
 */

public class ReverseWordsInAStringIII {

    private static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            char[] chars = str.toCharArray();
            int front = 0;
            int tail = chars.length - 1;
            while (front < tail) {
                char temp = chars[front];
                chars[front] = chars[tail];
                chars[tail] = temp;
                front++;
                tail--;
            }
            res.append(new String(chars)).append(i == split.length - 1 ? "" : " ");
        }
        return res.toString();
    }
}
