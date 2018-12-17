package easy.itwenty;

import java.util.Arrays;

/**
 * 686 Reapted String Match
 */


class RepeatedStringMatch {
    private int repeatedStringMatch(String A, String B) {
        int j = 0, i = 0;
        boolean bl = true;
        while (j < B.length()) {
            if (A.charAt(i % A.length()) == B.charAt(j)) {
                i++;
                j++;
            } else {
                if (bl == false) 
                    return -1;
                i++;
            }
            if (i == A.length()) 
                bl = false;  
        }
         
        if (i % A.length() == 0) 
            return i / A.length();
        else 
            return i / A.length() + 1;
    }

    public static void main(String[] args) {
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
        String A = "abd";
        String B = "cdabcdab";
        int a = repeatedStringMatch.repeatedStringMatch(A, B);
        System.out.print(a);
    }
}