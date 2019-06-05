package java.classify.matrix;

public class FindTheDuplicateNumber {

    /**
     * 0ms 100.00%
     * 34.8MB 76.98%
     */
    public int findDuplicate(int[] nums) {
        boolean[] appears = new boolean[nums.length];

        for (int num : nums) {
            if (appears[num]) {
                return num;
            }
            appears[num] = true;
        }

        return 0;
    }
}
