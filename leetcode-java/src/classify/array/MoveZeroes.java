package classify.array;

public class MoveZeroes {

    /**
     * 34ms 9.59%
     * 39.9MB 8.12%
     */
    public void moveZeroes(final int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                for (;; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                    if (j == nums.length - 1) {
                        return;
                    }
                }
            }
        }
    }

    /**
     * 1ms 100.00%
     * 39.6MB 51.39%
     */
    public void moveZeroes2(final int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 2ms 59.82%
     * 39.8MB 26.81%
     */
    public void moveZeroes3(int[] nums) {
        int zeroNum = 0;// 用来计算0的个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {// 如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            } else if (zeroNum != 0) {// 如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i - zeroNum] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
