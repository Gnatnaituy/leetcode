package java.others.easy.jtwenty;

/**
 * 754 Reach a Number
 */

public class ReachANumber {
    public int reachNumber(int target) {
        // wrong version, needs change
        if (target < 0) target = -target;
        for (int i = 1; i < target; i++) {
            target -= i;
            if (target == (i + 1)) return i + 1;
            if (target < (i + 1)) {
                if ((i + 1 - target) % 2 == 0) return i + 1;
                if ((i + 1) % 2 == 0) return i + 2;
                else return i + 3;
            }
        }
        return -1;
    }
}