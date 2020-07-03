package completefifties.l0000;

public class SortColors {

    /**
     * 1ms 67.59%
     *
     * @param nums 0 -> red
     *             1 -> white
     *             2 -> blue
     */
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;

        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur, left);
                while (left < nums.length && nums[left] == 0) left++;
                if (cur < left) cur = left;
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
                while (right >= 0 && nums[right] == 2) right--;
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

    /**
     * 0ms
     */
    public void sortColors2(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;

        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[red];
                nums[red] = temp;
                red++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[blue];
                nums[blue] = temp;
                //此处的i--是为了防止换过来的还是2而被忽略
                i--;
                blue--;
            }
        }
    }
}
