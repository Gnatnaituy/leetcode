package classify.twopointers;

import java.util.Stack;

/**
 * @author yutiantang
 * @create 2021/3/30 10:15 PM
 */
public class BackspaceStringCompare {

    /**
     * 3ms      19.86%
     * 36.3MB   98.26%
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                stackS.push(c);
            } else if (!stackS.isEmpty()) {
                stackS.pop();
            }
        }
        for (char c : T.toCharArray()) {
            if (c != '#') {
                stackT.push(c);
            } else if (!stackT.isEmpty()) {
                stackT.pop();
            }
        }
        if (stackS.size() != stackT.size()) {
            return false;
        } else {
            while (!stackS.isEmpty()) {
                if (stackS.pop() != stackT.pop()) {
                    return false;
                }
            }
        }

        return true;
    }
}
