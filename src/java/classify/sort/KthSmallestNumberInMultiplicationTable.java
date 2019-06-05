package java.classify.sort;

import java.util.PriorityQueue;

public class KthSmallestNumberInMultiplicationTable {

    /**
     * Memory Limit Exceed
     */
    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(m * n, (o1, o2) -> o2 - o1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                queue.offer(i * j);
            }
        }

        for (int i = 0; i < m * n - k; i++) {
            queue.poll();
        }

        return queue.peek();
    }

    /**
     * Binary Search
     * 10ms 85.95%
     * 32.1MB 100.00%
     */
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;

        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }

        return count >= k;
    }

    public int findKthNumber2(int m, int n, int k) {
        int lo = 1, hi = m * n;

        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
        }

        return lo;
    }
}
