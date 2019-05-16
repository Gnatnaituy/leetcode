package classify.greedy;

public class NonDecreasingArray {

    /**
     * 1ms 100.00%
     * 39.3MB 91.02%
     */
    public boolean checkPossibility(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }

        return count <= 1;
    }
}
