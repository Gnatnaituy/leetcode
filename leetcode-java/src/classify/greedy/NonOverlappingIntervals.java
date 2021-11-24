package classify.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    /**
     * 3ms 86.42%
     * 36.9MB 96.67%
     * 贪心算法1 按结束节点排序 选择开始节点最大的
     */
    public int eraseoverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }

    /**
     * 65ms     17.79%
     * 94.4MB   67.84%
     * 贪心算法2 按开始节点排序 选择结束节点最小的
     * @param intervals
     * @return
     */
    public int eraseoverlapIntervals2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int count = 1, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            } else {
                end = Math.min(end, intervals[i][1]);
            }
        }

        return intervals.length - count;
    }

    /**
     * 206ms    5.08%
     * 93.9MB   96.30%
     * 动态规划
     * @param intervals
     * @return
     */
    public int eraseoverlapIntervals3(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = i - 1; j > -1; j--) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    break;
                }
            }
        }

        return intervals.length - dp[intervals.length - 1];
    }
}
