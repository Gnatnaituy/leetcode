package classify.array;

class RemoveDuplicateInSortedArray {

    /**
     * 1ms 99.76%
     * 40.2MB 89.33%
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }

        return ++slow;
    }
}