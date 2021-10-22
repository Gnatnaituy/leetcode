package others.completefifties.l0000;


/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 8ms 34.49%
     */
    private int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                int front = mid;
                int tail = mid;
                while (front > -1 && nums[front] == target) front--;
                while (tail < nums.length && nums[tail] == target) tail++;
                return new int[]{front + 1, tail - 1};
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (nums.length == 1 && nums[0] == target)
            return new int[]{0, 0};
        else
            return new int[]{-1, -1};
    }

    /**
     * 5ms 92.71%
     * 两遍二分查找 一个找左边 一个找右边
     */
    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[]{-1, -1};

        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }else  {
                left = mid + 1;
            }
        }
        if(left < nums.length && nums[left] == target) {
            res[0] = left;
        }
        left = 0;
        right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if(right >= 0 && nums[right] == target) {
            res[1] = right;
        }
        return res;
    }
}
