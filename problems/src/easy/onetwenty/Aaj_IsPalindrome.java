package easy.onetwenty;

public class Aaj_IsPalindrome {

    public static void main(String[] args) {
        int x = 123211;

        String reverseNumber = new StringBuilder(String.valueOf(x)).reverse().toString();
        boolean result = reverseNumber.equals(String.valueOf(x));

        System.out.println(result);
    }
}
