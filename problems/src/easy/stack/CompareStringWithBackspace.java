package easy.stack;

import java.util.Stack;

public class CompareStringWithBackspace {

    public static boolean backspaceCompare(String S, String T) {
        StringBuilder stackS = new StringBuilder();
        StringBuilder stackT = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stackS.append(S.charAt(i));
            } else if (stackS.length() > 0) {
                stackS.deleteCharAt(stackS.length() - 1);
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                stackT.append(T.charAt(i));
            } else if (stackT.length() > 0) {
                stackT.deleteCharAt(stackT.length() - 1);
            }
        }

        System.out.println(stackS);
        System.out.println(stackT);
        return stackS.toString().equals(stackT.toString());
    }

    public static void main(String[] args) {
        String S = "#asdd#asd";
        String T = "asdd#asd";
        boolean a = backspaceCompare(S, T);
        System.out.println(a);
    }
}
