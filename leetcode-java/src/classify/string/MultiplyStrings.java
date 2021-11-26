package classify.string;

/**
 * @Author tiantang
 * @Date 2021/11/26
 */
public class MultiplyStrings {

    /**
     * 2ms      95.53%
     * 38.2MB   93.26%
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || "0".equals(num1)) {
            return "0";
        }
        if (num2 == null || num2.isEmpty() || "0".equals(num2)) {
            return "0";
        }

        int len1 = num1.length(), len2 = num2.length(), times = 0;
        int[] products = new int[len1 + len2];

        int n1, n2;
        for (int i = len1 - 1; i > -1; i--) {
            n1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j > -1; j--) {
                n2 = num2.charAt(j) - '0';
                products[len2 - 1 - j + times] += n1 * n2;
            }
            times++;
        }

        int shift = 0;
        int sum;
        for (int i = 0; i < products.length; i++) {
            sum = products[i] + shift;
            products[i] = sum % 10;
            shift = sum / 10;
        }

        int prodLen = products.length - 1;
        while (products[prodLen] == 0) {
            prodLen--;
        }

        StringBuilder sb = new StringBuilder();
        while (prodLen > -1) {
            sb.append(products[prodLen--]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("1", "456000"));
    }
}
