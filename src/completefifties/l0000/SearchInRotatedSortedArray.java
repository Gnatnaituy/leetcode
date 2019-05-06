package completefifties.l0000;


/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {

    /**
     * 15ms 55.59%
     * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
     * 此时有序部分用二分法查找。
     * 无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。
     * 就这样循环
     */
    private int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }
    
    private int search(int[] nums, int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

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

    /**
     * 8ms
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        //1. 找到旋转点
        int pivot = findMinIndex(nums);
        if (target == nums[pivot]) return pivot;

        //2. 判断target 是在旋转点左边还是右边。
        int start = (target <= nums[nums.length - 1]) ? pivot : 0;
        int end = (target <= nums[nums.length - 1]) ? nums.length : pivot - 1;

        //3. 因为左右都是已经排序的列表，不管是在左边还是右边，都可以使用二分查找
        while (start <= end) {
            int mid = (end + start) >>> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return - 1;
    }
    
    private int findMinIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) >>> 1;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }

        return start;
    }
}
