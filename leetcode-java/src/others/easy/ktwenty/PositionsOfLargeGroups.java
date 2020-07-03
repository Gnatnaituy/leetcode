package others.easy.ktwenty;

import java.util.ArrayList;
import java.util.List;

/**
 * 830 Positions of Large Groups
 */

public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        char[] s = S.toCharArray();
        int front = 0, rear = 1;
        
        while (rear < s.length) {
            if (s[rear] == s[front]) rear++;
            else {
                if (rear - front >= 3) {
                    List<Integer> one = new ArrayList<>();
                    one.add(front);
                    one.add(rear - 1);
                    res.add(one);
                    front = rear;
                    rear++;
                } else {
                    front = rear;
                    rear++;
                }
            }
        }
    
        if (rear - front >= 3) {
            List<Integer> one = new ArrayList<>();
            one.add(front);
            one.add(rear - 1);
            res.add(one);
        }
        
        return res;
    }
}
