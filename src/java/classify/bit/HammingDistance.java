package java.classify.bit;

public class HammingDistance {

    /**
     * 0ms 100.00%
     * 32.5MB 59.27%
     */
    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);
    }
}
