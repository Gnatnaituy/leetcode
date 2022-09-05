package classify.stack;

import java.util.LinkedList;

public class ReverseSubstringsBetweenEachPairOfParentness {

    /**
     * 3ms      37.45%
     * 41.4MB   11.92%
     */
    public String reverseParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> trans = new LinkedList<>();
        char transC;

        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.addLast(c);
            } else {
                transC = stack.removeLast();
                while (transC != '(') {
                    trans.addLast(transC);
                    transC = stack.removeLast();
                }
                while (!trans.isEmpty()) {
                    stack.addLast(trans.removeFirst());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }

        return sb.toString();
    }

    /**
     * 0ms      100.00%
     * 39.6MB   60.51%
     */
    public String reverseParentheses2(String s) {
        char[] queue = new char[s.length() * 2];
        int left = 0, right = queue.length - 1, tail;

        for (char c : s.toCharArray()) {
            if (c != ')') {
                queue[left++] = c;
            } else {
                left--;
                while (queue[left] != '(') {
                    queue[right--] = queue[left--];
                }
                tail = queue.length - 1;
                while (tail > right) {
                    queue[left++] = queue[tail--];
                }
                right = queue.length - 1;
            }
        }

        return new String(queue, 0, left);
    }

    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairOfParentness a = new ReverseSubstringsBetweenEachPairOfParentness();
        System.out.println(a.reverseParentheses2("a(ed(et(oc))el)b"));
    }
}
