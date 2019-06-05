package java.classify.binarysearch;

public class FindMinimumInRotatedSortedArray {

    /**
     * 0ms 100.00%
     * 38.3MB 5.05%
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1, middle;

        while (left < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) left = middle + 1;
            else right = middle;
        }

        return nums[left];
    }
}
