package others.easy.htwenty;

/**
 * 633 Sum of Square Numbers
 *
 * Given a non-negative integer c,
 * your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Example 2:
 * Input: 3
 * Output: False
 */

public class SumOfSquareNumbers {
    private boolean judgeSquareNumber(int c) {
        if (c == 0) return true;
        for (int i = 0; i < (int) Math.sqrt(c); i++) {
            if (i * i + Math.pow((int) Math.sqrt(c - i * i), 2) == c)
                return true;
        }
        return false;
    }
}
