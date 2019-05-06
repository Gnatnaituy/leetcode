package huahua.binarysearch;

public class BinarySearch {

    /**
     * 0ms 100.00%
     * 40.7MB 52.39%
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1, middle;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (nums[middle] == target) return middle;
            else if (nums[middle] < target) left = middle + 1;
            else right = middle - 1;
        }

        return -1;
    }
}
