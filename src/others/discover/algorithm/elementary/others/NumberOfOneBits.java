package others.discover.algorithm.elementary.others;


/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
 */
public class NumberOfOneBits {

    /**
     * 3ms 81.17%
     */
    public int hammingWeight(int n) {
        int count = 0;
        long x = n & 0x0FFFFFFFFL;
        while (x > 0) {
            if (x % 2 == 1)
                count++;
            x /= 2;
        }

        return count;
    }
}
