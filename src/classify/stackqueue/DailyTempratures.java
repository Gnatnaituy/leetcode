package classify.stackqueue;

import java.util.Stack;

public class DailyTempratures {

    /**
     * Stack
     * 41ms 71.66%
     * 43.5MB 68.45%
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }

        return ret;
    }

    /**
     * Array
     * 4ms 97.41%
     * 41.5MB 99.09%
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] stack = new int[T.length];
        int top = -1;
        int[] ret = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }

        return ret;
    }
}
