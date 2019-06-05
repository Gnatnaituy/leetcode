package java.completefifties.l0000;

import java.util.Stack;

public class LongestValidParentheses {
    
    /**
     * 32. Longest Valid Parentheses
     */
    private int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        
        if (s == null || s.length() == 0)
            return max;
        
        stack.push(-1);
        for(int i = 0; i != s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    max = max > i - stack.peek() ? max : i - stack.peek();
            }
        }
    
        return max;
    }
}
