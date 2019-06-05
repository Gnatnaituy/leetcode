package java.classify.matrix;

public class MoveZeroes {

    /**
     * 9ms 15.10%
     * 36.6MB 99.55%
     */
    public void moveZeroes(int[] nums) {
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] == 0) {
                int minNonZeroIndex = cur;
                while (nums[minNonZeroIndex] == 0) {
                    minNonZeroIndex++;
                    if (minNonZeroIndex == nums.length) return;
                }
                nums[cur] = nums[minNonZeroIndex];
                nums[minNonZeroIndex] = 0;
            }
        }
    }

    /**
     * 0ms
     */
    public void moveZeroes2(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (count != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[i - count];
                    nums[i - count] = tmp;
                    count--;
                    i--;
                }
            }
        }
    }
}
