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
}
