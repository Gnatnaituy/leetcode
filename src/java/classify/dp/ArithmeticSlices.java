package java.classify.dp;

public class ArithmeticSlices {

    /**
     * 0ms 100.00%
     * 34.9MB 92.65%
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int len = A.length;
        int res = 0;
        int[] sub = new int[len - 1];
        int[] dp = new int[len - 1];

        for (int i = 0; i < len - 1; i++) {
            sub[i] = A[i + 1] - A[i];
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] = sub[i] == sub[i - 1] ? dp[i] + 1 : 0;
        }

        for (int m : dp) {
            res += m;
        }

        return res;
    }

    /**
     * 0ms 100.00%
     * 34.3MB 99.24%
     */
    public int numberOfArithmeticSlices2(int[] A) {
        int res = 0;
        if (A.length < 3) return 0;

        for (int i = 1; i < A.length - 1; i++) {
            int sub = A[i] - A[i - 1];
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] - A[j - 1] != sub) {
                    break;
                }
                res++;
            }
        }

        return res;
    }

    /**
     * 0ms
     */
    public int numberOfArithmeticSlices3(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;

        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }

        return sum;
    }
}
