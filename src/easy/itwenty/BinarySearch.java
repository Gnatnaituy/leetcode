package easy.itwenty;

/**
 * 704 Binary Search
 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle = nums.length / 2;
        while (start <= end) {
            if (nums[middle] == target) 
                return middle;
            if (nums[middle] < target) {
                start = middle + 1;
                middle = (start + end) / 2;
            } else {
                end = middle - 1;
                middle = (start + end) / 2;
            }
        }

        return -1;
    }
}