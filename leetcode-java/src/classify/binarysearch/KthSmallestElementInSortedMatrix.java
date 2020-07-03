package classify.binarysearch;

import java.util.Objects;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    /**
     * 17ms 49.77%
     * 46.2MB 12.01%
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();

        for (int j = 0; j < n; j++) {
            queue.offer(new Tuple(0, j, matrix[0][j]));
        }

        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = queue.poll();
            if (Objects.requireNonNull(tuple).x == n - 1) continue;
            queue.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
        }

        return Objects.requireNonNull(queue.poll()).val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y ,val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
}
