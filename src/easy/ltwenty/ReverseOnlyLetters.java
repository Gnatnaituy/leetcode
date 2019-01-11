package easy.ltwenty;

import java.util.Arrays;

/**
 * 917 Reverse Only Letters
 */

public class ReverseOnlyLetters {

    private String reverseOnlyLetters(String S) {
        StringBuilder stringBuilder = new StringBuilder(S);
        int left = 0, right = S.length() - 1;
        
        while (left < right) {
            if (Character.isAlphabetic(stringBuilder.)) {
                while (right > left) {
                    if (Character.isAlphabetic(S.charAt(right))) {
                        char temp = S.charAt(left);
                        S.
                        S.charAt(right) = temp;
                        right--;
                        break;
                    } else right--;
                }
                left++;
            } else left++;
        }
        
        return S;
    }
}
