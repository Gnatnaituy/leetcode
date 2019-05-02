package huahua.dp;

import java.util.LinkedList;

public class LargestRectangleInHistogram {

    /**
     * 15ms 55.31%
     * 42MB 19.44%
     *  How to calculate area with ‘x’ as smallest bar?
     *  We need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’
     *  and index of first smaller bar on right of ‘x’.
     *  Let us call these indexes as ‘left index’ and ‘right index’ respectively.
     *
     *  We traverse all bars from left to right maintain a stack of bars. Every bar is pushed to stack once.
     *  A bar is popped from stack when a bar of smaller height is seen.
     *  When a bar is popped, we calculate the area with the popped bar as smallest bar.
     *  How do we get left and right indexes of the popped bar :
     *  the current index tells us the ‘right index’ and index of previous item in stack is the ‘left index’.
     */
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        // change to LinkedList make cost only 7ms 84.96% and 41.5MB 24.76%
        // Stack<Integer> s = new Stack<>();
        LinkedList<Integer> s = new LinkedList<>();

        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);

            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }

        return maxArea;
    }
}
