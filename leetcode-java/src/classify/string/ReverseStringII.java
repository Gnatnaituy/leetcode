package classify.string;

public class ReverseStringII {

    /**
     * 0ms      100.00%
     * 41.5MB   16.47%
     */
    public String reverseStr(String s, int k) {
        int length = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i < length; i += 2 * k) {
            if (i + k >= length) {
                reverse(str, i, length - 1);
            } else {
                reverse(str, i, i + k - 1);
            }
        }

        return new String(str);
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++; end--;
        }
    }
}
