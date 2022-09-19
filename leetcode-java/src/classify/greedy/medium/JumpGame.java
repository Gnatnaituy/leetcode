package classify.greedy.medium;

public class JumpGame {

    /**
     * 2ms      94.29%
     * 41.9MB   61.90%
     */
    public boolean canJump(int[] nums) {
        int reserve = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > reserve) {
                reserve = nums[i];
            }
            if (reserve == 0) {
                return false;
            }
            reserve--;
        }

        return reserve >= 0;
    }

    /**
     * 2ms      94.29%
     * 41.9MB   61.90%
     */
    public boolean canJump2(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            } else {
                farthest = Math.max(farthest, i + nums[i]);
            }
        }

        return true;
    }
}
