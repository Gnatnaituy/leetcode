package java.completefifties.l0000;

import java.util.Stack;

public class MaximalRectangle {

    /**
     * 49ms 46.63%
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int[] height = new int[matrix[0].length + 1];
        int res = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++)
                height[j] = row[j] == '0' ? 0 : height[j] + 1;
            res = Math.max(res, largestRectangle(height));
        }

        return res;
    }

    private int largestRectangle(int[] height) {
        int i = 0, res = 0;
        height[height.length - 1] = 0;
        Stack<Integer> s = new Stack<>();

        while (i < height.length) {
            if (s.isEmpty() || height[i] >= height[s.peek()])
                s.push(i++);
            else
                res = Math.max(res, height[s.pop()] * (s.isEmpty() ? i : i - s.peek() - 1));
        }

        return res;
    }
}
