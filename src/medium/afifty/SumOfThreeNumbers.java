package medium.afifty;

import java.util.*;

/**
 * 15. 3Sum
 */

public class SumOfThreeNumbers {
    
    private List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (num > 0) break;
                    if (num == 0) {
                        List<Integer> re = new ArrayList<>();
                        re.add(nums[i]);
                        re.add(nums[j]);
                        re.add(nums[k]);
                        set.add(re);
                        break;
                    }
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}