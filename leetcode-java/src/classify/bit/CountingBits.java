package classify.bit;

public class CountingBits {

    /**
     * 1ms 99.79%
     * 37.1MB 50.80%
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;
    }
}