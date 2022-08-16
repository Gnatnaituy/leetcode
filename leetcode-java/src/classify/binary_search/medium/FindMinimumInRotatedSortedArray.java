package classify.binary_search.medium;

public class FindMinimumInRotatedSortedArray {

    /**
     * 0ms      100.00%
     * 41.6MB   5.11%
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, middle;
        while (left < right - 1) {
            middle = left + (right - left) / 2;
            if (nums[middle] <= nums[right]) {
                right = middle;
            } else {
                left = middle;
            }
        }

        return Math.min(nums[left], nums[right]);
    }
    
    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1, middle;

        while (left < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return nums[left];
    }
}
