package stack;

public class ValidBrackets {

    private static boolean isValid(String s) {
        StringBuilder Stack = new StringBuilder();
        int i = 0;

        while (i < s.length()){
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    Stack.append(s.charAt(i));
                    i++;
                    break;
                case ')':
                case ']':
                case '}':
                    if (Stack.length() == 0) {
                        return false;
                    } else {
                        char stackTopElement = Stack.charAt(Stack.length() - 1);
                        if (stackTopElement == '(' && s.charAt(i) == ')' ||
                                stackTopElement == '[' && s.charAt(i) == ']' ||
                                stackTopElement == '{' && s.charAt(i) == '}') {
                            Stack.deleteCharAt(Stack.length() - 1);
                        } else {
                            return false;
                        }
                    }
                    i++;
                    break;
                default:
                    i++;
                    break;
            }
        }
        return Stack.toString().equals("");
    }

    public static void  main(String[] args) {
        String s = "[]{}()";
        boolean result = isValid(s);
        System.out.print(result);
    }

}
