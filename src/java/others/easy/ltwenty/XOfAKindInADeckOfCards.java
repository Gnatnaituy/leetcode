package java.others.easy.ltwenty;

import java.util.*;

/**
 * 914 X of a  Kind in a Deck of Cards
 */

public class XOfAKindInADeckOfCards {

    private boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int de : deck) {
            map.put(de, map.get(de) == null ? 1 : map.get(de) + 1);
        }
        
        List<Integer> values = new ArrayList<>(map.values());
        int min = Integer.MAX_VALUE;
        for (Integer value : values) {
            if (value < min) min = value;
        }
        if (min < 2) return false;
        
        outer:
        for (int i = 2; i <= min; i++) {
            boolean flag = true;
            for (Integer value : values) {
                flag = value % i == 0;
                if (!flag) continue outer;
            }
            if (flag) return true;
        }
        
        return false;
    }
}
