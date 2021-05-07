package classify.bit;

public class PowerOfTwo {

    /**
     * 2ms      7.19%
     * 35.3MB   93.79%
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    /**
     * 1ms      100.00%
     * 35.5MB   58.01%
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
