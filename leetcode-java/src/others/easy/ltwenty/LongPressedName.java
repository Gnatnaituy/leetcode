package others.easy.ltwenty;

/**
 * 925 Long Pressed Name
 */

public class LongPressedName {
    
    private boolean isLongPressedName(String name, String typed) {
        // 4ms, 99.09%
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();
        int i = 0, j = 0;
        
        start:
        for (; i < nameChars.length; i++) {
            for (; j < typedChars.length;) {
                if (typedChars[j] == nameChars[i]) {
                    continue start;
                } else {
                    j++;
                }
            }
            return false;
        }
        
        return true;
    }
}
