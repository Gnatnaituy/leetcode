package others.easy.ktwenty;

import java.util.ArrayDeque; 
import java.util.Queue;

/**
 * 821 Shortest Distance to a Character
 */

public class ShortestDistance2aCharacter {

    public int[] shortestToChar(String S, char C) {
        char[] s = S.toCharArray();
        int[] res = new int[s.length];
        for (int i = 0 ; i < res.length; i++) {
            res[i] = Integer.MIN_VALUE;
        }
        Queue<Integer> zeros = new ArrayDeque<>();
        
        for (int i = 0; i < s.length; i++) {
            if (s[i] == C) {
                res[i] = 0;
                zeros.add(i);
            }
        }
    
        int start = !zeros.isEmpty() ? zeros.poll() : Integer.MAX_VALUE;
        int end = !zeros.isEmpty() ? zeros.poll() : Integer.MAX_VALUE;
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0) {
                res[i] = Math.abs(i - start) < end - i ? Math.abs(i - start) : end - i;
            } else {
                if (i == end) {
                    start = end;
                    end = !zeros.isEmpty() ? zeros.poll() : Integer.MAX_VALUE;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        ShortestDistance2aCharacter demo = new ShortestDistance2aCharacter();
        for (int i : demo.shortestToChar(S, C)) {
            System.out.println(i);
        }
    }
}
