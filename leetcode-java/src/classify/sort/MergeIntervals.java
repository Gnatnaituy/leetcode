package classify.sort;

import java.util.*;

/**
 * @author yutiantang
 * @create 2021/4/16 22:47
 */
public class MergeIntervals {

    /**
     * 8ms      49.19%
     * 40.8MB   94.61%
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[][] res = new int[intervals.length][2];
        int resIndex = 0;
        for (int i = 0; i < intervals.length; ) {
            int j = i;
            int maxRight = intervals[i][1];
            while (j < intervals.length && intervals[j][0] <= maxRight) {
                maxRight = Math.max(maxRight, intervals[j][1]);
                j++;
            }
            res[resIndex++] = new int[]{intervals[i][0], maxRight};
            i = j;
        }

        return Arrays.copyOfRange(res, 0, resIndex);
    }

    /**
     * 8ms      25.70%
     * 41.2MB   14.60%
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[][] res = new int[intervals.length][2];
        int slow = 0, fast = 1, index = 0;
        while (fast < intervals.length) {
            if (intervals[fast][0] > intervals[slow][1]) {
                res[index++] = new int[]{intervals[slow][0], intervals[slow][1]};
                slow = fast;
            } else {
                intervals[slow][1] = Math.max(intervals[slow][1], intervals[fast][1]);
            }
            fast++;
        }
        res[index++] = new int[]{intervals[slow][0], intervals[slow][1]};

        return Arrays.copyOfRange(res, 0, index);
    }
}
