package others.completefifties.l0000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 */

public class FourSum {

    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        int i;
        
        for (i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    if (l > j + 1 && nums[l] == nums[l-1])
                        l++;
                    else if (nums[i] + nums[j] + nums[l] + nums[r] < target)
                        l++;
                    else if (nums[i] + nums[j] + nums[l] + nums[r] > target)
                        r--;
                    else {
                        List<Integer> list=new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        rs.add(list);
                        l++;
                        r--;
                    }
                }
            
            }
        }
        
        return rs;
    }
}
