package classify.binary_search.medium;

public class SearchInRotatedSortedArray {

    /**
     * 0ms      100.00%
     * 38MB     92.52%
     *
     * Find pivot index first
     * Then use binary search to find target in subarray
     * according the relationship between target and the last element
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1, middle, pivot;

        // find pivot index
        while (left < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) left = middle + 1;
            else right = middle;
        }
        pivot = left;

        // Judge if target in the left of pivot or right
        left = target <= nums[nums.length - 1] ? pivot : 0;
        right = target <= nums[nums.length - 1] ? nums.length : pivot - 1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            else if (nums[middle] > target) right = middle - 1;
            else left = middle + 1;
        }

        return -1;
    }

    /**
     * Recursive
     * 0ms      100.00%
     * 37MB     95.46%
     */
    public int search2(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < nums[high]) {  // mid到high为有序部分
            return (nums[mid] < target && target <= nums[high]) ?  // 是否在有序部分
                    search(nums, mid + 1, high, target) :
                    search(nums, low, mid - 1, target);
        } else {  // low到mid为有序部分
            return (nums[low] <= target && target < nums[mid]) ?
                    search(nums, low, mid - 1, target) :
                    search(nums, mid + 1, high, target);
        }
    }
}
