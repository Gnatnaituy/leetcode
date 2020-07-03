package completefifties.l0200;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minheap, maxheap;

    public MedianFinder() {
        // 维护较大元素的小顶堆
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        // 维护较小元素的大顶堆
        minheap = new PriorityQueue<>();
    }

    /**
     * Add a number to the data structure
     */
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    /**
     * Return the median of current data stream
     */
    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) * 0.5;
        } else {
            return maxheap.peek();
        }
    }
}
