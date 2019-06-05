package java.classify.math;

public class ProductOfArrayExceptSelf {

    /**
     * 1ms 100.00%
     * 42.2MB 58.57%
     */
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        int[] res = new int[nums.length];

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        if (zeroCount > 1) {
            return res;
        } else if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i] == 0 ? product : 0;
            }
        } else if (zeroCount == 0) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i] == 0 ? product : product / nums[i];
            }
        }

        return res;
    }
}
