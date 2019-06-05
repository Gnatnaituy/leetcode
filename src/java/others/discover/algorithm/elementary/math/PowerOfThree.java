package java.others.discover.algorithm.elementary.math;


/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方
 */
public class PowerOfThree {

    /**
     * 13ms
     */
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;

        while (n % 3 == 0){
            n /= 3;
        }

        return n == 1;
    }

    /**
     * 13ms
     */
    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
