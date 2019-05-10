package huahua.dp;

public class ArithmeticSlices {

    /**
     * 0ms 100.00%
     * 34.9MB 92.65%
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;

        int len = A.length;
        int res = 0;
        int[] sub = new int[len - 1];
        int[] dp = new int[len - 1];

        for (int i = 0; i < len - 1; i++)
            sub[i] = A[i + 1] - A[i];

        for (int i = 1; i < dp.length; i++)
            dp[i] = sub[i] == sub[i - 1] ? dp[i] + 1 : 0;

        for (int m : dp) res += m;

        return res;
    }
}
