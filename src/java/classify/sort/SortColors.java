package java.classify.sort;

public class SortColors {

    /**
     * 0ms 100.00%
     * 34.5MB 100.00%
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int findZero = nums.length - 1;

        while (left < right) {
            if (nums[left] == 2) {
                swap(nums, left, right);
                right--;
            } else if (nums[left] == 1) {
                while (findZero > - 1 && nums[findZero] != 0)
                    findZero--;
                if (findZero > left) {
                    swap(nums, left, findZero);
                }
                left++;
            } else {
                left++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
