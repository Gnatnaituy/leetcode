package easy.atwenty;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> s = new Stack<>();
    private int minValue = Integer.MAX_VALUE;

    /** initialize your data structure here. */

    public MinStack() { }

    public void push(int x) {
        if (x <= minValue) {
            s.push(minValue);
            minValue = x;
        }
        s.push(x);
    }

    public void pop() {
        if (s.pop() == minValue)
            minValue = s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minValue;
    }
}
