package classify.twopointers;

import java.util.Stack;

/**
 * @author yutiantang
 * @create 2021/3/30 10:15 PM
 */
public class BackspaceStringCompare {

    /**
     * 2ms      21.03%
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

    /**
     * 0ms      100.00%
     * 36.7MB   36.01%
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare2(String s, String t) {
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        int scIndex = sc.length - 1, tcIndex = tc.length - 1, scSharp = 0, tcSharp = 0;
        while (scIndex > -1 || tcIndex > -1) {
            if (scIndex > -1 && sc[scIndex] == '#') {
                scSharp++;
                scIndex--;
            } else if (tcIndex > -1 && tc[tcIndex] == '#') {
                tcSharp++;
                tcIndex--;
            } else if (scIndex > -1 && scSharp > 0 ) {
                scSharp--;
                scIndex--;
            } else if (tcIndex > -1 && tcSharp > 0 ) {
                tcSharp--;
                tcIndex--;
            } else if (scIndex == -1 || tcIndex == -1 || sc[scIndex] != tc[tcIndex]) {
                return false;
            } else {
                scIndex--;
                tcIndex--;
            }
        }

        return true;
    }
}
