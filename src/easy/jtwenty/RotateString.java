package easy.jtwenty;

import java.util.ArrayList;
import java.util.List;

/**
 * 796 Rotate String
 */

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() == 0 && B.length() == 0)
            return true;
        if (A.length() == 0 || B.length() == 0)
            return false;
        List<Integer> indexes = new ArrayList<>();
        char startOfB = B.charAt(0);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == startOfB)
                indexes.add(i);
        }
        for (Integer index : indexes) {
            StringBuilder temp = new StringBuilder();
            temp.append(A.substring(index, A.length()));
            temp.append(A.substring(0, index));
            if (temp.toString().equals(B))
                return true;
        }
        
        return false;
    }
}
