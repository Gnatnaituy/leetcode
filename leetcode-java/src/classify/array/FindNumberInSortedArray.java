package classify.array;

/**
 * @author yutiantang
 * @create 2021/10/20 18:15
 */
public class FindNumberInSortedArray {

    /**
     * 遍历
     * 1ms      26.55%
     * 41.4MB   42.40%
     */
    public int search(int[] nums, int target) {
        int res = 0;
        for (int num : nums) {
            if (num == target) {
                res++;
            }
        }
        return res;
    }

    /**
     * 双指针
     * 0ms      100.00%
     * 41.6MB   5.20%
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < nums.length && nums[start] < target) {
            start++;
        }
        while (end >= 0 && nums[end] > target) {
            end--;
        }

        int diff = end - start + 1;

        return Math.max(diff, 0);
    }

    /**
     * 二分查找
     * 0ms      100.00%
     * 41.1MB   86.83%
     * @param nums
     * @param target
     * @return
     */
    public static int search3(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int start = mid, end = mid;
                while (start >= left && nums[start] == target) start--;
                while (end <= right && nums[end] == target) end++;
                return end - start - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(search3(new int[]{5,5,5,5}, 4));
        System.out.println(search3(new int[]{5,5,5,5}, 5));
        System.out.println(search3(new int[]{5}, 5));
        System.out.println(search3(new int[]{}, 5));
        System.out.println(search3(new int[]{5,7,7,8,8,10}, 4));
        System.out.println(search3(new int[]{5,7,7,8,8,10}, 5));
        System.out.println(search3(new int[]{5,7,7,8,8,10}, 6));
        System.out.println(search3(new int[]{5,7,7,8,8,10}, 7));
        System.out.println(search3(new int[]{5,7,7,8,8,10}, 8));
        System.out.println(search3(new int[]{5,7,7,8,8,10}, 9));
        System.out.println(search3(new int[]{5,7,7,8,8,10}, 10));
        System.out.println(search3(new int[]{5,7,7,8,8,10}, 11));
    }
}
