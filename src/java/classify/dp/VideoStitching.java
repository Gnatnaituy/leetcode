package java.classify.dp;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {

    /**
     * Sort
     */
    public int videoStitching(int[][] clips, int T) {
        int res = 0;
        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));

        for (int i = 0, start = 0, end = 0; start < T; start = end, res++) {
            for (; i < clips.length && clips[i][0] <= start; i++) {
                end = Math.max(end, clips[i][1]);
            }
            if (start == end) return -1;
        }

        return res;
    }

    /**
     * DP
     * 1ms 89.77%
     * 33.5MB 100.00%
     */
    public int videoStitching2(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, T + 1);
        dp[0] = 0;

        for (int i = 1; i <= T && dp[i - 1] < T; i++) {
            for (int[] c : clips) {
                if (c[0] <= i && i <= c[1])
                    dp[i] = Math.min(dp[i], dp[c[0]] + 1);
            }
        }

        return dp[T] == T + 1 ? -1 : dp[T];
    }
}
