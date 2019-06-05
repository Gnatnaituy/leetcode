package java.others.discover.algorithm.elementary.others;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足： -左括号必须用相同类型的右括号闭合。 -左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "[][]{}[]{}[]{}[]";
        System.out.println(validParentheses.isValid(s));
    }

    /**
     * 12ms 51.81%
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && isParentheses(stack.peek(), s.charAt(i)))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }

    private boolean isParentheses(Character left, Character right) {
        if (left == '(')
            return right == ')';
        if (left == '[')
            return right == ']';
        if (left == '{')
            return right == '}';
        return false;
    }

    /**
     * 4ms
     */
    public boolean isValid2(String s) {
        String[] stack = new String[s.length()];
        int r = 0;
        if (s.length() == 0)
            return true;
        for (int i = 0; i < s.length(); i++) {
            switch (s.substring(i, i + 1)) {
            case "(":
                stack[r] = "(";
                r++;
                break;
            case "[":
                stack[r] = "[";
                r++;
                break;
            case "{":
                stack[r] = "{";
                r++;
                break;
            case ")":
                if (r == 0)
                    return false;
                if (stack[r - 1] != "(")
                    return false;
                else
                    r--;
                break;
            case "]":
                if (r == 0)
                    return false;
                if (stack[r - 1] != "[")
                    return false;
                else
                    r--;
                break;
            case "}":
                if (r == 0)
                    return false;
                if (stack[r - 1] != "{")
                    return false;
                else
                    r--;
                break;
            }
        }
        if (r == 0)
            return true;
        else
            return false;
    }
}
