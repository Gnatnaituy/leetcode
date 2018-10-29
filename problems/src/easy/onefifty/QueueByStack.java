package easy.onefifty;

import java.util.Stack;

class QueueByStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int size;

    /** Initialize your data structure here. */
    public QueueByStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        this.size = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty()) {
            stack2.push(x);
        } else {
            stack1.push(x);
        }
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int res = 0;
        if (stack1.isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                stack1.push(stack2.pop());
            }
            res = stack2.pop();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        } else {
            for (int i = 0; i < size - 1; i++) {
                stack2.push(stack1.pop());
            }
            res = stack1.pop();
            for (int i = 0; i < size; i++) {
                stack1.push(stack2.pop());
            }
        }
        size--;

        return res;
    }

    /** Get the front element. */
    public int peek() {
        if (size == 0)
            return -1;
        int head;
        if (stack1.isEmpty()){
            for (int i = 0; i < size - 1; i++) {
                stack1.push(stack2.pop());
            }
            head = stack2.pop();
            stack2.push(head);
            for (int i = 0; i < size - 1; i++) {
                stack2.push(stack1.pop());
            }
        } else {
            for (int i = 0; i < size - 1; i++) {
                stack2.push(stack1.pop());
            }
            head = stack1.pop();
            stack1.push(head);
            for (int i = 0; i < size - 1; i++) {
                stack1.push(stack2.pop());
            }
        }

        return head;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }
}

