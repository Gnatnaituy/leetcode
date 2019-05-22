package classify.bit;

public class SingleNumber {

    /**
     * 1ms 48.49%
     * 38.3MB 86.52%
     */
    public int singleNummber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
