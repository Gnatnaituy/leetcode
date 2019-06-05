package java.classify.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    /**
     * 25ms 77.70%
     * 39.4MB
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> index = new Stack<>();

        for (int i = 0; i < len * 2; i++) {
            int num = nums[i % len];
            while (!index.isEmpty() && nums[index.peek()] < num) {
                res[index.pop()] = num;
            }
            if (i < len) index.push(i);
        }

        return res;
    }
}
