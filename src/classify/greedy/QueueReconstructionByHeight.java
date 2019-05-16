package classify.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    /**
     * 41ms 27.74%
     * 44.3MB 69.75%
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int[][] res = new int[people.length][2];

        for (int i = 0; i < people.length; i++) {
            int pos = people[i][1];
            if (i - pos >= 0) {
                System.arraycopy(res, pos, res, pos + 1, i - pos);
            }
            res[pos] = people[i];
        }

        return res;
    }

    /**
     * 35ms 52.45%
     * 44.4MB 69.75%
     */
    public int[][] reconstructQueue2(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[queue.size()][]);
    }
}
