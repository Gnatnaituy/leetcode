package easy.mtwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Verifying an Alien Dictionary
 */

public class VerifyingAnAlienDictionary {

    private boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] orderArray = order.toCharArray();
        
        for (int i = 0; i < orderArray.length; i++) {
            map.put(orderArray[i], i);
        }
    
        String[] sorted = words.clone();
        
        Arrays.sort(sorted, (o1, o2) -> {
            char[] o1A = o1.toCharArray();
            char[] o2A = o2.toCharArray();
            for (int i = 0; i < Math.min(o1A.length, o2A.length); i++) {
                if (map.get(o1A[i]) > map.get(o2A[i]))
                    return -1;
            }
            return 1;
        });
        
        return Arrays.equals(words, sorted);
    }
    
    public static void main(String[] args) {
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = {"hello", "leetcode"};
        boolean a = new VerifyingAnAlienDictionary().isAlienSorted(words, order);
        System.out.println(a);
    }
}
