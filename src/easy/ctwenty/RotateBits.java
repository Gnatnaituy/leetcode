package easy.ctwenty;


/**
 * 190 Rotate Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example:
 *
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 *              return 964176192 represented in binary as 00111001011110000010100101000000.
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */

public class RotateBits {

    // Copied
    private static int reverse(int n) {
        int rev = 0;

        // traversing bits of 'n'
        // from the right
        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((n & (1 << i)) != 0)
                rev |= 1;
        }
        // required number
        return rev;
    }
}
