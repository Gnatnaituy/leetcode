package others.easy.itwenty;

import java.util.PriorityQueue;

/**
 * 703 Kth Largest Element in a Stream
 */

public class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int index;

    public KthLargest(int k, int[] nums) {
        this.index = k;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i > k - 1) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > index) {
            queue.poll();
        }

        return queue.peek();
    }
}