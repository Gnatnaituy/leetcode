package classify.sort;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    private final PriorityQueue<Integer> queue;
    private final int k;

    /**
     * 11ms     97.78%
     * 45.9MB   82.71%
     */
    public KthLargestElementInAStream(int k, int[] a) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int n : a) {
            add(n);
        }
    }

    public int add(int n) {
        if (queue.size() < k) {
            queue.offer(n);
        } else if (queue.peek() < n) {
            queue.poll();
            queue.offer(n);
        }
        
        return queue.peek();
    }
}
