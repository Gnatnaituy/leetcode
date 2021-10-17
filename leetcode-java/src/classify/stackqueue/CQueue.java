package classify.stackqueue;

import java.util.Stack;

/**
 * @author yutiantang
 * @create 2021/10/17 18:45
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class CQueue {

    private final Stack<Integer> stack1;

    private final Stack<Integer> stack2;

    /**
     * 44ms     52.23%
     * 46.5MB   72.63%
     */
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        } else {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return stack1.isEmpty() ? -1 : stack1.pop();
        }
    }
}
