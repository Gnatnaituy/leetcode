package classify.dp;

import java.util.LinkedList;

public class MaximalRectangle {

    /**
     * 7ms 83.82%
     * 42.3MB 29.15%
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int maxArea = 0;
        int col = matrix[0].length;
        int[] dp = new int[col];

        for (char[] chars : matrix) {
            for (int j = 0; j < col; j++) {
                dp[j] = chars[j] == '1' ? dp[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, calcArea(dp));
        }

        return maxArea;
    }

    // code from 84.Largest Rectangle in Histogram
    private int calcArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int res = 0;
        // 如果使用Stack, 会从7ms涨到28ms
        // Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i <= heights.length; i++) {
            while (stack.peek() != -1 && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int index = stack.pop();
                int start = stack.peek() + 1;
                res = Math.max(res, heights[index] * (i - start));
            }
            stack.push(i);
        }

        return res;
    }
}
