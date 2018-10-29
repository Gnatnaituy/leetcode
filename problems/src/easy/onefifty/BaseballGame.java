package easy.onefifty;

import java.util.Stack;

public class BaseballGame {

    private static int totalPoints = 0;
    private static Stack<Integer> stack = new Stack<>();

    private static int calPoints(String[] ops) {
        for (String op : ops) {
            switch (op) {
                case "+":
                    int top = stack.pop();
                    int second = stack.pop();
                    int thisPoint = top + second;
                    stack.push(second);
                    stack.push(top);
                    stack.push(thisPoint);
                    break;
                case "D":
                    int a = 2 * stack.peek();
                    stack.push(a);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        while (!stack.isEmpty()) {
            totalPoints += stack.pop();
        }
        return totalPoints;
    }

    public static void main(String[] args) {
        String[] judgements = {"5","-2","4","C","D","9","+","+"};
        int score = calPoints(judgements);
        System.out.println(score);
    }
}
