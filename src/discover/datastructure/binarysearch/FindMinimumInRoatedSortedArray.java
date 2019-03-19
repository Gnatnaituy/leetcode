package discover.datastructure.binarysearch;


/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class FindMinimumInRoatedSortedArray {

    /**
     * 1ms 81.86%
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int res = nums[0];

        for (; start <= end; start++, end--) {
            res = res < nums[start] ? res : nums[start];
            res = res < nums[end] ? res : nums[end];
        }

        return res;
    }

    /**
     * 0ms
     */
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        return nums[left];
    }
}
