package discover.algorithm.elementary.array;

public class MoveZero {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 1. 必须在原数组上操作，不能拷贝额外的数组
     * 2. 尽量减少操作次数
     *
     * @param nums int[]
     */
    public void moveZeroes(final int[] nums) {
        /*
        33ms 18.27%
         */
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                for (; ; j++) {
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

    public void moveZeroes2(final int[] nums) {
        /*
        2ms
         */
        int j = 0;
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j<nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        /*
        1ms
         */
        int zeroNum = 0;//用来计算0的个数
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {//如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            } else if (zeroNum != 0) {//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i - zeroNum] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
