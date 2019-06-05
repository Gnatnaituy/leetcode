package java.others.discover.algorithm.elementary.others;


/**
 * 颠倒给定的 32 位无符号整数的二进制位
 */
public class ReverseBits {

    /**
     * 1ms 100%
     */
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans += n & 1;
            n >>= 1;
        }

        return ans;
    }
}
