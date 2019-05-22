package classify.bit;

public class MissingNumber {

    /**
     * 0ms 100.00%
     * 38.3MB 71.86%
     */
    public int missingNumber(int[] nums) {
        int xor = 0, i;

        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
