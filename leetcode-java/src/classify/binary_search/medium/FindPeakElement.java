package classify.binary_search.medium;

public class FindPeakElement {

    /**
     * 不断排除无效区间
     * 0ms      100.00%
     * 39.3MB   12.35%
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
