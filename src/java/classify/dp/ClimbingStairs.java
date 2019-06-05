package java.classify.dp;

public class    ClimbingStairs {

    /**
     * Brute Force
     * T(n) = O(2^n)  Time Limit Exceeded
     * S(n) = O(n)
     */
    public int climbStairs(int n) {
        return bruteForce(0, n);
    }

    private int bruteForce(int i, int n) {
        if (i > n) return 0;
        if (i == n) return 1;
        return bruteForce(i + 1, n) + bruteForce(i + 2, n);
    }

    /**
     * Recursion with Memoization
     * T(n) = O(n)  0ms     100.00%
     * S(n) = O(n)  31.8MB  100.00%
     */
    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];

        return recursionWithMemoization(0, n, memo);
    }

    private int recursionWithMemoization(int i, int n, int memo[]) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] > 0) return memo[i];
        memo[i] = recursionWithMemoization(i + 1, n, memo) + recursionWithMemoization(i + 2, n , memo);
        return memo[i];
    }

    /**
     * Dynamic Programming
     * T(n) = O(n)  0ms     100.00%
     * S(n) = O(n)  31.6MB  100.00%
     */
    public int climbStairs3(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * Fibonacci Number
     * T(n) = O(n)  0ms    100.00%
     * S(n) = O(1)  31.9MB 100.00%
     */
    public int climbStairs4(int n) {
        if (n == 1) return 1;

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    /**
     * Binets Method
     * T(n) = O(log n)  0ms    100.00%
     * S(n) = O(1)      31.8MB 100.00%
     */
    public int climbStairs5(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);

        return res[0][0];
    }

    private int[][] pow(int[][] a, int n) {
        int[][] res = {{1, 0}, {0, 1}};

        while (n > 0) {
            if ((n & 1) == 1) {
                res = multiply(res ,a);
            }
            n >>= 1;
            a = multiply(a, a);
        }

        return res;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }

        return c;
    }

    /**
     * Fibonacci Formula
     * T(n) = O(log n)  0ms    100.00%
     * S(n) = O(1)      31.8MB 100.00%
     */
    public int climbStairs6(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);

        return (int) (fibn / sqrt5);
    }
}
