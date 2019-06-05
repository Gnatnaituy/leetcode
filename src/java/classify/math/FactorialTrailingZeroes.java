package java.classify.math;

public class FactorialTrailingZeroes {

    /**
     * 0ms 100.00%
     * 32.3MB 63.29%
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
