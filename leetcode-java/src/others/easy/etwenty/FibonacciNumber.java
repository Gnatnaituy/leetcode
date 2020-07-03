package others.easy.etwenty;

/**
 * 509 Fibonacci Number
 */

public class FibonacciNumber {

    private int fib(int N) {
        int a = 0, b = 1, temp;
        for (int i = 2; i <= N; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return N == 0 ? a : b;
    }
}
