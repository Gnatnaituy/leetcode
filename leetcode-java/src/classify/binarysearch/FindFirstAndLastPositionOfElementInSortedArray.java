package classify.binarysearch;

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


    /**
     * 0ms      100.00%
     * 41.6MB   62.97%
     * 情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
     * 情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
     * 情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int leftBorder = findLeftBorder(nums, target);
        int rightBorder = findRightBorder(nums, target);

        // 情况一
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }

        // 情况三
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }

        // 情况二
        return new int[]{-1, -1};
    }

    private int findLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1, leftBorder = -2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                leftBorder = right;
            }
        }

        return leftBorder;
    }

    private int findRightBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1, rightBorder = -2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }

        return rightBorder;
    }
}
