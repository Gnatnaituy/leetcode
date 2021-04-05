package classify.recursion;

/**
 * @author yutiantang
 * @create 2021/4/5 11:37
 */
public class NthTribonacciNumber {

    int[] cache = new int[38];

    /**
     * 0ms      100.00%
     * 35MB     88.54%
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        int res = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        cache[n] = res;

        return res;
    }


}
