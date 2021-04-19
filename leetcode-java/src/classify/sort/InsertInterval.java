package classify.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yutiantang
 * @create 2021/4/16 23:16
 */
public class InsertInterval {

    /**
     * 2ms      71.98%
     * 40.9     30.52%
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int len = intervals.length;
        int index = 0;
        while (index < len && intervals[index][1] < newInterval[0]) {
            list.add(intervals[index]);
            index++;
        }
        while (index < len && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        list.add(newInterval);
        while (index < len) {
            list.add(intervals[index]);
            index++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
