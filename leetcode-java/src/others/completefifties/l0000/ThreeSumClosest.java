package others.completefifties.l0000;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 */

public class ThreeSumClosest {
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                } else if (threeSum < target) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                } else {
                    return target;
                }
            }
        }
        
        return closestNum;
    }
}
