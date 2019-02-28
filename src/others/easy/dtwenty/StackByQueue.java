package others.easy.dtwenty;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225 Implement Stack using Queue
 *
 *Implement the following operations of a stackanddfs using queues.
 *
 * push(x) -- Push element x onto stackanddfs.
 * pop() -- Removes the element on top of the stackanddfs.
 * top() -- Get the top element.
 * empty() -- Return whether the stackanddfs is empty.
 * Example:
 *
 * MyStack stackanddfs = new MyStack();
 *
 * stackanddfs.push(1);
 * stackanddfs.push(2);
 * stackanddfs.top();   // returns 2
 * stackanddfs.pop();   // returns 2
 * stackanddfs.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queueandbfs -- which means only push to back,
 * peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queueandbfs may not be supported natively.
 * You may simulate a queueandbfs by using a list or deque (double-ended queueandbfs),
 * as long as you use only standard operations of a queueandbfs.
 * You may assume that all operations are valid (for example,
 * no pop or top operations will be called on an empty stackanddfs).
 */

public class StackByQueue {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int size;

    /** Initialize your data structure here. */
    public StackByQueue() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
        this.size = 0;
    }

    /** Push element x onto stackanddfs. */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
        size++;
    }

    /** Removes the element on top of the stackanddfs and returns that element. */
    private int pop() {
        if (size == 0) {
            return -1;
        }
        int res = 0;
        if (queue1.isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            res = queue2.poll();
        } else {
            for (int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            res = queue1.poll();
        }
        size--;

        return res;
    }

    /** Get the top element. */
    public int top() {
        if (size == 0) {
            return -1;
        }
        int top = pop();
        if (queue1.isEmpty()) {
            queue2.offer(top);
        } else {
            queue1.offer(top);
        }
        size++;

        return top;
    }

    /** Returns whether the stackanddfs is empty. */
    public boolean empty() {
        return size == 0;
    }
}

