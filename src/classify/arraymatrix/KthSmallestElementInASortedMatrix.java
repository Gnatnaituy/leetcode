package classify.arraymatrix;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

    /**
     * 16ms 51.53%
     * 41.3MB 91.30%
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        for (int j = 0; j <= n - 1; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }

        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }

        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;

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


    /**
     * 1ms 80.76%
     * 42.3MB 80.00%
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = matrix[0].length - 1;

            for (int[] row : matrix) {
                while (j >= 0 && row[j] > mid) {
                    j--;
                }
                count += (j + 1);
            }

            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
