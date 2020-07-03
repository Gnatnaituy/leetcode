package completefifties.l0000;

public class RemoveDuplicatesFromSortedArrayII {

    /**
     * 2ms 91.59%
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;

        int slow = 0;
        int fast = 0;
        int count = 0;

        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count < 3) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}
