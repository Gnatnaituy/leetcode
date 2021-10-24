package others.easy.etwenty;

/**
 * 509 Fibonacci Number
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class FibonacciNumber {

    /**
     * 0ms      100.00%
     * 35.3MB   29.81%
     * @param N
     * @return
     */
    private int fib(int N) {
        int a = 0, b = 1, temp;
        for (int i = 2; i <= N; i++) {
            temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return N == 0 ? a : b;
    }
}
