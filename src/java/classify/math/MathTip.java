package java.classify.math;

public class MathTip {

    public static void main(String[] args) {
        System.out.println(resolvePrime(12580));
        System.out.println(maxCommonDivisor(125, 35));
        System.out.println(minCommonMultiple(23, 45));
    }

    /**
     * 质数分解
     */
    private static String resolvePrime(int num) {
        StringBuilder sb = new StringBuilder(num + " = ");

        int i = 2;
        while (i <= num) {
            if (num % i == 0) {
                sb.append(i).append(" * ");
                num /= i;
            } else {
                i++;
            }
        }

        return sb.toString().substring(0, sb.toString().length() - 2);
    }

    /**
     * 最大公约数 递归法
     */
    private static int maxCommonDivisor(int m, int n) {
        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }

        if (m % n == 0) {
            return n;
        } else {
            return maxCommonDivisor(n, m % n);
        }
    }

    /**
     * 最大公约数 循环法
     */
    public static int maxCommonDivisor2(int m, int n) {
        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }

        while (m % n != 0) {
            int t = m % n;
            m = n;
            n = t;
        }

        return n;
    }

    /**
     * 最小公倍数
     */
    public static int minCommonMultiple(int m, int n) {

        return m * n / maxCommonDivisor(m , n);
    }
}
