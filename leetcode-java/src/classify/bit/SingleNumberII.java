package classify.bit;

public class SingleNumberII {

    /**
     * 0ms 100.00%
     * 35.7MB 80.43%
     */
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = -1;

        for (int num : nums) {
            ones = ones ^ num & twos;
            twos = twos ^ num & ones;
        }

        return ones;
    }
}
