package classify.stackqueue;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author yutiantang
 * @create 2021/10/17 23:11
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class MinStack {

    private final Stack<Integer> stack;

    private int min = Integer.MAX_VALUE;

    /**
     * 16ms     99.96%
     * 40.1MB   81.43%
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
    }

    public void pop() {
        int value = stack.pop();
        if (value == min) {
            min = Integer.MAX_VALUE;
            for (Integer integer : stack) {
                min = Math.min(min, integer);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
