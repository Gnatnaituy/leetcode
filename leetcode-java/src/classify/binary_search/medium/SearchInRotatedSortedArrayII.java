package classify.binary_search.medium;

public class SearchInRotatedSortedArrayII {

    /**
     * 0ms      100.00%
     * 41.4MB   32.00%
     */
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }
    
    private boolean search(int[] nums, int target, int left, int right) {
        if (left > right) return false;

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return true;
        }

        while (nums[right] == nums[mid] && right > mid) right--;
        while (nums[left] == nums[mid] && left < mid) left++;

        if (nums[mid] <= nums[right]) {
            return (nums[mid] < target && target <= nums[right])
                ? search(nums, target, mid + 1, right)
                : search(nums, target, left, mid - 1);
        } else {
            return (nums[left] <= target && target < nums[mid])
                ? search(nums, target, left, mid - 1)
                : search(nums, target, mid + 1, right);
        }
    }

    /**
     * 0ms      100.00%
     * 41.6MB   5.05%
     */
    public boolean search2(int[] nums, int target) {
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
