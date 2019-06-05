package java.classify.binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 0ms 100.00%
     * 44.2MB 5.19%
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int left = 0, right = nums.length - 1;
        int middle, start, end;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                start = end = middle;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }
                while (end < nums.length && nums[end] == target) {
                    end++;
                }

                return new int[]{start + 1, end - 1};
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
