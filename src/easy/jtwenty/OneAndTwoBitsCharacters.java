package easy.jtwenty;


/**
 * 717 1-bit and 2bit Characters
 */

public class OneAndTwoBitsCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 2) {
            if (bits[i] == 1) i += 2;
            else i++;
        }
        return bits[i] == 0;
    }
}