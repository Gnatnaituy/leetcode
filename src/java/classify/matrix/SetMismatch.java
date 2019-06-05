package java.classify.matrix;

public class SetMismatch {

    /**
     * 2ms 99.41%
     * 39MB 99.30%
     */
    public int[] findErrorNums(int[] nums) {
        boolean[] present = new boolean[10001];
        int sum = 0;
        int miss = 0;

        for (int num : nums) {
            if (present[num]) {
                miss = num;
            }
            present[num] = true;
            sum += num;
        }

        int originSum = nums.length % 2 == 0 ? (nums.length + 1) * (nums.length / 2)
                : (nums.length + 1) * (nums.length / 2) + (nums.length + 1) / 2;

        return new int[]{miss, miss + originSum - sum};
    }

    /**
     * 排序法
     */
    public int[] findErrorNums2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }

        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
