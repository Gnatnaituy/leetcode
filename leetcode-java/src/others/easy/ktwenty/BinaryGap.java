package others.easy.ktwenty;

/**
 * 868 Binary Gap
 */

public class BinaryGap {

    public int binaryGap(int N) {
        int max = 0, count = 0;

        while (N % 2 == 0) N /= 2;

        while (N >= 1) {
            if (N % 2 == 0 && count > 0) {
                count++;
            } else {
                max = max > count ? max : count; 
                count = 1;
            }
            N /= 2;
        }

        return max;
    }
}