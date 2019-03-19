package others.easy.jtwenty;

/**
 * 744 Find Smallest Letter Greater than Target
 */

public class FindSmallestLetterGreaterThanTarget {

    /**
     * 14ms 33.23%
     */
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target)
                return letter;
        }

        return letters[0];
    }

    /**
     * 6ms
     */
    public char nextGreatestLetter2(char[] letters, char target) {
        if (target < letters[0] || target >= letters[letters.length - 1]) {
            return letters[0];
        }

        int i = 0;
        int j = letters.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (letters[mid] <= target) {
                if (mid < letters.length - 1 && target < letters[mid + 1]) {
                    return letters[mid + 1];
                }
                i = mid + 1;
            } else if (target < letters[mid]) {
                if (mid > 0 && target >= letters[mid - 1]) {
                    return letters[mid];
                }
                j = mid - 1;
            }
        }

        return 0;
    }
}