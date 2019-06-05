package java.others.easy.atwenty;

import java.util.Stack;

public class ReverseInteger {

    private static int reverse(int x) {

        String original = String.valueOf(x);
        Stack<Character> stack = new Stack<>();
        StringBuilder reversed = new StringBuilder();

        if (x == 0)
            return 0;
        else {
            while (x % 10 == 0)
                x /= 10;
        }

        if (original.charAt(0) == '-') {
            for (int i = 1; i < original.length(); i++)
                stack.push(original.charAt(i));
            reversed.append('-');
            while (!stack.isEmpty())
                reversed.append(stack.pop());
        } else {
            for (int i = 0; i < original.length(); i++)
                stack.push(original.charAt(i));
            while (!stack.isEmpty())
                reversed.append(stack.pop());
        }

        double doubleResult = Double.parseDouble(reversed.toString());
        if (doubleResult > Integer.MAX_VALUE || doubleResult < Integer.MIN_VALUE)
            return 0;
        else
            return Integer.parseInt(reversed.toString());
    }

    public static void main(String[] args) {

        System.out.println(reverse(-15342300));
    }
}
