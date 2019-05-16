package classify.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumbersOfArrowsToBurstBalloons {

    /**
     * 19ms 98.66%
     * 45.2MB 84.21%
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int end = points[0][1];
        for (int i= 1; i < points.length; i++) {
            if (points[i][0] <= end) continue;
            end = points[i][1];
            count++;
        }

        return count;
    }
}
