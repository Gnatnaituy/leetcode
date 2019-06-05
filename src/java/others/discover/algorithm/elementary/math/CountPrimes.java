package java.others.discover.algorithm.elementary.math;


/**
 * 统计所有小于非负整数 n 的质数的数量
 * 
 * 质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数
 */
public class CountPrimes {

    /**
     * 27ms 71.14%
     * 38m 3.08%
     */
    public int countPrimes(int n) {
        int res = 0;
        boolean[] isNotPrime = new boolean[n];

        /*
        将 i*j 即:
        将 2x2, 2x3, 2x4 ......
        将 3x3, 3x4, 3x5, 3x6 ......
        将 4x4, 4x5, 4x6, 4x7, 4x8 ......
        设为非质数
        */
        for (int i = 2; i * i < n; i++) {
            if (isNotPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isNotPrime[j] = true;
            }
        }

        // 统计质数的个数
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i])
                res++;
        }

        return res;
    }
}
