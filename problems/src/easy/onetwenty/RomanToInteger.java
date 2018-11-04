package easy.onetwenty;

public class RomanToInteger {

    private static int romanToInt(String s) {
        int resultInteger = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
                        resultInteger -= 1;
                    else
                        resultInteger += 1;
                    break;
                case 'V':
                    resultInteger += 5;
                    break;
                case 'X':
                    if (i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
                        resultInteger -= 10;
                    else
                        resultInteger += 10;
                    break;
                case 'L':
                    resultInteger += 50;
                    break;
                case 'C':
                    if (i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))
                        resultInteger -= 100;
                    else
                        resultInteger += 100;
                    break;
                case 'D':
                    resultInteger += 500;
                    break;
                case 'M':
                    resultInteger += 1000;
                    break;
                default:break;
            }
        }
        return resultInteger;
    }

    public static void main(String[] args) {
        String s = "V";
        System.out.print(romanToInt(s));
    }
}
