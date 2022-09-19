package classify.greedy.medium;

public class JumpGameII {

    /**
     * 1ms      99.06%
     * 41.7MB   83.82%
     */
    public int jump(int[] nums) {
        int reserve = 0, maxReserve = 0, res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReserve = Math.max(maxReserve, nums[i]);
            if (reserve == 0) {
                res++;
                reserve = maxReserve;
            }
            reserve--;
            maxReserve--;
        }

        return res;
    }

    /**
     * 1ms      99.06%
     * 41.6MB   88.06%
     */
    public int jump2(int[] nums) {
        int res = 0, end = 0, maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                res++;
            }
        }

        return res;
    }
}
