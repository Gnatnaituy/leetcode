package classify.bit;

public class SingleNumberIII {

    /**
     * 1ms 97.73%
     * 36.7MB 69.32%
     */
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) diff ^= num;

        diff &= -diff;

        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }
}
