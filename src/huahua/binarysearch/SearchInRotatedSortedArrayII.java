package huahua.binarysearch;

public class SearchInRotatedSortedArrayII {

    /**
     * 1ms 36.74%
     * 41.5MB 5.52%
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (nums[middle] == target) return true;

            if (nums[middle] > nums[left] || nums[middle] > nums[right]) {
                // For this condition we know left side is sorted and right side is unsorted
                if (nums[left] <= target && target <= nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle] < nums[right] || nums[middle] < nums[left]) {
                // For this condition we know right side is sorted and left side is unsorted
                if (nums[middle] <= target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                left++;  // right-- is the same because nums[left] == nums[middle] == nums[right]
            }
        }

        return false;
    }
}
