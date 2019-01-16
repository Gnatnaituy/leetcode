package medium.afifty;

import java.sql.Array;
import java.util.Arrays;

/**
 * 5. Longest Palindromic Substring
 */

public class LongestPalindromicSubstring {

    private String longestPalindromicSubstring(String s) {
        // 2002ms 1.00%
//        char[] S = s.toCharArray();
//        int front = 0, tail = S.length - 1, maxLength = 0;
//
//        for (int i = 0; i < S.length; i++) {
//            for (int j = S.length - 1; j > 0; j--) {
//                if (isPalindrome(S, i, j) && j - i + 1 > maxLength) {
//                    front = i;
//                    tail = j;
//                    maxLength = j - i + 1;
//                }
//            }
//        }
//
//        return new String(Arrays.copyOfRange(S, front, tail + 1));
    
        String res = "";
        int currLength = 0;
        for(int i = 0;i < s.length(); i++){
            if(isPalindrome(s, i - currLength - 1, i)){
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            }
            else if(isPalindrome(s, i - currLength, i)){
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return res;
    }
    
//    private boolean isPalindrome(char[] S, int front, int tail) {
//        while (front <= tail) {
//            if (S[front] == S[tail]) {
//                front++;
//                tail--;
//            } else {
//                break;
//            }
//        }
//        return front >= tail;
//    }
    
    private boolean isPalindrome(String s, int begin, int end){
        if(begin < 0) return false;
        while(begin < end) {
            if(s.charAt(begin++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
