package others.discover.algorithm.elementary.array;

public class PlusOne {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字
     * 你可以假设除了整数 0 之外，这个整数不会以零开头
     */
    public int[] plusOne(int[] digits) {
        /*
        0ms 100%
         */
        boolean shift = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (!shift) break;
            if (digits[i] + 1 < 10) shift = false;
            digits[i] = (digits[i] + 11) % 10;
        }

        int[] res;
        if (shift) {
            res = new int[digits.length];
            res[0] = 1;
        } else {
            res = digits;
        }

        return res;
    }
}
