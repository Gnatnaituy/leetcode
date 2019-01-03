package easy.jtwenty;

/**
 * 806 Number of Lines To Write String
 */

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 0;
        int line = 0;
        for (char word : s.toCharArray()) {
            if (line + widths[word - 'a'] <= 100) {
                line += widths[word - 'a'];
            } else {
                line = widths[word - 'a'];
                lines++;
            }
        }
        return new int[] {lines + 1, line};
    }
}
