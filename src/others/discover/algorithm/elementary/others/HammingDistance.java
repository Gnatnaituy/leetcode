package others.discover.algorithm.elementary.others;


/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离
 */
public class HammingDistance {

    /**
     * 20ms 10.71%
     */
    public int hammingDistance(int x, int y) {
        return Integer.toBinaryString(x ^ y).replaceAll("0","").length();
    }

    /**
     * 11ms
     */
    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int res = 0;

        while (z > 0) {
            if ((z & 1) == 1) res++;
            z = z >> 1;
        }

        return res;
    }

    /**
     * 8ms
     */
    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
