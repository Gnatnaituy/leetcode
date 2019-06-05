package java.others.easy.ltwenty;

/**
 * 917 Reverse Only Letters
 */

public class ReverseOnlyLetters {

    private String reverseOnlyLetters(String S) {
    
        // 13ms, surpass 21.25% users...
//        StringBuilder stringBuilder = new StringBuilder();
//        Queue<Character> nonAlphabet = new ArrayDeque<>();
//        Queue<Integer> index = new ArrayDeque<>();
//        Stack<Character> alphabet = new Stack<>();
//
//        for (int i = 0; i < S.length(); i++) {
//            char s = S.charAt(i);
//            if ((s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z')) {
//                alphabet.add(s);
//            } else {
//                nonAlphabet.add(s);
//                index.add(i);
//            }
//        }
//
//        int cur = 0, range = index.size() == 0 ? Integer.MIN_VALUE : index.poll();
//        while (cur < S.length()) {
//            if (cur == range) {
//                stringBuilder.append(nonAlphabet.poll());
//                range = index.size() == 0 ? range : index.poll();
//            } else {
//                stringBuilder.append(alphabet.pop());
//            }
//            cur++;
//        }
//
//        return stringBuilder.toString();
        
        char[] s = S.toCharArray();
        int left = 0, right = s.length - 1;
        
        while (left < right) {
            while (!isLetter(s[left]) && left < right) left++;
            while (!isLetter(s[right]) && left < right) right--;
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
        
        return new String(s);
    }
    
    private static boolean isLetter(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }
    
    public static void main(String[] args) {
//        int sum = 0;
//        for (int i = 1; i <= 10; i++) {
//            int level = 1;
//            for (int j = 1; j <= i; j++) {
//                level *= j;
//            }
//            sum += level;
//        }
//        System.out.println(sum);
//
//        for (int i = 1; i <= 9; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j + " x " + i + " = " + i * j + "  ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        for (int i = 10; i > 0; i--) {
//            for (int j = i; j > 0; j--) {
//                System.out.print(" ");
//            }
//            for (int k = 0; k < 20 - 2 * i - 1; k++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
    
        ReverseOnlyLetters demo = new ReverseOnlyLetters();
        String s = "q@asdsa88*Sd8as8d8as8dS*D8";
        String res = demo.reverseOnlyLetters(s);
        System.out.println(s);
        System.out.println(res);
    }
}
