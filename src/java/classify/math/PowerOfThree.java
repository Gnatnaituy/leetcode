package java.classify.math;

public class PowerOfThree {

    /**
     * Recursive
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
    }

    /**
     * Iterative
     */
    public boolean isPowerOfThree2(int n) {
        if (n > 1) {
            while (n % 3 == 0) {
                n /= 3;
            }
        }

        return n == 1;
    }
}
