package java.classify.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    /**
     * 3ms 86.42%
     * 36.9MB 96.67%
     */
    public int eraseoverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) continue;
            end = intervals[i][1];
            count++;
        }

        return intervals.length - count;
    }
}
