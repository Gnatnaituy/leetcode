package classify.binary_search;

public class SearchInsertPosition {

    /**
     * 0ms 100.00%
     * 39.6MB 5.03%
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) {
                return i;
            }
        }

        return nums.length;
    }

    /**
     * Binary search
     * 0ms 100.00%
     * 39.6MB 5.67%
     */
    public int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    /**
     * 0ms
     */
    public int searchInsert3(int[] nums, int target) {
        int index = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            } else if (nums[i] > target) {
                index = i;
                break;
            }
        }

        return index;
    }
}
