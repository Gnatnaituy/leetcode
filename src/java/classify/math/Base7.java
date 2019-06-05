package java.classify.math;

public class Base7 {

    /**
     * 1ms 97.27%
     * 33.3MB 100.00%
     */
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        boolean neg = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (neg) sb.append("-");

        return sb.reverse().toString();
    }
}
