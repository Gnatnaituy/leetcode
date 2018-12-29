package easy.jtwenty;

import java.util.ArrayList;
import java.util.List;

/**
 * 728 Self Dividing Numbers
 */

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        while (left <= right) {
            if (able(left)) res.add(left);
        }
        return res;
    }

    private boolean able(int n) {
        int d = n;
        while (d != 0) {
            int c = d % 10;
            if (c == 0 || (n % c) != 0) return false; 
            d /= 10;
        }
        return true;
    }
}