package java.classify.binarysearch;

public class SingleElementInASortedArray {

    /**
     * 0ms 100.00%
     * 36MB 93.97%
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid % 2 == 1) {
                mid--; // 保证 left/mid/right 一直都在偶数位，使得查找区间大小一直是奇数
            }

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
