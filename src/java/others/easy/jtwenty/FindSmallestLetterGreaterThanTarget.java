package java.others.easy.jtwenty;

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

    /**
     * 0ms 100.00%
     * 38.8MB 93.72%
     */
    public char nextGreatestLetter3(char[] letters, char target) {
        int len = letters.length;
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left < len ? letters[left] : letters[0];
    }
}