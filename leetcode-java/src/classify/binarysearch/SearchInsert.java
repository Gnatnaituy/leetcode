package classify.binarysearch;

public class SearchInsert {

    /**
     * 0ms      100.oo%
     * 38.2MB   22.96%
     * @param nums
     * @param target
     * @return
     */
    private int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right;
    }
}
