package others.easy.itwenty;

/**
 * 693 Binary Number with Alternating Bits
 */

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        char[] binaryN = Integer.toBinaryString(n).toCharArray();
        int length = binaryN.length;
        while(length > 1) {
            if (binaryN[length - 1] == binaryN[length - 2]) {
                return false;
            }
            length--;
        }

        return true;

        // fastest
        // int a=n^(n>>1);
        // return (a&a+1)==0;
    }
}