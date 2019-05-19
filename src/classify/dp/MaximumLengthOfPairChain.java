package classify.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {

    /**
     * 88ms 16.99%
     * 51.7MB 41.38%
     */
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;

        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
            }
        }

        return dp[pairs.length - 1];
    }

    /**
     * 39ms
     */
    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int cur = Integer.MIN_VALUE, ans = 0;

        for (int[] pair: pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }

        return ans;
    }

    /**
     * 9ms
     */
    public int findLongestChain3(int[][] pairs) {
        if(pairs == null) return 0;

        int len = pairs.length;
        if(len < 2) return len;

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int sum = 1;
        int end = pairs[0][1];

        for (int i = 1;i < len;++i) {
            if(pairs[i][0] > end) {
                ++sum;
                end = pairs[i][1];
            }
        }

        return sum;
    }

    /**
     * 44ms 63.68%
     * 43.8MB 84.10%
     */
    public int findLongestChain4(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        if (pairs.length == 1) return 1;

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int res = 1;
        int cur = 1;
        int big = pairs[0][1];
//        while (cur < pairs.length) {
//            if (pairs[cur][0] > big) {
//                big = pairs[cur][1];
//                res++;
//            }
//            cur++;
//        }
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > big) {
                big = pairs[i][1];
                res++;
            }
        }

        return res;
    }
}
