package classify.hash;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /**
     * 0ms      100.00%
     * 38MB     72.28%
     */
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int t = 0;
            while (n != 0) {
                t += (n % 10) * (n % 10);
                n /= 10;
            }
            n = t;
        }
        return n == 1;
    }

    /**
     * 1ms      81.56%
     * 38.5MB   47.50%
     */
    public boolean isHappy2(int n) {
        Set<Integer> called = new HashSet<>();
        int res, tail;
        while (n != 1) {
            res = 0;
            while (n != 0) {
                tail = n % 10;
                res += tail * tail;
                n /= 10;
            }
            if (called.contains(res)) {
                return false;
            }
            called.add(res);
            n = res;
        }

        return true;
    }
}
