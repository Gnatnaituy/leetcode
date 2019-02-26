package others.easy.jtwenty;

/**
 * 744 Find Smallest Letter Greater than Target
 */

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target)
                return letters[i];
        }
        return letters[0];
    }
}