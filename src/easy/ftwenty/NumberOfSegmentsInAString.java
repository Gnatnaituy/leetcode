package easy.ftwenty;

/**
 * 434 Number of Segments in a String
 *
 * Count the number of segments in a string,
 * where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 */

public class NumberOfSegmentsInAString {

    private static int countSegments(String s) {
        if (s.length() == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ')
                result++;
        }

        return s.charAt(0) == ' ' ? result : result + 1;
    }
}
