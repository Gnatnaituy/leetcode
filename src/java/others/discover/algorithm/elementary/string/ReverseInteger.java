package java.others.discover.algorithm.elementary.string;

public class ReverseInteger {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
     */
    public int reverse(int x) {
        /*
        27ms 86.08%
         */
        char[] xchar = Integer.toString(x).toCharArray();
        int left = xchar[0] == '-' ? 1 : 0;
        int right = xchar.length - 1;

        while (left < right) {
            char temp = xchar[left];
            xchar[left] = xchar[right];
            xchar[right] = temp;
            left++;
            right--;
        }

        long res = Long.parseLong(new String(xchar));

        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }

    public int reverse2(int x) {
        /*
        15ms 100%
         */
        int result = 0;

        while (x != 0) {
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10)
                return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }
}
