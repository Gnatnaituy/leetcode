package classify.dp;

public class CountingBits {

    /**
     * 1ms 99.82%
     * 37MB 100.00%
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++)
            res[i] = res[i >> 1] + (i & 1);

        return res;
    }
}
